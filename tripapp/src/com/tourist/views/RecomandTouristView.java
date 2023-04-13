package com.tourist.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.tourist.dto.src.com.review.dto.MemberVO;
	
	 public class RecomandTouristView extends MainView{
		 private MemberVO loginUser;
		 
	 }
		String menu = "loginUser.getNickname() + "+"님"+"**************월별로 관광지를 추천해드리는 메뉴입니다. **************\n" 
					+ "*************입력칸에 0월로 원하시는 날짜를 입력해주세요************** /n"
					+"**************메인화면으로 이동을 원하시면 0을 입력해주세요***************";
		setMenu(menu);
		
		@Override // 화면 만들기
		public Map<String, Object> view(Map<String, Object> param) {
			System.out.println(getMenu());
			Scanner scann = new Scanner(System.in);
			Map<String, Object> dataMap = new HashMap<String, Object>();

			int menu = scann.nextInt();
			scann.nextLine();
			
			if(menu==1 || menu==2 ||menu==3) {
				System.out.println("******************loginUser.getNickname() + "+"님"+"봄에 대한 관광지를 보여드립니다******************");
				dataMap.put("menu", scann.nextLine());
				dataMap.put("flag", true);
			}else if(menu==4 || menu==5 || menu==6) {
				System.out.println("******************loginUser.getNickname() + "+"님"+"여름에 대한 관광지를 보여드립니다******************");
				dataMap.put("menu", scann.nextLine());
				dataMap.put("flag", true);
				
			}else if(menu==7 || menu==8 || menu==9) {
				System.out.println("******************loginUser.getNickname() + "+"님"+"가을에 대한 관광지를 보여드립니다******************");
				dataMap.put("menu", scann.nextLine());
				dataMap.put("flag", true);
		}else {
			System.out.println("******************loginUser.getNickname() + "+"님"+"겨울에 대한 관광지를 보여드립니다******************");
			dataMap.put("menu", scann.nextLine());
			dataMap.put("flag", true);
		}
			return dataMap;
}
