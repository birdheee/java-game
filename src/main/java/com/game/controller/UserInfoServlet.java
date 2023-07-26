package com.game.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		}else if("view".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}else if("update".equals(cmd)) {
			String uiNum = request.getParameter("uiNum");
			Map<String, String> userInfo = uiService.selectUserInfo(uiNum);
			request.setAttribute("userInfo", userInfo);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = CommonView.getCmd(request);
		if("insert".equals(cmd)) {
			Map<String, String> userInfo = new HashMap<>();
			userInfo.put("uiId", request.getParameter("uiId"));
			userInfo.put("uiName", request.getParameter("uiName"));
			userInfo.put("uiPwd", request.getParameter("uiPwd"));
			userInfo.put("uiDesc", request.getParameter("uiDesc"));
			userInfo.put("uiBirth", request.getParameter("uiBirth").replace("-","")); // '-' 를 빈문자로
			int result = uiService.insertUserInfo(userInfo);
			request.setAttribute("msg", "등록 완료");
			request.setAttribute("url", "/user-info/login");
			if(result!=1) {
				request.setAttribute("msg", "등록 실패");
				request.setAttribute("url", "/user-info/insert");
			}
		}else if("update".equals(cmd)) {
			Map<String, String> userInfo = new HashMap<>();
			userInfo.put("uiNum", request.getParameter("uiNum"));
			userInfo.put("uiName", request.getParameter("uiName"));
			userInfo.put("uiPwd", request.getParameter("uiPwd"));
			userInfo.put("uiDesc", request.getParameter("uiDesc"));
			userInfo.put("uiBirth", request.getParameter("uiBirth").replace("-", ""));
			int result = uiService.updateUserInfo(userInfo);
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			if(result!=1) {
				request.setAttribute("msg", "수정 실패");
				request.setAttribute("url", "/user-info/update?uiNum=" + request.getParameter("uiNum"));
			}
		}else if("delete".equals(cmd)) {
			int result = uiService.deleteUserInfo(request.getParameter("uiNum"));
			request.setAttribute("msg", "삭제 완료");
			request.setAttribute("url", "/user-info/list");
			if(result!=1) {
				request.setAttribute("msg", "삭제 실패");
				request.setAttribute("url", "/user-info/view?uiNum=" + request.getParameter("uiNum"));
			}
		}
		CommonView.forwardMessage(request, response);
		
	}

}
