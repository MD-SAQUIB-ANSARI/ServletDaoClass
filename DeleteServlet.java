package com.saquib.Bihar;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.SQLException;

	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import com.saquib.dao.EmpDao;
	import com.saquib.modle.EmpModle;

	public class DeleteServlet extends HttpServlet{
		public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
			
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			Integer empNo = Integer.parseInt(req.getParameter("empId"));
			
			EmpModle empModel = new EmpModle();
			empModel.setEmpNo(empNo);
			try {
				EmpDao empDao = new EmpDao();
				int c = empDao.deleteRecord(empModel);
				out.println(c+" Record Deleted from Database");
			}catch (ClassNotFoundException e) {
			}catch (SQLException e) {
			}	
		}
	}


