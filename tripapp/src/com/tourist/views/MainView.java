package com.tourist.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.tourist.attribute.Session;
import com.tourist.dto.MemberVO;


public class MainView extends View {
		private MemberVO loginUser;
		boolean flag = true;
		{
			Session session = Session.getSession();
			loginUser =(MemberVO) session.getAttribute("loginUser");
			String menu = loginUser.getNickname() + "님 반갑습니다." + "☆★☆★☆★☆★☆★☆★"
				+ "[1] 관광지 조회   [2] 음식점 조회   [3] 숙소 조회  [4] 관광지 추천   [5]마이페이지  [6] 로그아웃";
			setMenu(menu);
			
		}
		@Override
		public Map<String, Object> view(Map<String, Object> param) {
			System.out.println(getMenu());
			
//			System.out.println("\n ---  최근 등록 회원  --- ");
//			List<MemberVO> memberList = (List<MemberVO>)param.get("memberList");
//			if(memberList !=null)
//				for(int i=0;i<5;i++) {
//					MemberVO member = memberList.get(i);
//					System.out.println(member);
//				}
			
			
		Scanner sc = new Scanner(System.in);
		int menu = sc.nextInt();
		sc.nextLine();
		
		Map<String,Object> dataMap = new HashMap<String,Object>();
		dataMap.put("menu", menu);
		
		String message = "";
		switch (menu) {
		case 1:
			message = "관광지 조회 화면으로 이동합니다.";
			
			sc.nextInt();
			break;
		case 2:
			message = "음식점 조회 화면으로 이동합니다.";
			break;
		case 3:
			message = "숙소 조회 화면으로 이동합니다.";
			break;
		case 4:
			message = "관광지 추천 화면으로 이동합니다.";
			break;
		case 5:
			message = "마이페이지로 이동합니다.";
			break;
		case 6:
				flag = false;
			message = "로그아웃 합니다.\n다시 방문바랍니다~";
			break;
		}
		dataMap.put("flag",flag);
		System.out.println(message+" Enter를 눌러주세요.");
		sc.nextLine();
			return dataMap;
		}



	}
