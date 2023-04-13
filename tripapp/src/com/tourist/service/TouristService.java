package com.tourist.service;

import java.util.List;

import com.tourist.command.Criteria;
import com.tourist.dto.ReviewVO;
import com.tourist.dto.TouristVO;

public interface TouristService {
	
		//여행지 타입조회
		public List<TouristVO> getTouristList(Criteria cri) throws Exception;
		//여행지 이름검색
		public TouristVO getTourist(String name) throws Exception;
		//여행지 추천
		public List<TouristVO> TipTouristList(Criteria cri) throws Exception;
		//여행지정보등록
		public void regist(TouristVO tourist) throws Exception;
		//여행지정보수정
		public void modify(TouristVO tourist) throws Exception;
		//여행지정보삭제
		public void remove(String tr_code) throws Exception;
		
		public void addReview(ReviewVO review) throws Exception;
		public void modifyReview(ReviewVO review) throws Exception;
		public void removeReview(int num) throws Exception;
		
	}


