package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.ValoInfoService;
import com.game.service.impl.ValoInfoServiceImpl;
import com.game.vo.ValoInfoVO;
import com.google.gson.Gson;

@WebServlet("/valo-info/*")
public class ValoInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ValoInfoService valoInfoService = new ValoInfoServiceImpl();
    private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			ValoInfoVO valo = new ValoInfoVO();
			valo.setSearchType(request.getParameter("searchType"));
			valo.setSearchStr(request.getParameter("searchStr"));
			json = gson.toJson(valoInfoService.selectValoInfoList(valo));
		}else if("view".equals(cmd)){
			json = gson.toJson(valoInfoService.selectValoInfo(request.getParameter("viNum")));
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
