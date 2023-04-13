package com.tourist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tourist.command.Criteria;
import com.tourist.dto.MemberVO;
import com.tourist.dto.TouristVO;
import com.tourist.service.TouristService;
import com.tourist.service.TouristServiceImpl;
import com.tourist.views.MainView;

public class MainController extends Controller {//메인컨트롤은 각각의 컨트롤을 받는것
	// 회원관리 컨트롤러
	// 상품관리 컨트롤러
	// 주문관리 컨트롤러
	// 로그아웃 컨트롤러
	// 메인화면
	private SelectTouristController selecttourist = new SelectTouristController();
	private TipTouristController tiptourist = new TipTouristController();
	private InsertTouristController inserttourist = new InsertTouristController();
	private UpdateTouristController updatetourist = new UpdateTouristController();
	private DeleteTouristController deletetourist = new DeleteTouristController();
	
	private MainView mainView = new MainView();

	// 회원서비스
	private TouristService touristService = new TouristServiceImpl();
	// 상품서비스
	// 주문서비스

	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		

		// 회원 리스트 화면 출력
		Criteria cri = new Criteria();
		cri.setKeyword("");
		cri.setSearchType("");

		Map<String, Object> dataMap = new HashMap<String, Object>();
		List<TouristVO> tourList = null;
		int menu = (Integer)dataMap.get("menu");
		boolean flag = (boolean)dataMap.get("flag");
		while(flag) {
			switch(menu) {
			case 1:
				selecttourist.execute(null);
			}
		}
		
		return null;
	}
}
