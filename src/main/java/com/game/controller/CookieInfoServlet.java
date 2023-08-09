package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.CookieInfoService;
import com.game.service.impl.CookieInfoServiceImpl;
import com.game.vo.CookieInfoVO;
import com.google.gson.Gson;

@WebServlet("/cookie-info/*")
public class CookieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CookieInfoService cookieInfoService = new CookieInfoServiceImpl();
	private Gson gson = new Gson();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)){
			CookieInfoVO cookie = new CookieInfoVO();
			cookie.setSearchType(request.getParameter("searchType"));
			cookie.setSearchStr(request.getParameter("searchStr"));
			json = gson.toJson(cookieInfoService.getCookieInfoList(cookie));
		}else if("view".equals(cmd)) {
			json = gson.toJson(cookieInfoService.getCookieInfo(request.getParameter("ciNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
