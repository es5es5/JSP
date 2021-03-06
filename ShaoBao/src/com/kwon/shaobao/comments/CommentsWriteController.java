package com.kwon.shaobao.comments;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentsWriteController
 */
@WebServlet("/CommentsWriteController")
public class CommentsWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentsWriteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "comments/write.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentsDAO.getCdao().write(request, response);
		CommentsDAO.getCdao().getAllComments(request, response);
		CommentsDAO.getCdao().paging(1, request, response);
		request.setAttribute("contentPage", "comments/comments.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}










