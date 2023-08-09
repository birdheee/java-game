package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/list/*")
public class Listservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final List<Map<String, String>> MOCK_LIST;
	private Gson gson = new Gson();
	static {
		MOCK_LIST = new ArrayList<>();
		for(int i=1; i<=100; i++) {
			Map<String, String> map = new HashMap<>();
			map.put("num", i+"");
			map.put("name", "이름" + i);
			map.put("age", i+"살");
			map.put("address", "서울 어딘가");
			MOCK_LIST.add(map);
		}
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
		String json = gson.toJson(MOCK_LIST);
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
