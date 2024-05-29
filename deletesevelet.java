package com.servelts;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.note;
import com.helper.factoryprovider;

/**
 * Servlet implementation class deletesevelet
 */
public class deletesevelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public deletesevelet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int noteid=Integer.parseInt(request.getParameter("nt_id").trim());
			
			Session s=factoryprovider.getfactory().openSession();
			Transaction tx=s.beginTransaction();
			note not=s.get(note.class, noteid);
			s.delete(not);
			tx.commit();
			s.close();
			response.sendRedirect("all_notes.jsp");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
