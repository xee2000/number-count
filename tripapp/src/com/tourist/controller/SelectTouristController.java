package com.tourist.controller;

import java.util.Map;
import java.util.Scanner;

import com.tourist.command.Criteria;
import com.tourist.service.TouristService;
import com.tourist.service.TouristServiceImpl;
import com.tourist.views.MainView;

public class SelectTouristController extends Controller {
	
	private MainView view = new MainView();
	
	private TouristService touristService = new TouristServiceImpl();
	Scanner scan = new Scanner(System.in);
	@Override
	public Map<String, Object> execute(Map<String, Object> paramMap) {
		boolean flag = true;
		
		while (flag) {
				Criteria cri = new Criteria();
			Map<String, Object> paramData = view.view(null);
			flag = (Boolean) paramData.get("flag");
				
				try {
					if(!flag) {
						continue;
						scan.nextInt();
						switch(scan==cri) {
						case 1:
							Map.put("1",1);
							
						}
					}
			String cri = (String) paramData.get("cri");

			
				Map<String, Object>returnMap = View.view(dataMap);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
