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
			// a.导入驱动，加载具体的驱动类
			Class.forName("com.mysql.jdbc.Driver");// 加载具体的驱动类
			// b.与数据库建立连接
			connection = DriverManager.getConnection(URL, USERNAME, PWD);
			// c.发送sql，执行(增删改、【查】)
			stmt = connection.createStatement();
//			String sql = "select stuno,stuname from student";
			
			
			String sql = "select count(*) from login where uname='"+login.getUname()+"' and upwd ='"+login.getUpwd()+"' " ;
//			String sql = "select * from student where stuname like '%"+name+"%'";
			// 执行SQL(增删改executeUpdate()，查询executeQuery())
			rs = stmt.executeQuery(sql); // 返回值表示 增删改 几条数据
			// d.处理结果
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
				 if(stmt!=null) stmt.close();// 对象.方法
				 if(connection!=null)connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
