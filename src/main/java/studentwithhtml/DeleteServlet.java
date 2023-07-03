package studentwithhtml;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import studentwithhtml.dao.StudentDao;
import studentwithhtml.dto.Student;

public class DeleteServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    int id=Integer.parseInt(req.getParameter("id"));
    StudentDao dao=new StudentDao();
    Student student=dao.deleteStudent(id);
    if(student!=null) {
    	PrintWriter printWriter=resp.getWriter();
    	printWriter.print("deleted successfully");
    }else {
    	PrintWriter printWriter=resp.getWriter();
    	printWriter.print("id is not present");
    }
    
}
}
