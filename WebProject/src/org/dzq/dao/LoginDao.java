package org.dzq.dao;
import java.sql.*;
import org.dzq.entity.Login;
public class LoginDao {
	//public int login(String name,String pwd) {
	public int login(Login login) {
		final String URL="jdbc:mysql://localhost:3306/books";
		final String USERNAME="Tiger";
		final String PWD="123456";
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null ; 
		try {
			// a.�������������ؾ����������
			Class.forName("com.mysql.jdbc.Driver");// ���ؾ����������
			// b.�����ݿ⽨������
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			// c.����sql��ִ��(��ɾ�ġ����顿)
			stmt = connection.createStatement();
//			String sql = "select stuno,stuname from student";
			
			
			String sql = "select count(*) from login where uname='"+login.getUname()+"' and upwd ='"+login.getUpwd()+"' " ;
//			String sql = "select * from student where stuname like '%"+name+"%'";
			// ִ��SQL(��ɾ��executeUpdate()����ѯexecuteQuery())
			rs = stmt.executeQuery(sql); // ����ֵ��ʾ ��ɾ�� ��������
			// d.������
			int count = -1;
			if(rs.next()) {
				count = rs.getInt(1) ;
			}
			return count;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		finally {
			try {
				if(rs!=null) rs.close(); 
				 if(stmt!=null) stmt.close();// ����.����
				 if(connection!=null)connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
