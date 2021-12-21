package com.sist.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.action.InsertGoodsAction;
import com.sist.action.InsertGoodsOKAction;
import com.sist.action.ListGoodsAction;
import com.sist.action.SistAction;

/**
 * Servlet implementation class SistController
 */
//@WebServlet("/SistController")
public class SistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String, SistAction> map;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SistController() {
        super();
        // TODO Auto-generated constructor stub
        map = new HashMap<String, SistAction>();
        map.put("listGoods.do", new ListGoodsAction());
        map.put("insertGoods.do", new InsertGoodsAction());
        map.put("insertGoodsOK.do", new InsertGoodsOKAction());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proRequest(request, response);
	}
	
	public void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("프론트 컨틀롤러 동작함!");
		String uri = request.getRequestURI();
		String cmd = uri.substring(  uri.lastIndexOf("/")+1 );
		System.out.println("cmd:"+cmd);
		SistAction  action = map.get(cmd);
		String viewPage  = action.proRequest(request, response);
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}








