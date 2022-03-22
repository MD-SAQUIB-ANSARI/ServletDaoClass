package com.saquib.Bihar;

	import java.io.IOException;

	import java.io.PrintWriter;
	import java.sql.SQLException;
	import java.util.Iterator;
	import java.util.List;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.saquib.dao.EmpDao;
	import com.saquib.modle.EmpModle;
	public class FindAllServlet extends HttpServlet{

		protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
				
				try {
					EmpDao empDao = new EmpDao();
					List<EmpModle> e = empDao.findAllRecord();
					Iterator<EmpModle> itr = e.iterator();
					out.println("<h1 align='center'>Employee table data</h1>");
					out.println("<table align='center' border='1'><tr><th>Employee Id</th><th>Employee Name</th><th>Employee Salary</th>");
					while(itr.hasNext()) {
						EmpModle emp = itr.next();
						out.println("<tr align='center'><td>"+emp.getEmpNo()+"</td>");
						out.println("<td>"+emp.getEmpName()+"</td>");
						out.println("<td>"+emp.getEmpSal()+"</td></tr>");
						out.println("<br>");
					}
					out.println("</table>");
					out.println("<a href='findAllPage.html'>For Refresh click here...</a>");
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
				}	 
		}

}
