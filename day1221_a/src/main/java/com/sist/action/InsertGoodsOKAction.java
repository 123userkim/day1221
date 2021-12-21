package com.sist.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

public class InsertGoodsOKAction implements SistAction {
	public GoodsDAO dao;
	public InsertGoodsOKAction() {
		dao = new GoodsDAO();
	}
	
	@Override
	public String proRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String path = request.getRealPath("upload");
		System.out.println("path:"+path);
		MultipartRequest multi
		= new MultipartRequest(request, 
				path, 
				1024*1024*5, 
				"utf-8", new DefaultFileRenamePolicy());
		
		GoodsVO g = new GoodsVO();
		g.setNo(Integer.parseInt(multi.getParameter("no")));
		g.setPrice(Integer.parseInt(multi.getParameter("price")));
		g.setQty(Integer.parseInt(multi.getParameter("qty")));
		g.setName(multi.getParameter("name"));
		g.setFname(multi.getFilesystemName("uploadFile"));
		
		int re = dao.insertGoods(g);
		String viewPage = "";
		if(re ==1 ) {
			viewPage = "insertGoodsOK.jsp";
		}else {
			viewPage = "error.jsp";
			request.setAttribute("msg", "상품등록에 실패하였습니다.");
		}
		
		return viewPage;
	}

}
