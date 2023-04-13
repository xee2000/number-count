package com.tourist.dao;

import java.sql.SQLException;
import java.util.List;

import com.tourist.command.Criteria;
import com.tourist.dto.ReviewVO;

public interface ReviewDAO {
	
	List<ReviewVO> selectReviewList(Criteria cri) throws SQLException;
	
	ReviewVO selectReviewById(String id) throws SQLException;
	
	ReviewVO selectReviewByKey(String key) throws SQLException;
	
	void insertReview(ReviewVO review) throws SQLException;
	
	void updateReview(ReviewVO review) throws SQLException;
	
	void deleteReview(String id) throws SQLException;
	
	List<ReviewVO> selectReviewList(String num) throws Exception;

}