package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dataSource.DataSource;
import com.tourist.command.Criteria;
import com.tourist.dao.TouristDAO;
import com.tourist.dao.TouristDAOImpl;
import com.tourist.dto.TouristVO;

public class ManagerDAOImpl {
	private TouristDAO touristdao = new TouristDAOImpl();
	private DataSource dataSource = DataSource.getInstance();

	@Override // TouristVO에서 꺼내온다 뭐를 ? 유저정보를 바로 select에서 쓰기위해 그냥 그렇게 암
	public <ManagerVO> selectManagerTripByname(String name) throws SQLException {
		List<ManagerVO> manager = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnetion();
			stmt = conn.createStatement();
			
			String sql = "select * from tourist_spot ";

			switch (cri.getSearchType()) {
			case "n": // 이름검색
				sql += " where tr_name like '%'||'" + cri.getKeyword() + "'||'%'";
				break;

			rs = stmt.executeQuery(sql);

			tourList = toTouristList(rs);
		
			return tourList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	@Override
	public TouristVO selectTouristByname(String name) throws SQLException {

		TouristVO tourist = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "select * from tourist_spot where tr_name =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			List<TouristVO> touristList = toTouristList(rs);
			if (touristList.size() > 0)
				tourist = touristList.get(0);
			return tourist;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}


	@Override
	public void insertTourist(TouristVO tourist) throws SQLException {
		Connection conn = null;
		try {

			conn = dataSource.getConnetion();
			String sql = "insert into" + " tourist_spot(tr_name, tr_type, tr_address, tr_closeday, tr_time, tr_areaname, tr_number, season, manager_num, tr_code)"
					+ " values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tourist.getName());
			pstmt.setString(2, tourist.getType());
			pstmt.setString(3, tourist.getAddress());
			pstmt.setString(4, tourist.getCloseday());
			pstmt.setString(5, tourist.getTime());
			pstmt.setString(6, tourist.getAreaname());
			pstmt.setString(7, tourist.getNumber());
			pstmt.setString(8, tourist.getSeason());
			pstmt.setString(9, tourist.getMnumber());
			pstmt.setString(10,tourist.getTrcode());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void updateTourist(TouristVO tourist) throws SQLException {// 수정

		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "update tourist_spot " 
					+ " set" 
					+ " tr_name=?, tr_type=?, tr_address=?, tr_closeday=?, tr_time=?, tr_areaname=?, tr_number=?, season=?, manager_num=?, tr_code=? "
					+ " where name=?";

					
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tourist.getName());
			pstmt.setString(2, tourist.getType());
			pstmt.setString(3, tourist.getAddress());
			pstmt.setString(4, tourist.getCloseday());
			pstmt.setString(5, tourist.getTime());
			pstmt.setString(6, tourist.getAreaname());
			pstmt.setString(7, tourist.getNumber());
			pstmt.setString(8, tourist.getSeason());
			pstmt.setString(9, tourist.getMnumber());
			pstmt.setString(10,tourist.getTrcode());
			pstmt.executeUpdate();

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	@Override
	public void deleteTourist(String name) throws SQLException { // 디비삭제->기본키 name으로 삭제진행시 all삭

		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "delete from tourist_spot where tr_name=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}

	private List<TouristVO> toTouristList(ResultSet rs) throws SQLException {
		List<TouristVO> touristList = new ArrayList<TouristVO>();

		while (rs.next()) {
			TouristVO tourist = new TouristVO();
			tourist.setName(rs.getString("tr_name"));
			tourist.setType(rs.getString("tr_type"));
			tourist.setAddress(rs.getString("tr_address"));
			tourist.setCloseday(rs.getString("tr_closeday"));
			tourist.setTime(rs.getString("tr_time"));
			tourist.setAreaname(rs.getString("tr_areaname"));
			tourist.setNumber(rs.getString("tr_number"));
			tourist.setSeason(rs.getString("season"));
			tourist.setMnumber(rs.getString("manager_num"));
			tourist.setTrcode(rs.getString("tr_code"));
			touristList.add(tourist);

		}

		return touristList;

	}
}
