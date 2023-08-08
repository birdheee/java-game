package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String searchType = request.getParameter("searchType");
		String searchStr = request.getParameter("searchStr");
		BoardInfoVO board = new BoardInfoVO();
		board.setSearchType(searchType);
		board.setSearchStr(searchStr);
		
		List<BoardInfoVO> biList = biService.selectBoardInfoList(board);
		String json = gson.toJson(biList); // 자바 구조를 JSON 구조로 변환
	    // response.setHeader("Access-Control-Allow-Origin", "*"); // CORS 허락. 요즘은 프론트 백 서버를 다르게 함
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
