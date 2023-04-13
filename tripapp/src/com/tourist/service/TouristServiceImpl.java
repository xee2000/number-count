package com.tourist.service;

import java.util.List;

import com.tourist.command.Criteria;
import com.tourist.dao.ReviewDAO;
import com.tourist.dao.ReviewDAOImpl;
import com.tourist.dao.TouristDAO;
import com.tourist.dao.TouristDAOImpl;
import com.tourist.dto.ReviewVO;
import com.tourist.dto.TouristVO;

public class TouristServiceImpl implements TouristService{
	
	private TouristDAO touristDAO = new TouristDAOImpl();
	private ReviewDAO reviewDAO = new ReviewDAOImpl();
	
		
	@Override//지역검색
	public List<TouristVO> getTouristList(Criteria cri) throws Exception {
		
		List<TouristVO> tourcriList = touristDAO.selectTourist(cri);
		
		if(tourcriList !=null)for(TouristVO tourist : tourcriList) {
			List<ReviewVO> reviewList = reviewDAO.selectReviewList(tourist.getTrcode());
			tourist.setReviewList(reviewList);
		}
	return tourcriList;
	}

	@Override//이름검색
	public TouristVO getTourist(String name) throws Exception {
		TouristVO touristname = touristDAO.selectTouristByname(name);
		
		return touristname;
	}
	
	@Override//추천
	public List<TouristVO> TipTouristList(Criteria cri) throws Exception{
		List<TouristVO> tiptourist = touristDAO.recomendtourist(cri);
		
		List<ReviewVO> reviewList = reviewDAO.selectReviewList(cri);
		tiptourist.setReviewList(reviewList);
		return tiptourist;
	}

	@Override
	public void regist(TouristVO tourist) throws Exception {//등록
		touristDAO.insertTourist(tourist);
	}

	public void modify(TouristVO tourist) throws Exception {//수정
		touristDAO.updateTourist(tourist);
	}

	@Override
	public void remove(String tr_code) throws Exception {//삭제
		touristDAO.deleteTourist(tr_code);
	}
}
