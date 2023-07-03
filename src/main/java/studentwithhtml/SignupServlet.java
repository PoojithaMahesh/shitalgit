package studentwithhtml;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.GenericSignatureFormatError;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class SignupServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name=req.getParameter("name");
String email=req.getParameter("email");
String password=req.getParameter("password");
String address=req.getParameter("address");
long phone=Long.parseLong(req.getParameter("phone"));
Student student=new Student();
student.setAddress(address);
student.setEmail(email);
student.setName(name);
student.setPassword(password);
student.setPhone(phone);
StudentDao dao=new StudentDao();
Student dbStudent=dao.saveStudent(student);
if(dbStudent!=null) {
	RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
	dispatcher.forward(req, resp);
	
	
}










}
}
