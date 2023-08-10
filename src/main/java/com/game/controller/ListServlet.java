package com.game.controller;

import java.io.BufferedReader;
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

import com.game.common.CommonView;
import com.google.gson.Gson;

@WebServlet("/list/*")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();
	private static final List<Map<String,String>> MOCK_LIST;
	static {
		MOCK_LIST = new ArrayList<>();
		for(int i=1;i<=100;i++) {
			Map<String,String> map = new HashMap<>();
			map.put("num",i+"");
			map.put("name", "이름" + i);
			map.put("age", i+"살");
			map.put("address", "서울 어딘가");
			MOCK_LIST.add(map);
		}
	}
	//http://localhost/list/one?num=14 => /list/one
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			json = gson.toJson(MOCK_LIST);
		}else if("one".equals(cmd)) {
			String num = request.getParameter("num"); //14
			if(num!=null) {
				for(Map<String,String> map : MOCK_LIST) {
					if(map.get("num").equals(num)) {
						json = gson.toJson(map);
						break;
					}
				}
			}
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();
		StringBuffer sb = new StringBuffer();
		String str = null;
		while((str=br.readLine())!=null) {
			sb.append(str);
		}
		Map<String,String> map = gson.fromJson(sb.toString(), Map.class);
		
		String cmd = CommonView.getCmd(request);
		String json = "0";
		
		if("insert".equals(cmd)) {
			map.put("num", MOCK_LIST.size()+1+"");
			if(MOCK_LIST.add(map)) {
				json = "1";
			}
		}else if("delete".equals(cmd)) {
			String num = request.getParameter("num");
			if(num!=null) {
				for(Map<String,String> obj : MOCK_LIST) {
					if(obj.get("num").equals(num)) {
						if(MOCK_LIST.remove(obj)) {
							json = "1";
						}
						break;
					}
				}
			}
		}else if("update".equals(cmd)) {
			String num = request.getParameter("num");
			if(num!=null && map.get("num") != null) {
				for(Map<String,String> obj : MOCK_LIST) {
					if(obj.get("num").equals(num)) {
						MOCK_LIST.set(Integer.parseInt(num)-1, map);
						json = "1";
						break;
					}
				}
			}
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}

}
