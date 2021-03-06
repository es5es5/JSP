package com.kwon.ihwac.sns;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kwon.ihwac.member.Member;
import com.kwon.ihwac.member.MemberDAO;

/**
 * Servlet implementation class SNSReplDeleteController
 */
@WebServlet("/SNSReplDeleteController")
public class SNSReplDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SNSReplDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (MemberDAO.getMdao().loginCheck(request, response)) {
			SNSDAO.getSdao().deleteRepl(request, response);
		}
		SNSDAO.getSdao().getAllMsgs(request, response);
		SNSDAO.getSdao().paging(1, request, response);
		request.setAttribute("contentPage", "sns/sns.jsp");
		request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
