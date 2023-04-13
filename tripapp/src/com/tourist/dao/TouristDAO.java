package com.tourist.dao;

import java.sql.SQLException;
import java.util.List;

import com.tourist.command.Criteria;
import com.tourist.dto.TouristVO;


public interface TouristDAO {

	List<TouristVO> selectTourist(Criteria cri) throws SQLException;
	
	TouristVO selectTouristByname(String name) throws SQLException;
	
	List<TouristVO> recomendtourist(Criteria cri) throws SQLException;

	void insertTourist(TouristVO tourist)throws SQLException;

	void updateTourist(TouristVO tourist)throws SQLException;
	
	void deleteTourist(String trcode)throws SQLException;


}
