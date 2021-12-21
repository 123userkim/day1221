package com.sist.controler;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.GoodsDAO;
import com.sist.vo.GoodsVO;

/**
 * Servlet implementation class listGoods
 */
//@WebServlet("/listGoods")
public class listGoods extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	GoodsDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listGoods() {
        super();
        // TODO Auto-generated constructor stub
        dao = new GoodsDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GoodsVO>list =dao.listAll();
		request.setAttribute("list", list);
		//����� ��û�� ���� ���� ����
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("listGoods.jsp");
		//���� �������� ���������� ������ ��
		dispatcher.forward(request, response);
		//�� �������� �̵���Ŵ
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
