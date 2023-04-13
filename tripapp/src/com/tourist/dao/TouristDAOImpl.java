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
import com.tourist.dto.TouristVO;

public class TouristDAOImpl implements TouristDAO {

	private DataSource dataSource = DataSource.getInstance();

	@Override // TouristVO에서 꺼내온다 뭐를 ? 유저정보를 바로 select에서 쓰기위해 그냥 그렇게 암
	public List<TouristVO> selectTourist(Criteria cri) throws SQLException {
		List<TouristVO> tourList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnetion();
			stmt = conn.createStatement();
			
			String sql = "select * from tourist_spot ";

			switch (cri.getSearchType()) {
			case "1": // 포항
				sql += " where tr_areaname='포항'";
				break;
			case "2": // 여수
				sql += " where tr_areaname='여수'";
				break;
			case "3": // 부산
				sql += " where tr_areaname='부산'";
				break;
			case "4": // 서울
				sql += " where tr_areaname='서울'";
				break;
			}
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

		TouristVO touristname = null;
		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = "select * from tourist_spot where tr_name =?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			List<TouristVO> touristList = toTouristList(rs);
			if (touristList.size() > 0)
				touristname = touristList.get(0);
			return touristname;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			if (conn != null)
				conn.close();
		}
	}
	
	@Override 
	public List<TouristVO> recomendtourist(Criteria cri) throws SQLException {
		List<TouristVO> tourList = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnetion();
			stmt = conn.createStatement();
						
			String sql = "select * from tourist_spot ";
			
			switch (cri.getSearchType()) {
			case "1월": case "2월": case "3월":
				sql += " where season='봄'";
				break;
			case "4월": case "5월": case "6월": 
				sql += " where season='여름'";
				break;
			case "7월": case "8월": case "9월": 
				sql += " where season='가을'";
				break;
			case "10월": case "11월": case "12월": 
				sql += " where season='겨울'";
				break;
			case "사계절":
				sql += " where season='사계절'";
				break;
			}
			
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
	public void updateTourist(TouristVO tourist) throws SQLException {

		Connection conn = null;
		try {
			
			conn = dataSource.getConnetion();
			String sql = "update set tr_name=?,tr_type=?,tr_address=?,tr_closeday=?,tr_time=?,tr_areaname=?,tr_number=?,season=?,manager_num=?,tr_code=? where tr_code=?";
				

					
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
	public void deleteTourist(String trcode) throws SQLException { // 디비삭제->기본키 name으로 삭제진행시 all삭

		Connection conn = null;
		try {
			conn = dataSource.getConnetion();
			String sql = " delete from tourist_spot where tr_code=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, trcode);
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
