package com.veranda.product.dao;

import java.util.List;

import com.veranda.common.dao.SuperDao;
import com.veranda.product.vo.Product;

public class ProductDao extends SuperDao{

	public int InsertData(Product bean) {
		return 0;
	}
	
	public int UpdateData(Product bean) {
		return 0;
	}
	
	
	public int DeleteData( int no ){
		return 0;
	}
	
	
	public Product SelectDataByPk( int no ){
		return null;
	}
	
	public List<Product> SelectDataList(int beginRow, int endRow, String mode, String keyword) {
		return null;
	}

	public int UpdateReadhit(int no) {
		return 0;
	}
}
