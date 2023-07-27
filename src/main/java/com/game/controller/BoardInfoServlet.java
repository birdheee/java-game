package com.game.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;

@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoService boardInfoService = new BoardInfoServiceImpl();

	private boolean isLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) { // 로그인을 안했다는 얘기임
			request.setAttribute("msg", "로그인이 필요합니다.");
			request.setAttribute("url", "/user-info/login");
			CommonView.forwardMessage(request, response);
			return false;
		}
		return true;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isLogin(request, response)) { // 로그인이 안되어 있으면
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!isLogin(request, response)) { // 로그인이 안되어 있으면
			return;
		}
	}

}
