package com.servelts;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.note;
import com.helper.factoryprovider;

/**
 * Servlet implementation class savenotesevlet
 */
public class savenotesevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savenotesevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			//title, content fetch
			String title= request.getParameter("title");
			String content=request.getParameter("content");
			
			note nt=new note(title, content,    new Date());
			
			//System.out.println(nt.getId()+" : " + nt.getTitle());
			//hibernate:save()
			
			Session s= factoryprovider.getfactory().openSession();
			
			Transaction tx=s.beginTransaction();
			
			s.save(nt);
			
			tx.commit();
			s.close();
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<h1 style='text-align:center;'> Note is added suceessfully </h1>");
			pw.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View all Notes </a> </h1>");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
