package com.game.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/input/*")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str=br.readLine()) != null) {
			sb.append(str);
		}
		Map<String, String> map = gson.fromJson(sb.toString(), Map.class);
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("이름 : " + map.get("name"));
		out.println("아이디 : " + map.get("id"));
		out.println("비밀번호 : " + map.get("pwd"));
		out.println("자기소개 : " + map.get("desc"));
		out.println("성별 : " + map.get("trans"));
		out.println("직업 : " + map.get("job"));
	}

}
