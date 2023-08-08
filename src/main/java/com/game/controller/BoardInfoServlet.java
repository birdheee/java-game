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
import javax.servlet.http.HttpSession;

import com.game.common.CommonView;
import com.game.service.BoardInfoService;
import com.game.service.impl.BoardInfoServiceImpl;
import com.game.vo.BoardInfoVO;

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
		String cmd = CommonView.getCmd(request);
		if("list".equals(cmd)) {
			String value = request.getParameter("searchStr");
			Map<String, String> param = new HashMap<>();
			if(value!=null && value.length()!=0) {
				String key = request.getParameter("searchType");
				param.put("key", key);
				param.put("value", value);
			}
			List<BoardInfoVO> boardInfoList = boardInfoService.selectBoardInfoList(null);
			request.setAttribute("boardInfoList", boardInfoList);
		}else if("view".equals(cmd) || "update".equals(cmd)) {
			Map<String, String> boardInfo = boardInfoService.selectBoardInfo(request.getParameter("biNum"));
			request.setAttribute("boardInfo", boardInfo);
		}
		CommonView.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(!isLogin(request, response)) { // 로그인이 안되어 있으면
			return;
		}
		String cmd = CommonView.getCmd(request);
		HttpSession session = request.getSession();
		Map<String, String> user = (Map<String, String>)session.getAttribute("user");
		if("insert".equals(cmd)) {
			Map<String, String> param = new HashMap<>();
			param.put("biTitle", request.getParameter("biTitle"));
			param.put("biContent", request.getParameter("biContent"));
			param.put("uiNum", user.get("uiNum"));
			int result = boardInfoService.insertBoardInfo(param);
			request.setAttribute("msg", "등록 안됨");
			request.setAttribute("url", "/board-info/insert");
			if(result==1) {
				request.setAttribute("msg", "등록되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
		}else if("update".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			Map<String, String> param = new HashMap<>();
			param.put("biTitle", request.getParameter("biTitle"));
			param.put("biContent", request.getParameter("biContent"));
			param.put("biNum", biNum);
			param.put("uiNum", user.get("uiNum"));
			int result = boardInfoService.updateBoardInfo(param);
			request.setAttribute("msg", "수정 안됨");
			request.setAttribute("url", "/board-info/update?biNum=" + biNum);
			if(result==1) {
				request.setAttribute("msg", "수정되었습니다.");
				request.setAttribute("url", "/board-info/view?biNum=" + biNum);
			}
		}else if("delete".equals(cmd)) {
			String biNum = request.getParameter("biNum");
			int result = boardInfoService.deleteBoardInfo(biNum);
			request.setAttribute("msg", "삭제 안됨");
			request.setAttribute("url", "/board-info/view?biNum=" + biNum);
			if(result==1) {
				request.setAttribute("msg", "삭제되었습니다.");
				request.setAttribute("url", "/board-info/list");
			}
		}
		CommonView.forwardMessage(request, response);
	}
}
