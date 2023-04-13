package com.manager.dao;

import java.sql.SQLException;
import java.util.List;

import com.manager.dto.ManagerVO;
import com.tourist.command.Criteria;

public interface ManagerDAO {

	
	ManagerVO selectManagerTripByname(String name) throws SQLException;

	void insertManagerTrip(ManagerVO manager)throws SQLException;

	void updateManagerTrip(ManagerVO manager)throws SQLException;
	
	void deleteManagerTrip(ManagerVO manager)throws SQLException;

}
