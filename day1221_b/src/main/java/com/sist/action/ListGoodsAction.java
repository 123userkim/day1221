package com.sist.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

public class ListGoodsAction implements SistAction {
	private GoodsDAO dao;
	
	public ListGoodsAction() {
		dao = new GoodsDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GoodsVO> list = dao.listAll();
		request.setAttribute("list", list);
		return "listGoods.jsp";
	}

}
