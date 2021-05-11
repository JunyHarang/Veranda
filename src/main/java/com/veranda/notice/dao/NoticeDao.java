package com.veranda.notice.dao;

import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.notice.vo.Notice;

public class NoticeDao extends SuperDao{

	public int InsertData(Notice bean) {
		return 0;
	}
	
	public int UpdateData(Notice bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public Notice SelectDataByPk( int no ){
		return null;
	}
	
	public List<Notice> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}
	
	
}
