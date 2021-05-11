package com.veranda.member.dao;

import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.member.vo.Member;

public class MemberDao extends SuperDao {
	public Member SelectData(String id, String password) {
		return null;
	}

	public int InsertData(Member bean) {
		return 0;
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
	     return null;
	   }
}
