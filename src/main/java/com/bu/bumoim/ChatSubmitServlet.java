package com.bu.bumoim;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bu.bumoim.dao.ChatDao;

@WebService
public class ChatSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html);charset=UTF-8");
		String chatName = request.getParameter("chatName");
		String chatContent = request.getParameter("chatContent");
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(chatName + " " + chatContent);
		
		if(chatName == null || chatName.equals("") || chatContent == null || chatContent.equals("")) {
			System.out.println("실패실패실패실패실패실패실패실패실패실패실패실패실패실패실패실패실패");
			response.getWriter().write("0");
		} else {
			System.out.println("성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공성공");
			response.getWriter().write(new ChatDao().submit(chatName, chatContent) + "");
		}
		
	}

}
