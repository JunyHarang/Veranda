package com.veranda.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.veranda.common.dao.SuperDao;
import com.veranda.common.dao.SuperDaoMaria;
import com.veranda.member.vo.Member;

public class MemberDao extends SuperDaoMaria {
	
	
	public Member SelectData(String id, String password) {
		return null;
	}

	public int InsertData(Member bean) {
		
		String sql = " insert into members(user_id, user_pwd, user_nickname, user_name, user_birth, user_gender, user_email, user_email, user_postcode, user_address, user_address1, user_detail_address, user_phone) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement pstmt = null;
		
		int cnt = -1;
		
		try {
			
			if (conn == null) {
				super.conn = super.getConnection();
			}
			
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getUser_id());
			pstmt.setString(2, bean.getUser_pwd());
			pstmt.setString(3, bean.getUser_nickname());
			pstmt.setString(4, bean.getUser_name());
			pstmt.setString(5, bean.getUser_birth());
			pstmt.setString(6, bean.getUser_gender());
			pstmt.setString(7, bean.getUser_email());
			pstmt.setString(8, bean.getUser_postcode());
			pstmt.setString(9, bean.getUser_address());
			pstmt.setString(10, bean.getUser_address1());
			pstmt.setString(11, bean.getUser_detail_address());
			pstmt.setString(12, bean.getUser_phone());
			
			cnt = pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) {
			SQLException sqlerr = (SQLException)e;
			cnt = sqlerr.getErrorCode();
			e.printStackTrace();
			System.out.println("MemberDao InsertData() SQL문에 문제가 있어 보입니다!");
		
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("MemberDao InsertData() Exception e2에서 문제를 보고 합니다!");
			}
		
		} finally {
			
			try {
				
				if ( pstmt != null) {
					pstmt.close();
				}
				
				super.closeConnection();
				
			} catch (Exception e3) {
				e3.printStackTrace();
				System.out.println("MemberDao InsertData() Exception e3에서 문제를 보고 합니다!");
			}
		} // finally 끝
		return cnt;
		
	} // InsertData 끝

	public int UpdateData(Member bean) {
		return 0;
	}

	public int DeleteData(String id) {
		return 0;
	}

	public List<Member> SelectDataList(int beginRow, int endRow) {
		return null;
	}
	
	public Member SelectDataByPk( String user_id ){
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = " select * from members where user_id = ? ";
		
		Member bean = null;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			
			if (this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				bean = new Member();
				
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_nickname(rs.getString("user_nickname"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_birth(String.valueOf(rs.getDate("user_birth")));
				bean.setUser_gender(rs.getString("user_gender"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setUser_postcode(rs.getString("user_postcode"));
				bean.setUser_address(rs.getString("user_address"));
				bean.setUser_address1(rs.getString("user_address1"));
				bean.setUser_detail_address(rs.getString("user_detail_address"));
				
				lists.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("MemberDao에서 SQLException e가 발생하였습니다!");
			
		} finally {
			
			try {
				if (rs != null ) {
					rs.close();
				}
				
				if (pstmt != null ) {
					pstmt.close();
				}
				
				this.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("MemberDao에서 SQLException e2가 발생하였습니다!");
			}
		}
		
	     return bean;
	   }
}
