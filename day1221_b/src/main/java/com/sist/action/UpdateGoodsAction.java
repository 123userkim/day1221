package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

public class UpdateGoodsAction implements SistAction {
	public GoodsDAO dao;
	public UpdateGoodsAction() {
		dao = new GoodsDAO();
	}
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsVO g= dao.getGoods(no);
		request.setAttribute("g", g);
		return "updateGoods.jsp";
	}

}
