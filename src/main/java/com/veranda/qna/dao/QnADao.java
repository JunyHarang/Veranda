package com.veranda.qna.dao;

import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.qna.vo.QnA;

public class QnADao extends SuperDao{
	public int InsertData(QnA bean) {
		return 0;
	}
	
	public int UpdateData(QnA bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public QnA SelectDataByPk( int no ){
		return null;
	}
	
	public List<QnA> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}
}
