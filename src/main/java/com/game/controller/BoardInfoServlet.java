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

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;

@WebServlet("/board-info/*")
public class BoardInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardInfoService biService = new BoardInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			Map<String, String> boardInfo = new HashMap<>();
			List<Map<String, String>> boardInfoList = biService.selectBoardInfoList(boardInfo);
			request.setAttribute("boardInfoList", boardInfoList);
		}else if("view".equals(cmd)){
			String biNum = request.getParameter("biNum");
			Map<String, String> boardInfo = biService.selectBoardInfo(biNum);
			request.setAttribute("boardInfo", boardInfo);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
