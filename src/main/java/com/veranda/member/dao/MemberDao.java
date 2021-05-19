package com.veranda.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.member.vo.Member;

public class MemberDao extends SuperDao {
   
   
   
   public int InsertData(Member bean) {
	   String sql = " insert into members(user_no, user_id, user_pwd, user_name, user_nickname, user_email, user_phone, user_address, user_birth, user_gender, user_address1, user_address2, user_postcode, phone1, phone2) " ; 
		sql += " values (MEMSEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) " ;

		PreparedStatement pstmt = null ;
		int cnt = -1 ;
		try {
			if( conn == null ){ super.conn = super.getConnection() ; }
			conn.setAutoCommit( false );
			pstmt = super.conn.prepareStatement(sql) ;
			
			pstmt.setString(1, bean.getUser_id());
			pstmt.setString(2, bean.getUser_pwd());
			pstmt.setString(3, bean.getUser_name());
			pstmt.setString(4, bean.getUser_nickname());
			pstmt.setString(5, bean.getUser_email());
			pstmt.setString(6, bean.getUser_phone());
			pstmt.setString(7, bean.getUser_address());
			pstmt.setString(8, bean.getUser_birth());
			pstmt.setString(9, bean.getUser_gender());
			pstmt.setString(10, bean.getUser_address1());
			pstmt.setString(11, bean.getUser_address2());
			pstmt.setInt		 (12, bean.getUser_postcode());
			pstmt.setString(13, bean.getUser_phone1());
			pstmt.setString(14, bean.getUser_phone2());
	
			cnt = pstmt.executeUpdate() ; 
			conn.commit(); 
			
		} catch (Exception e) {
			SQLException err = (SQLException)e ;
			cnt = - err.getErrorCode() ;			
			e.printStackTrace();
			try {
				conn.rollback(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally{
			try {
				if( pstmt != null ){ pstmt.close(); }
				super.closeConnection(); 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt ;
   }

   public int UpdateData(Member bean) {
      return 0;
   }

   public int DeleteData(String id) {
      return 0;
   }

   public List<Member> SelectDataList(int beginRow, int endRow) {
      return null;
   }
   
   public Member SelectDataByPk( String id ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select * from members " ; 
		sql += " where user_id = ? " ;

		Member bean = null ;
		
		List<Member> lists = new ArrayList<Member>();
		
		System.out.println("MemberDao의 selectDataByPK()가 try-chatch문을 시작합니다.");
		
		try {
			
			System.out.println("MemberDao의 selectDataByPK()가 try-chatch문에 진입하였습니다.");
			
			if( this.conn == null ){ 
				this.conn = this.getConnection() ; 
			}
			
			pstmt = this.conn.prepareStatement(sql) ;			
			
			System.out.println("MemberDao의 selectDataByPK()가 SQL문 치환을 시작 합니다.");
			
			pstmt.setString(1, id); 
			
			System.out.println("MemberDao의 selectDataByPK()가 SQL문 치환을 끝냈습니다.");
			
			rs = pstmt.executeQuery() ;
			
			System.out.println("MemberDao의 selectDataByPK()에서 rs에 값이 있는지 여부를 검사하는 if문에 진입합니다.");
			
			if ( rs.next() ) {
				bean = new Member();
				
				bean.setUser_birth(String.valueOf(rs.getDate("user_birth")));
				bean.setUser_postcode(rs.getInt("user_postcode"));
				
				bean.setUser_address1(rs.getString("user_address1"));
				bean.setUser_address2(rs.getString("user_address2"));
				bean.setUser_gender(rs.getString("user_gender"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setUser_phone(rs.getString("user_phone"));
				bean.setUser_phone1(rs.getString("phone1"));
				bean.setUser_phone2(rs.getString("phone2"));
				bean.setUser_nickname(rs.getString("user_nickname"));
				bean.setUser_remark(rs.getString("user_remark"));
				
				lists.add(bean);
				
				System.out.println("MemberDao의 selectDataByPK()에서 list에 DB 행 값이 정상적으로 담겼습니다.");
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
			
		} finally{
			
			try {
				if( rs != null){ 
					rs.close(); 
				} 
				
				if( pstmt != null){
					pstmt.close(); 
				} 
				
				this.closeConnection() ;
				
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return bean  ;
      }
   
   public Member SelectDataByNickname( String nickname ){
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select * from members " ; 
		sql += " where user_nickname = ? " ;

		Member bean = null ;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			if( this.conn == null ){ this.conn = this.getConnection() ; }			
			pstmt = this.conn.prepareStatement(sql) ;			
			pstmt.setString( 1, nickname ); 
			rs = pstmt.executeQuery() ;
			
			if ( rs.next() ) {
				bean = new Member();
				
				bean.setUser_birth(String.valueOf(rs.getDate("user_birth")));
				bean.setUser_postcode(rs.getInt("user_postcode"));
				
				bean.setUser_address1(rs.getString("user_address1"));
				bean.setUser_address2(rs.getString("user_address2"));
				bean.setUser_gender(rs.getString("user_gender"));
				bean.setUser_id(rs.getString("user_id"));
				bean.setUser_name(rs.getString("user_name"));
				bean.setUser_pwd(rs.getString("user_pwd"));
				bean.setUser_email(rs.getString("user_email"));
				bean.setUser_phone(rs.getString("user_phone"));
				bean.setUser_phone1(rs.getString("phone1"));
				bean.setUser_phone2(rs.getString("phone2"));
				bean.setUser_nickname(rs.getString("user_nickname"));
				bean.setUser_remark(rs.getString("user_remark"));
				
				lists.add(bean);
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally{
			try {
				if( rs != null){ rs.close(); } 
				if( pstmt != null){ pstmt.close(); } 
				this.closeConnection() ;
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		} 		
		return bean  ;
     }

   public Member SelectData(String user_id, String user_pwd) {
      Member bean = null ;
      PreparedStatement pstmt = null ;
      ResultSet rs = null ;
      
      String sql = " select * from members where user_id = ? and user_pwd = ? " ;
      
      try {
         if(conn == null) {super.conn = super.getConnection() ; }
         pstmt = conn.prepareStatement(sql) ;
         
         pstmt.setString(1, user_id);
         pstmt.setString(2, user_pwd);
         
         rs = pstmt.executeQuery() ; 
         
         if(rs.next()) {
            bean = new Member() ;
            
            bean.setNo(Integer.parseInt(rs.getString("user_no")));
            bean.setUser_address(rs.getString("user_address"));         
            bean.setUser_birth(rs.getString("user_birth"));
            bean.setUser_email(rs.getString("user_email"));
            bean.setUser_gender(rs.getString("user_gender"));
            bean.setUser_id(rs.getString("user_id"));
            bean.setUser_name(rs.getString("user_name"));
            bean.setUser_nickname(rs.getString("user_nickname"));
            bean.setUser_phone(rs.getString("user_phone"));
            bean.setUser_pwd(rs.getString("user_pwd"));
            bean.setUser_remark(String.valueOf(rs.getString("user_remark")));          
            bean.setUser_address1(String.valueOf(rs.getString("user_address1")));
            bean.setUser_address2(String.valueOf(rs.getString("user_address2")));
            bean.setUser_postcode(Integer.parseInt(rs.getString("user_postcode")));
            
            
         }
      } catch (Exception e) {         
         e.printStackTrace();
         bean = null ; 
      }finally {
         try {
            if(rs != null) {rs.close();}
            if(pstmt != null) {pstmt.close();} 
            
         } catch (Exception e2) {
            e2.printStackTrace();
         }
      }
      return bean ;
   }   
}