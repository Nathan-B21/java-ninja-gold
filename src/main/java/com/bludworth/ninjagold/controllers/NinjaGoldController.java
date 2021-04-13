package com.bludworth.ninjagold.controllers;


import java.util.Date;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	public ArrayList<String> activities = new ArrayList<String>();
	Random rand = new Random();
	@RequestMapping("/")
	public String select(Model model, HttpSession session) {
		Integer totalGold = (Integer) session.getAttribute("totalGold");
//		String [] activities = (String []) session.getAttribute("activities");
		if(totalGold == null) {
			session.setAttribute("totalGold", 0);
		}
		model.addAttribute("activities", activities);
		model.addAttribute("time", new Date());
//		if(activities == null) {
//			session.setAttribute("activities",0);
//		}
		return "index.jsp";
	}
	
	
	@RequestMapping(value = "/process_money", method=RequestMethod.POST)
	public String process(@RequestParam(value = "location_form")String location, HttpSession session) {
		Integer totalGold = (Integer)session.getAttribute("totalGold");
//		String activities = (String)session.getAttribute("activities");
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println(totalGold);
		if(location.equals("farm")) {
			int amountChosen = rand.nextInt(10);

			totalGold += amountChosen;
			session.setAttribute("totalGold", totalGold);
//			session.setAttribute("activities", "You went to the farm");
			activities.add("You went to the farm and gained " + " " + amountChosen + " gold" + " created at: " + ts);
			return "redirect:/";
		}
		else if(location.equals("cave")) {
//			int [] possibleGold = {5,6,7,8,9,10};
			int amountChosen = rand.nextInt(10 -5 + 1) + 5;
			totalGold += amountChosen;
			session.setAttribute("totalGold", totalGold);
			activities.add("You went to the caves and gained " + " " + amountChosen + " gold" + " created at: " + ts);
//			System.out.println(totalGold);
//			session.setAttribute("activities").append("You went to the caves");
//			session.setAttribute("activities", "You went to the cave");
			return "redirect:/";
		}
		else if(location.equals("house")) {
//			int [] possibleGold = {2,3,4,5};
			int amountChosen = rand.nextInt(5 - 2 + 1) + 5;
			totalGold += amountChosen;
			session.setAttribute("totalGold", totalGold);
			activities.add("You went to the house and gained" + " " + amountChosen + " gold" + " created at: " + ts);
//			session.setAttribute("activities", "You went to the house");
			return "redirect:/";
		}
		else if(location.equals("casino")) {
			int amountChosen = (rand.nextInt(50)-50);
			totalGold += amountChosen;
			session.setAttribute("totalGold", totalGold);
			activities.add("You went to the casino and lost" + " " + amountChosen + " gold" + " created at: " + ts);
//			session.setAttribute("activities", "You went to the casino");
			return "redirect:/";
		}
		
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/destory")
	public String reset(HttpSession session) {
		session.invalidate();
		activities = new ArrayList<String>();
		return "redirect:/";
		
	}
	
}
