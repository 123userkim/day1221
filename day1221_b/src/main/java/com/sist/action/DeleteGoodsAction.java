package com.sist.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;

public class DeleteGoodsAction implements SistAction {
	
	public GoodsDAO dao;
	public DeleteGoodsAction() {
		dao = new GoodsDAO();
	}

	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		String oldFname = dao.getGoods(no).getFname();
		String path = request.getRealPath("upload");
		String viewPage = "";
		int re = dao.deleteGoods(no);
		if(re == 1) {
			viewPage = "deleteGoodsOK.jsp";
			File file = new File(path + "/"+oldFname);
			file.delete();
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "상품 삭제에 실패하였습니다.");
		}
		return viewPage;
	}

}
