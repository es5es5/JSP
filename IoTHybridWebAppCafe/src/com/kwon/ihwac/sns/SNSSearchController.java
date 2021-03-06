package com.kwon.ihwac.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.ihwac.member.MemberDAO;

/**
 * Servlet implementation class SNSSearchController
 */
@WebServlet("/SNSSearchController")
public class SNSSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SNSSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().loginCheck(request, response);
		SNSDAO.getSdao().searchMsgs(request, response);
		SNSDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMdao().loginCheck(request, response);
		SNSDAO.getSdao().searchMsgsByTxt(request, response);
		SNSDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);
	}

}
