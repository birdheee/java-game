package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.common.JSON;
import com.game.service.UserInfoService;
import com.game.service.impl.UserInfoServiceImpl;
import com.google.gson.Gson;

@WebServlet("/user-info/*")

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoService userInfoService = new UserInfoServiceImpl();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(userInfoService.getUserInfoList(null));
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			json = gson.toJson(userInfoService.getUserInfo(request.getParameter("uiNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		Map<String, String> userInfo = JSON.parse(request, Map.class);
		
		if(userInfo.get("uiBirth")!=null) {
			userInfo.put("uiBirth", userInfo.get("uiBirth").replace("-", ""));
		}
		
		int result = 0;
		if("insert".equals(cmd)) {
			result = userInfoService.addUserInfo(userInfo);
		}
		
//		}else if("update".equals(cmd)) {
//			String uiNum = request.getParameter("uiNum");
//			userInfo.put("uiNum", uiNum);
//			result = UserInfoServlet.updateUserInfo(userInfo);
//			request.setAttribute("msg", "수정 완료");
//			request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
//			if(result!=1) {
//				request.setAttribute("msg", "수정 실패");
//				request.setAttribute("url", "/user-info/update?uiNum=" + uiNum);
//			}
//		}else if("delete".equals(cmd)) {
//			String uiNum = request.getParameter("uiNum");
//			result = UserInfoServlet.deleteUserInfo(uiNum);
//			request.setAttribute("msg", "삭제 완료");
//			request.setAttribute("url", "/user-info/list");
//			if(result!=1) {
//				request.setAttribute("msg", "삭제 실패");
//				request.setAttribute("url", "/user-info/view?uiNum=" + uiNum);
//			}
//		}else if("login".equals(cmd)) {
//			request.setAttribute("msg", "아이디나 비밀번호를 확인하세요");
//			request.setAttribute("url","/user-info/login");
//			HttpSession session = request.getSession(); // 브라우저 하나당 세션이 생김
//			
//			boolean login = UserInfoServlet.login(userInfo, session);
//			if(login) {
//				request.setAttribute("msg", "로그인을 완료하였습니다.");
//				request.setAttribute("url","/");
//			}
//		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result); // 1이면 정상 동작
	}
}
