package com.veranda.communitycomment.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.communitycomment.vo.CommunityComment;

public class CommunityCommentDao extends SuperDao{

	public int InsertData(CommunityComment bean) {
		String sql = " insert into community_comments(com_comm_no, com_no, user_no, comm_content ) ";
		sql += " values(community_commseq.nextval, ?, ?, ?) ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false);
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, bean.getNo());
			pstmt.setInt(2, bean.getUser_no());
			pstmt.setString(3, bean.getContent());

			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
	
	public int UpdateData(CommunityComment bean) {
		return 0;
	}
	
	public int DeleteData( int no ){
		String sql = " delete from community_comments ";
		sql += " where com_comm_no = ? ";

		PreparedStatement pstmt = null;
		int cnt = -1;
		try {
			if (conn == null) {
				super.conn = super.getConnection();
			}
			conn.setAutoCommit(false); // 커밋이 자동으로 되는 것을 막기위해
			pstmt = super.conn.prepareStatement(sql);

			pstmt.setInt(1, no);

			cnt = pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			SQLException err = (SQLException) e;
			cnt = -err.getErrorCode();
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				super.closeConnection();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return cnt;
	}
	
	public List<CommunityComment> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}

	public List<CommunityComment> SelectData(int no) {
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		
		String sql = " select user_nickname, com_comm_no, com_no, m.user_no as user_no, comm_content, comm_date ";
		sql += " from members m inner join community_comments q ";
		sql += " on m.user_no = q.user_no ";
		sql += " where com_no = ? ";
		sql += " order by com_comm_no asc ";

		List<CommunityComment> cowriter = new ArrayList<CommunityComment>();
		
		try {
			
			System.out.println("CommunityCommnetDao SelectData()의 try Catch문에 진입 하였습니다!");
			
			if(this.conn == null) {
				this.conn = this.getConnection();
			}
			
			pstmt = this.conn.prepareStatement(sql);
			
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				CommunityComment bean = new CommunityComment();
				
				bean.setWriter(rs.getString("user_nickname"));
				bean.setCom_no(rs.getInt("com_comm_no"));
				bean.setNo(rs.getInt("com_no"));
				bean.setUser_no(rs.getInt("user_no"));
				bean.setContent(rs.getString("comm_content"));
				bean.setDate(rs.getString("comm_date"));
				
				cowriter.add(bean);
				
				System.out.println("CommunityCommnetDao SelectData()의 DB에서 값을 정상적으로 뺐습니다!");
				
			}
		} catch (Exception e) {
			System.out.println("CommunityCommnetDao SelectData()의 문제가 발생하여 Catch문 e에 진입 하였습니다!");
			
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				this.closeConnection();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("Community 게시판 댓글 작성자 전달 성공 하였습니다!");
		
		return cowriter;		
	}
}
	
	

