package com.tourist.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tourist.command.Criteria;
import com.tourist.dao.TouristDAOImpl;
import com.tourist.dto.TouristVO;

public class TestTouristServiceImpl {
	
	private TouristServiceImpl touristService = new TouristServiceImpl();

	@Before
	public void init() {
		touristService.setTouristDAO(new TouristDAOImpl());
	}

	@Test
	public void getTourList() throws Exception { //완료
		List<TouristVO> tourList = touristService.getTouristList(new Criteria());
		System.out.println(tourList);
		Assert.assertEquals(20, tourList.size());
		
	}

	@Test
	public void testGetMember() throws Exception {
		String targetName = "포항크루즈";
		TouristVO tourist = touristService.getTourist(targetName);
		System.out.println(tourist);
		Assert.assertEquals(tourist.getName(), targetName);
	
		
	}
		public void testCRUDTourist() throws Exception {
			TouristVO  targetTourist = new TouristVO("target");
			
	
		// 여행지 등록
		
		touristService.regist(targetTourist);
		TouristVO returnTourist = touristService.getTourist(targetTourist.getName());
		System.out.println("regist : " + returnTourist);
		Assert.assertEquals(targetTourist.getName(), returnTourist.getName());
		
		// 여행지정보 수정
		returnTourist.setName("tatata");
		touristService.modify(returnTourist);
		TouristVO updateTourist = touristService.getTourist(returnTourist.getName());
		System.out.println("update : " + updateTourist);
		Assert.assertEquals(updateTourist.getName(), returnTourist.getName());

//		// 여행지 삭제
		touristService.remove(returnTourist.getName());
		TouristVO removeTourist = touristService.getTourist(returnTourist.getTr_code());
		System.out.println("remove : " + removeTourist);
		Assert.assertNull(removeTourist);
	
	}
}
