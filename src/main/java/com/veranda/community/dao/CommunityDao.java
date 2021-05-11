package com.veranda.community.dao;

import com.veranda.common.dao.SuperDao;
import com.veranda.community.vo.Community;
import java.sql.PreparedStatement;
import java.util.List;

public class CommunityDao extends SuperDao{
	
	public int InsertData(Community bean) {
		return 0;
	}
	
	public int UpdateData(Community bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public Community SelectDataByPk( int no ){
		return null;
	}
	
	public List<Community> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}
	
	public int UpdateEmotion(int no) {
		return 0;
	}
}
