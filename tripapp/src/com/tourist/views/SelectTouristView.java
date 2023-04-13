package com.tourist.views;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectTouristView extends MainView{
	private com.tourist.dto.MemberVO loginUser;
	String menu = loginUser.getNickname()+"님원하시는 지역의 번호를 입력해주세요><************\n" + "[1] 포항 [2] 부산 [3] 거제 [4] 여수 [0] 메인화면";
	
	@Override // 화면 만들기
	public Map<String, Object> view(Map<String, Object> param) {
		System.out.println(getMenu());
		Scanner scann = new Scanner(System.in);
		Map<String, Object> dataMap = new HashMap<String, Object>();

		int menu = scann.nextInt();
		scann.nextLine();

		switch (menu) {
		case 1:
			System.out.println("******************포항에 대한 관광지를 보여드립니다******************");
			dataMap.put("int", scann.nextLine());
			dataMap.put("flag", true);
			break;
		case 2:
			dataMap.put("flag", false);
			System.out.println("******************부산에 대한 관광지를 보여드립니다******************");
			dataMap.put("int", scann.nextLine());
			dataMap.put("flag", true);
		case 3:
			dataMap.put("flag", false);
			System.out.println("******************거제에 대한 관광지를 보여드립니다******************");
			dataMap.put("int", scann.nextLine());
			dataMap.put("flag", true);
		case 4:
			dataMap.put("flag", false);
			System.out.println("******************여수에 대한 관광지를 보여드립니다******************");
			dataMap.put("int", scann.nextLine());
			dataMap.put("flag", true);
		case 0:
			dataMap.put("flag", false);
			System.out.println("***********관광지를 다보셨나요? 즐거운 감상되셨길 바랍니다 메인화면으로 이동합니다><*************");
			dataMap.put("int", scann.nextLine());
			dataMap.put("flag", true);
		}

		return dataMap;
	}
}
