package com.saquib.dao;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saquib.modle.EmpModle;

public class EmpDao {
		private Connection conn;
		private PreparedStatement pst;
		private String sqlStatement ;
		private ResultSet rs;
		public EmpDao() throws ClassNotFoundException, SQLException {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/saquibdb","root","Saquib@12345");
		}
		public int addRecord(EmpModle empModel) throws SQLException
		{       
			//yhan value ayeg a add servlet page se or addserv.html se 
			sqlStatement = "insert into chetu values(?,?,?)";
			pst = conn.prepareStatement(sqlStatement);
			
			pst.setInt(1, empModel.getEmpNo());
			pst.setString(2, empModel.getEmpName());
			pst.setDouble(3, empModel.getEmpSal());
			return pst.executeUpdate();
			
		}	
		
		public int deleteRecord(EmpModle empModel) throws SQLException {
			sqlStatement = "delete from chetu where emp_id=?";
			pst = conn.prepareStatement(sqlStatement);
			pst.setInt(1, empModel.getEmpNo());
			
			return pst.executeUpdate();
			
		}
		public int updateRecord(EmpModle empModel) throws SQLException
		{
			sqlStatement = "update chetu set emp_name=?,emp_sal=? where emp_id=?";
			pst = conn.prepareStatement(sqlStatement);
			pst.setInt(3, empModel.getEmpNo());
			pst.setString(1, empModel.getEmpName());
			pst.setDouble(2, empModel.getEmpSal());
			return pst.executeUpdate();
		 	
		}
		public ResultSet findRecord(EmpModle empModel) throws SQLException
		{
			sqlStatement = "select * from chetu where emp_id=?";
			pst = conn.prepareStatement(sqlStatement);
			
			pst.setInt(1, empModel.getEmpNo());
		     rs = pst.executeQuery();
		    return rs;
			
		}
		public List findAllRecord() throws SQLException {
			sqlStatement = "select * from chetu";
			pst = conn.prepareStatement(sqlStatement);
			rs = pst.executeQuery();
			List<EmpModle> store = new ArrayList<EmpModle>();
			while(rs.next()) {
				EmpModle empModel = new EmpModle();
				empModel.setEmpNo(rs.getInt(1));
				empModel.setEmpName(rs.getString(2));
				empModel.setEmpSal(rs.getDouble(3));
				store.add(empModel);
			}
			return store;
	}
}


