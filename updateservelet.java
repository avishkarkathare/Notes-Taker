package com.servelts;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.note;
import com.helper.factoryprovider;

/**
 * Servlet implementation class updateservelet
 */
public class updateservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateservelet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 try {
		
		 String title=request.getParameter("title");
		 String content=request.getParameter("content");
		 int noteid=Integer.parseInt(request.getParameter("noteid").trim());
		 Session s=factoryprovider.getfactory().openSession();
		 Transaction tx=s.beginTransaction();
		 
		note not= s.get(note.class, noteid);
		 not.setTitle(title);
		 not.setContent(content);
		 not.setAddedDate(new Date());
		 tx.commit();
		 s.close();
		 
		 response.sendRedirect("all_notes.jsp");
		 
	} catch (Exception e) {
		 e.printStackTrace();
	}
	}

}
