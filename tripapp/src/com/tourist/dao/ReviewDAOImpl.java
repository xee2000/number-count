package com.tourist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dataSource.DataSource;
import com.tourist.command.Criteria;
import com.tourist.dto.ReviewVO;

public class ReviewDAOImpl implements ReviewDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override
	public List<ReviewVO> selectReviewList(Criteria cri) throws SQLException {
		List<ReviewVO> reviewList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnetion();
			stmt = conn.createStatement();

			String sql = "select * from review ";

			switch (cri.getSearchType()) {
			case "n":
				sql += " where num like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "k":
				sql += " where key like '%'||'" + cri.getKeyword() + "'||'%'";
				break;
			case "i":
				sql += " where id like '%'||'" + cri.getKeyword() + "'||'%'";
				break;

			}
			rs = stmt.executeQuery(sql);

			reviewList = toReviewList(rs);

			return reviewList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public ReviewVO selectReviewById(String id) throws SQLException {

		ReviewVO review = null;
		Connection conn = null;

		try {
			conn = dataSource.getConnetion();
			String sql = "select * from review where id =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();
			List<ReviewVO> reviewList = toReviewList(rs);
			if (reviewList.size() > 0)
				review = reviewList.get(0);

			return review;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public ReviewVO selectReviewByKey(String key) throws SQLException {

		ReviewVO review = null;
		Connection conn = null;

		try {
			conn = dataSource.getConnetion();
			String sql = "select * from review where key =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, key);

			ResultSet rs = pstmt.executeQuery();
			List<ReviewVO> reviewList = toReviewList(rs);
			if (reviewList.size() > 0)
				review = reviewList.get(0);

			return review;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	
	@Override
	public void insertReview(ReviewVO review) throws SQLException {
		Connection conn = null;

		try {
			conn = dataSource.getConnetion();

			String sql = " insert into" + " review(num,content,grade,key,id)" + " values(?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getNum());
			pstmt.setString(2, review.getContent());
			pstmt.setString(3, review.getGrade());
			pstmt.setString(4, review.getKey());
			pstmt.setString(5, review.getId());


			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void updateReview(ReviewVO review) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "update review " + " set" + " content=?, grade=? " + " where key =? and id=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getContent());
			pstmt.setString(2, review.getGrade());

			pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	@Override
	public void deleteReview(String id) throws SQLException {
		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "delete form review where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			pstmt.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.close();
		}

	}

	private List<ReviewVO> toReviewList(ResultSet rs) throws SQLException {
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();

		while (rs.next()) {
			ReviewVO review = new ReviewVO();

			review.setNum(rs.getString("num"));
			review.setContent(rs.getString("content"));
			review.setGrade(rs.getString("grade"));
			review.setRDate(rs.getDate("rDate"));
			review.setKey(rs.getString("key"));
			review.setId(rs.getString("id"));

			reviewList.add(review);
		}
		return reviewList;
	}

}
