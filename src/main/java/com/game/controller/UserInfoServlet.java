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
		}else if("insert".equals(cmd)) {
			
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		if("insert".equals(cmd)) {
			Map<String, String> userInfo = new HashMap<>();
			userInfo.put("uiName", request.getParameter("uiName"));
			userInfo.put("uiId", request.getParameter("uiId"));
			userInfo.put("uiPwd", request.getParameter("uiPwd"));
			userInfo.put("uiDesc", request.getParameter("uiDesc"));
			userInfo.put("uiBirth", request.getParameter("uiBirth"));
			int result = uiService.insertUserInfo(userInfo);
		}
		
	}

}
