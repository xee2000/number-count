package com.tourist.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.tourist.command.Criteria;
import com.tourist.dto.TouristVO;

public class TestTouristDAOImpl {

	private TouristDAO touristDAO = new TouristDAOImpl();

	@Test
	public void testSelectTourList() throws Exception {
		Criteria cri = new Criteria();
		cri.setSearchType("1");
		List<TouristVO> tourList = touristDAO.selectTourist(cri);
		Assert.assertEquals(5, tourList.size());
		System.out.println(tourList);
	}
//
//	@Test
//	public void selectTouristByname() throws Exception {//완료
//		String testName = "포항크루즈";
//		TouristVO tourist = touristDAO.selectTouristByname(testName);
//		Assert.assertEquals(testName, tourist.getName());
//
//	}
	
//	@Test
//	public void recomendtourist() throws Exception {//안되고있음
//		Criteria cri = new Criteria();
//		cri.setSearchType("4월");
//	
//		List<TouristVO> tourList = touristDAO.recomendtourist(cri);
//		Assert.assertEquals(2, tourList.size());
//		System.out.println(tourList);
//	
//}
//	
	

	@Test
	public void testDMLTourist() throws Exception {
		TouristVO targetTourist = new TouristVO();
		targetTourist.setName("테스트19");
		targetTourist.setType("테스트1");
		targetTourist.setAddress("테스트1");
		targetTourist.setCloseday("테스트1");
		targetTourist.setTime("테스트1");
		targetTourist.setAreaname("부산");
		targetTourist.setNumber("테스트1");
		targetTourist.setSeason("봄");
		targetTourist.setMnumber("manager01");
		targetTourist.setTrcode("target19");
		
//		insertMember
		touristDAO.insertTourist(targetTourist);
		TouristVO resultTourist = touristDAO.selectTouristByname(targetTourist.getTrcode());
		Assert.assertEquals(targetTourist.getName(), resultTourist.getName());

//		 updateMember
//		TouristVO updateTourist = resultTourist;
//		updateTourist = touristDAO.selectTouristByname(resultTourist.getTrcode());
//		updateTourist.setName("뭥미");
//		updateTourist.setType("테스트1");
//		updateTourist.setAddress("테스트1");
//		updateTourist.setCloseday("테스트1");
//		updateTourist.setTime("테스트1");
//		updateTourist.setAreaname("부산");
//		updateTourist.setNumber("테스트1");
//		updateTourist.setSeason("봄");
//		updateTourist.setMnumber("manager01");
//		updateTourist.setTrcode("target19");
//		touristDAO.updateTourist(updateTourist);
//		targetTourist = touristDAO.selectTouristByname(updateTourist.getTrcode());
//		System.out.println("update : " + updateTourist);
//		Assert.assertEquals(updateTourist.getName(), targetTourist.getName());

		//deleteMember
//		touristDAO.deleteTourist(targetTourist.getTrcode());
//		TouristVO deleteTourist = touristDAO.selectTouristByname(targetTourist.getTrcode());
//		Assert.assertNull(deleteTourist);
	
}


