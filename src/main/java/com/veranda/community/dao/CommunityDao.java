package com.veranda.community.dao;

import com.veranda.common.dao.SuperDao;
import com.veranda.community.vo.Community;
import com.veranda.member.vo.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommunityDao extends SuperDao{
	
	public int InsertData(Community bean) {
		
		String sql = " insert into communities(user_no, com_no, com_title, com_category, com_content, com_image1, com_image2, com_image3, com_image4, com_image5, com_image6, com_image7, com_image8, com_image9, com_image10) values (?, communityseq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement pstmt = null;
		
		int cnt = -1 ;
		
		try {
			
			System.out.println("CommunityDao의 InsertData()에 try문에 진입하였습니다.");
			
			if ( conn == null ) {
				super.conn = super.getConnection();
			} // DB 연결 확인 if문 끝
			
			conn.setAutoCommit(false);		// 자동 DB commit 해제
			
			pstmt = super.conn.prepareStatement(sql);
			
			System.out.println("CommunityDao의 InsertData()에 SQL문 치환 작업이 시작 됩니다.");
			
			pstmt.setInt(1, bean.getUser_no());
			pstmt.setString(2, bean.getTitle());
			pstmt.setString(3, bean.getCategory());
			pstmt.setString(4, bean.getContent());
			
			pstmt.setString(5, bean.getImage1());
			pstmt.setString(6, bean.getImage2());
			pstmt.setString(7, bean.getImage3());
			pstmt.setString(8, bean.getImage4());
			pstmt.setString(9, bean.getImage5());
			pstmt.setString(10, bean.getImage6());
			pstmt.setString(11, bean.getImage7());
			pstmt.setString(12, bean.getImage8());
			pstmt.setString(13, bean.getImage9());
			pstmt.setString(14, bean.getImage10());
			
			System.out.println("CommunityDao의 InsertData()에 SQL문 치환 작업이 완료 되었습니다.");
			
			cnt = pstmt.executeUpdate();
			
			conn.commit(); 	// DB에 Data가 정상적으로 들어가면 commit;
			
		} catch (Exception e) {
			System.out.println("CommunityDao의 InsertData()에 문제가 생겨 catch문 exception e로 진입 하였습니다.");
			
			SQLException err = (SQLException)e;
			
			cnt = - err.getErrorCode();
			
			e.printStackTrace();
			
			try {
				System.out.println("CommunityDao의 InsertData()에 문제가 생겨 catch문 exception e의 try문으로 진입 하였습니다. DB RollBack을 실시합니다.");
				
				conn.rollback();
			
			} catch (Exception e2) {
				System.out.println("CommunityDao의 InsertData()에 문제가 생겨 catch문 exception e2로 진입 하였습니다.");
				
				e2.printStackTrace();
			} // e2 try-catch 끝
			
		} finally {
			System.out.println("CommunityDao의 InsertData()에 finally에 진입 합니다.");
			
					try {
						
						if (pstmt != null) {
							pstmt.close();
						}
						
						super.closeConnection();
						
					} catch (Exception e3) {
						System.out.println("CommunityDao의 InsertData()에 문제가 생겨 catch문 exception e3로 진입 하였습니다.");
						
						e3.printStackTrace();
					}
			
		}
		
		return cnt;
	}
	
	public int UpdateData(Community bean) {
		
		String sql = " update communities set com_title=?, com_category=?, com_content=?, com_image1=?, com_image2=?, com_image3=?, com_image4=?, com_image5=?, com_image6=?, com_image7=?, com_image8=?, com_image9=?, com_image10=? where com_no=? ";
		
		PreparedStatement pstmt = null;

		int cnt = - 1;
		
		try {
			
			if ( conn == null ) {
				super.conn = super.getConnection();
			}
			
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setString(1, bean.getTitle());
			pstmt.setString(2, bean.getCategory());
			pstmt.setString(3, bean.getContent());
			pstmt.setString(4, bean.getImage1());
			pstmt.setString(5, bean.getImage2());
			pstmt.setString(6, bean.getImage3());
			pstmt.setString(7, bean.getImage4());
			pstmt.setString(8, bean.getImage5());
			pstmt.setString(9, bean.getImage6());
			pstmt.setString(10, bean.getImage7());
			pstmt.setString(11, bean.getImage8());
			pstmt.setString(12, bean.getImage9());
			pstmt.setString(13, bean.getImage10());
			
			pstmt.setInt(14, bean.getNo());
			
			cnt = pstmt.executeUpdate();
			
			conn.commit();

			System.out.println("CommunityDao의 UpdateData()에 DB Data 수정이 완료 되었습니다.");
			
		} catch (SQLException e) {
			System.out.println("CommunityDao의 UpdateData()에 문제가 발생되어 Catch문이 실행 되었습니다.");
			
			SQLException err = (SQLException)e;
			
			cnt = - err.getErrorCode();
			
			e.printStackTrace();
			
			try {
				System.out.println("CommunityDao의 UpdateData()에 문제가 발생되어 rollback이 실행 되었습니다.");
				
				conn.rollback();
			
			} catch (Exception e2) {
				System.out.println("CommunityDao의 UpdateData()에 문제가 발생되었고, rollback작업도 실패 되었습니다.");
			
				e2.printStackTrace();
			
			} finally {
				
				try {
					
					if (pstmt != null) {
						pstmt.close();
					} // if문 끝
					
					super.closeConnection();
					
				} catch (Exception e3) {
					e3.printStackTrace();
				} // 2 Try - catch 끝
				
			} // finally 끝
			
		} // 1 Try - catch 끝
		
		return cnt;
		
	} // UpdateData() 끝
	
	
	public int DeleteData( int no ){
		
		String sql = " delete from communities where com_no = ? ";
		
		PreparedStatement pstmt = null;
		
		int cnt = - 1;
		
		System.out.println("CommunityDao의 DeleteData()에 try 문에 진입 합니다!");
		
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			System.out.println("CommunityDao의 DeleteData()에 치환 작업이 완료 되었습니다!");
			
			cnt = pstmt.executeUpdate();
			
			System.out.println(cnt + " 이 씨부럴!");
			
			conn.commit();
			
			System.out.println("CommunityDao의 DeleteData()에 DB Commit이 완료 되었습니다!");
		
		} catch (SQLException e) {
			System.out.println("CommunityDao의 DeleteData()에 문제가 발생하여 Catch문에 진입 하였습니다! ");
			
			SQLException err = (SQLException)e;
			
			cnt = - err.getErrorCode();
			
			e.printStackTrace();
			
			try {
				conn.rollback();
				
				System.out.println("CommunityDao의 DeleteData()에 문제가 발생하여 RollBack 되었습니다!");
		
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} finally {
			
			try {
				if ( pstmt != null ) {
					pstmt.close();
				}
				
				super.closeConnection();
			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	
	
	public Community SelectDataByPk( int no ){
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select * from communities where com_no = ? ";		// 커뮤니티 게시판에서 게시글 검색을 통한 DB 검색문 변수 선언
		
		Community bean = null;
		
		List<Community> lists = new ArrayList<Community>();
		
		System.out.println("CommunityDao의 selectDataByPK()가 try-chatch문을 시작합니다.");
		
		try {
			System.out.println("CommunityDao의 selectDataByPK()가 try-chatch문에 진입하였습니다.");
			
			if ( this.conn == null ) {
				this.conn = this.getConnection();
			} // if문 끝
			
			pstmt = this.conn.prepareStatement(sql);
			
			System.out.println("CommunityDao의 selectDataByPK()가 SQL문 치환을 시작 합니다.");
			pstmt.setInt(1, no);
			System.out.println("CommunityDao의 selectDataByPK()가 SQL문 치환을 끝냈습니다.");
			
			rs = pstmt.executeQuery();
			
			System.out.println("CommunityDao의 selectDataByPK()에서 rs에 값이 있는지 여부를 검사하는 if문에 진입합니다.");
			
			if (rs.next()) { /* 게시판에서 제목 클릭 시 해당 글에 해당하는 행 전체 정보를 읽기 위하여 lists에 값을 넣는다. */
				
				System.out.println("CommunityDao의 selectDataByPK()에서 rs에 값은 참입니다.");
				
				bean = new Community();
				
				bean.setCategory(rs.getString("com_category"));
				bean.setContent(rs.getString("com_content"));
				bean.setDate(rs.getString("com_date"));
				bean.setHate(rs.getInt("com_hate"));
				bean.setLike(rs.getInt("com_like"));
				bean.setNo(rs.getInt("com_no"));
				bean.setReadhit(rs.getInt("com_readhit"));
				bean.setTitle(rs.getString("com_title"));
				bean.setUser_no(rs.getInt("user_no"));
				
				bean.setImage1(rs.getString("com_image1"));
				bean.setImage2(rs.getString("com_image2"));
				bean.setImage3(rs.getString("com_image3"));
				bean.setImage4(rs.getString("com_image4"));
				bean.setImage5(rs.getString("com_image5"));
				bean.setImage6(rs.getString("com_image6"));
				bean.setImage7(rs.getString("com_image7"));
				bean.setImage8(rs.getString("com_image8"));
				bean.setImage9(rs.getString("com_image9"));
				bean.setImage10(rs.getString("com_image10"));
				
				lists.add(bean);
				
				System.out.println("CommunityDao의 selectDataByPK()에서 list에 DB 행 값이 정상적으로 담겼습니다.");
			} // if문 끝
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if ( rs != null ) {
					rs.close();
				}
				
				if (pstmt != null ) {
					pstmt.close();
				}
				
				this.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		return bean;
	} // SelectDataByPk 끝
	
	public List<Community> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select ranking, com_no, user_no, com_title, com_category, com_date, com_readhit ";
					  sql += " from ( select com_no, user_no, com_title, com_category, com_date, com_readhit, ";
					  sql += " rank() over(order by com_no desc) as ranking ";
					  sql += " from communities ";
					  
		System.out.println("CommunityDao의 SelectDataList()의 sql변수에 담긴 값 : " + sql + " 입니다.");
					  
		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println("전체 검색 모드가 아닙니다.");
			sql += " where " + mode + " like '%" + keyword + "%' ";
			
			System.out.println("CommunityDao의 SelectDataList()의 전체 검색 모드로 인한 sql변수에 담긴 값 : " + sql + " 입니다.");
		}
		
		sql += " ) ";
		sql += " where ranking between ? and ? ";
		
		System.out.println("CommunityDao의 SelectDataList()의 sql변수에 담긴 모든 값 : " + sql + " 입니다.");
		
		List<Community> lists = new ArrayList<Community>();
		
		try {
			System.out.println("CommunityDao의 SelectDataList()의 try-catch문이 시작 됩니다.");
			
			if ( conn == null ) {
				super.conn = super.getConnection(); 
			}
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, beginRow);
			pstmt.setInt(2, endRow);
			
			rs = pstmt.executeQuery();
			
			System.out.println("CommunityDao의 SelectDataList()의 while문에 진입합니다!");
			
			while (rs.next()) {
				Community bean = new Community();
				
				bean.setUser_no(rs.getInt("user_no"));
				bean.setNo(rs.getInt("com_no"));
				bean.setCategory(rs.getString("com_category"));
				bean.setDate(rs.getString("com_date"));
				bean.setReadhit(rs.getInt("com_readhit"));
				bean.setTitle(rs.getString("com_title"));
				
				lists.add(bean);
				
				System.out.println("CommunityDao의 SelectDataList()의 community vo에 DB 값이 저장 되었습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) {
					rs.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				super.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return lists;
	}

	public int UpdateReadhit(int no) {
		
		PreparedStatement pstmt = null;
		
		String sql = " update communities set com_readhit = com_readhit + 1 where com_no = ? ";
		
		int cnt = -1;
		
		try {
			if( this.conn == null ){ 
				this.conn = this.getConnection() ; 
			}
			
			conn.setAutoCommit( false );
			
			pstmt = this.conn.prepareStatement( sql ) ;
			
			pstmt.setInt(1, no);
			
			cnt = pstmt.executeUpdate() ;
			
			conn.commit(); 
			
		} catch (Exception e) {
			e.printStackTrace();
			
			cnt = - 1 ;
			
			try {
				conn.rollback();
			
			} catch (SQLException e1) {
				e1.printStackTrace();
			
			}
		} finally{
			
			try {
				if( pstmt != null ){ 
					pstmt.close(); 
				}
				
				this.closeConnection();
			
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		}
		return cnt ; 
	} //UpdateReadhit 끝
	
	public int UpdateLike( Community bean ) {
		
		System.out.println("UpdateLike Dao 진입");
		
		String sql = " update communities set com_like = ? where com_no = ? ";
		
		PreparedStatement pstmt = null;
		
		int cnt = - 1;
		
		try {
			
			if ( conn == null ) {
				super.conn = super.getConnection();
			}
			
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getLike());
			pstmt.setInt(2, bean.getNo());
			
			cnt = pstmt.executeUpdate();
			
			conn.commit();
			System.out.println("commit 완료");
			
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
				if( pstmt != null ){
					pstmt.close(); 
				}
				super.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}

public int UpdateHate( Community bean ) {
		
		String sql = " update communities set com_hate = ? where com_no = ? ";
		
		PreparedStatement pstmt = null;
		
		int cnt = - 1;
		
		try {
			
			if ( conn == null ) {
				super.conn = super.getConnection();
			}
			
			conn.setAutoCommit(false);
			
			pstmt = super.conn.prepareStatement(sql);
			
			pstmt.setInt(1, bean.getHate());
			pstmt.setInt(2, bean.getNo());

			cnt = pstmt.executeUpdate();
			
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
				if( pstmt != null ){
					pstmt.close(); 
				}
				super.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public int SelectTotalCount(String mode, String keyword) {
		
		System.out.println("CommunityDao의 SelectTotalCount()가 시작 되었습니다.");
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select count(*) as cnt from communities " ;
		
		if (mode.equalsIgnoreCase("all") == false) {
			System.out.println(" 전체 검색 모드가 아닙니다! ");
			sql += " where " + mode + " like '%" + keyword + "%' "  ;
		}
		
		int cnt = 0 ; 
		
		try {
			
			if( this.conn == null ) { 
				this.conn = this.getConnection() ; 
			}			
			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			if (rs.next()) {
				cnt = rs.getInt("cnt");
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
		return cnt  ; 
	}
	
	public List<Member> searchmember () {
		System.out.println("CommunityDao의 searchmember()가 시작 되었습니다.");
		
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;				

		String sql = " select user_id from members " ;
		
		Member bean = null;
		
		List<Member> lists = new ArrayList<Member>();
		
		try {
			
			if( this.conn == null ) { 
				this.conn = this.getConnection() ; 
			}			
			
			pstmt = this.conn.prepareStatement(sql) ;			 
			rs = pstmt.executeQuery() ; 
			
			while (rs.next()) {
				
				bean = new Member();
				
				bean.setUser_id(rs.getString("user_id"));
				
				lists.add(bean);
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
		return lists  ; 
	}
	
}

