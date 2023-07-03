package studentwithhtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String email=req.getParameter("email");
		String passwordfromfrontend=req.getParameter("password");
		StudentDao dao=new StudentDao();
		
		
		Student student =dao.getStudentByEmail(email);
		if(student!=null) {
//			check the password
			String databasePassword=student.getPassword();
			if(databasePassword.equals(passwordfromfrontend)) {
//				login success
               RequestDispatcher dispatcher=req.getRequestDispatcher("select.html");
               dispatcher.forward(req, resp);
			}else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.include(req, resp);
						
			}
			
			
		}else {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("sorry it is null");
		}
		
	}
}
