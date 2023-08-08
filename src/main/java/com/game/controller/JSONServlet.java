package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;
import com.game.vo.BoardInfoVO;
import com.google.gson.Gson;

@WebServlet("/json/*")
public class JSONServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private BoardInfoService biService = new BoardInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = "";
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			BoardInfoVO board = new BoardInfoVO(); // 검색 파라미터
			board.setSearchType(request.getParameter("searchType"));
			board.setSearchStr(request.getParameter("searchStr"));
			json = gson.toJson(biService.selectBoardInfoList(board)); // 자바 구조를 JSON 구조로 변환
		}else if("one".equals(cmd)){
			String biNum = request.getParameter("biNum");
			json = gson.toJson(biService.selectBoardInfo(biNum));
		}
	    // response.setHeader("Access-Control-Allow-Origin", "*"); // CORS 허락
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
