package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.LectureInfoService;
import com.game.service.impl.LectureInfoServiceImpl;
import com.game.vo.LectureInfoVO;
import com.google.gson.Gson;

@WebServlet("/lecture-info/*")
public class LectureInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LectureInfoService lectureInfoService = new LectureInfoServiceImpl();
	private Gson gson = new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			LectureInfoVO search = new LectureInfoVO();
			search.setSearchType(request.getParameter("searchType"));
			search.setSearchStr(request.getParameter("searchStr"));
			json = gson.toJson(lectureInfoService.getLectureInfoList(search));
		}else if("view".equals(cmd)) {
			json = gson.toJson(lectureInfoService.getLectureInfo(request.getParameter("liNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
