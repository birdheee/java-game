package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.game.common.CommonView;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;

@WebServlet("/user-info/*")

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService uiService = new UserInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			Map<String, String> userInfo = new HashMap<>();
			List<Map<String,String>> userInfoList = uiService.selectUserInfoList(userInfo);
			request.setAttribute("userInfoList", userInfoList);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("logout".equals(cmd)) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.setAttribute("msg", "로그아웃 되었습니다");
			request.setAttribute("url", "/user-info/login");
			CommonView.forwardMessage(request, response);
			return;
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		
		Map<String, String> userInfo = new HashMap<>();
		userInfo.put("uiName", request.getParameter("uiName"));
		userInfo.put("uiPwd", request.getParameter("uiPwd"));
		userInfo.put("uiDesc", request.getParameter("uiDesc"));
		userInfo.put("uiId", request.getParameter("uiId"));
		if(request.getParameter("uiBirth")!=null) {
			userInfo.put("uiBirth", request.getParameter("uiBirth").replace("-", ""));
		}
		
		if("insert".equals(cmd)) {
			int result = uiService.insertUserInfo(userInfo);
			request.setAttribute("msg", "등록 완료");
			request.setAttribute("url", "/user-info/login");
			if(result!=1) {
				request.setAttribute("msg", "등록 실패");
				request.setAttribute("url", "/user-info/insert");
			}
		}else if("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			userInfo.put("uiNum", uiNum);
			int result = uiService.updateUserInfo(userInfo);
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
			if(result!=1) {
				request.setAttribute("msg", "수정 실패");
				request.setAttribute("url", "/user-info/update?uiNum=" + uiNum);
			}
		}else if("delete".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			int result = uiService.deleteUserInfo(uiNum);
			request.setAttribute("msg", "삭제 완료");
			request.setAttribute("url", "/user-info/list");
			if(result!=1) {
				request.setAttribute("msg", "삭제 실패");
				request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
			}
		}else if("login".equals(cmd)) {
			request.setAttribute("msg", "아이디나 비밀번호를 확인하세요");
			request.setAttribute("url","/user-info/login");
			HttpSession session = request.getSession(); // 브라우저 하나당 세션이 생김
			
			// 더 쉬운 방법
			String uiId = request.getParameter("uiId");
			String uiPwd = request.getParameter("uiPwd");
			Map<String, String> ui = uiService.login(uiId);
			if(ui!=null) {
				String dbUiPwd = ui.get("uiPwd");
				if(uiPwd.equals(dbUiPwd)) {
					request.setAttribute("msg", "로그인 성공");
					request.setAttribute("url","/");
					session.setAttribute("user", ui);
				}
			}
			
//			boolean login = uiService.login(userInfo, session);
//			if(login) {
//				request.setAttribute("msg", "로그인을 완료하였습니다.");
//				request.setAttribute("url","/");
//			}
		}
		CommonView.forwardMessage(request, response);
	}
}
