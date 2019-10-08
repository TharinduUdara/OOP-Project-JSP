package com.oop.service;

import java.sql.ResultSet;

public interface GetDataService {
	public ResultSet getTable();
	public ResultSet getTableByKeyWord(String keyword,String keyType);
}
