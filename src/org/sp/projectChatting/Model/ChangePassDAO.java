package org.sp.projectChatting.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sp.projectChatting.DTO.EmployeeDTO;
import org.sp.projectChatting.util.DBManager;

//오직 비밀번호 교체를 위한 
public class ChangePassDAO {
	DBManager dbManager;
	
	public ChangePassDAO(DBManager dbManager) {
		this.dbManager = dbManager;
	}
	
	
	//로그인
	public void ChangePassDAO() {
		Connection con = null;
		PreparedStatement pstmt = null;

		
		try {
			con = dbManager.connect();
			if(con == null) {
				System.out.println("접속실패");
				//JOptionPane.showMessageDialog(????, "일치하는 로그인 정보가 없습니다.");
			}else { //접속성공시
				String sql = "select * from emp where email = ? and pass = ?"; //바인드변수를 사용하여 쉽게 emp 테이블 불러오기
				pstmt = con.prepareStatement(sql); //쿼리 수행 객체 생성

		
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}
	}
	
}
