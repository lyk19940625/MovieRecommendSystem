package com.controller;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.InputStreamReader;  
import java.io.BufferedReader;  

import com.dao.*;
import com.entity.Movie;
import com.entity.User;
import com.entity.Step1;
import com.entity.Step2;
import com.entity.Step3;
import com.entity.Step4;

@Controller  
@RequestMapping("/user") 
public class UserController {
	@Resource
    private MovieDao movieDao; 
	@Resource
    private UserDao userDao; 
	@Resource
    private Step1Dao step1Dao; 
	@Resource
    private Step2Dao step2Dao;
	@Resource
    private Step3Dao step3Dao;
	@Resource
    private Step4Dao step4Dao;
	public static final String CONTROL_I = "\u0009"; 
	//登录显示 自己的打分情况
	@RequestMapping(value="/my", method = RequestMethod.GET)  
	 public String My(HttpServletRequest req) {
		ArrayList scorelist = new ArrayList();
		User user = (User) req.getSession().getAttribute("user");
		if(user.getScore1().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore1().toString()));
		if(user.getScore2().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore2().toString()));
		if(user.getScore3().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore3().toString()));
		if(user.getScore4().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore4().toString()));
		if(user.getScore5().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore5().toString()));
		if(user.getScore6().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore6().toString()));
		if(user.getScore7().equals("")){
			scorelist.add(0);
		}
		else
			scorelist.add(Double.valueOf(user.getScore7().toString()));
		System.out.println(scorelist);
		JSONArray json = JSONArray.fromObject(scorelist);
		req.setAttribute("chartjson", json.toString());
	return "User";  
	}
	//推荐电影评分
	@RequestMapping(value="/info", method = RequestMethod.GET)  
	 public String Info(HttpServletRequest req) {
		ArrayList scorelist = new ArrayList();
		User user = (User) req.getSession().getAttribute("user");
		String[] item = user.getRecommend().split(",");
		for(int i=0;i<=(item.length-1);i++){
			double score = Double.valueOf(item[i].toString());
			scorelist.add(score);
		}
		JSONArray json = JSONArray.fromObject(scorelist);
		req.setAttribute("chartjson1", json.toString());
	return "Recommend";  
	}
	//查询电影
	@RequestMapping(value="/movie", method = RequestMethod.GET)  
	 public String Movie(HttpServletRequest req) {
		List<Movie> movielist= movieDao.findAll();
		req.getSession().setAttribute("movielist", movielist);
	return "User_Movie";  
	}
	//查看电影评分
	@RequestMapping(value="/score", method = RequestMethod.GET)  
	 public String score(HttpServletRequest req) {
		 ArrayList scorelist = new ArrayList();
		 String mid = req.getParameter("Mid");
		 List<User> userlist= userDao.findAll();
		 if(mid.equals("101")){
		 for(int i=0;i<=(userlist.size()-1);i++){
			if(userlist.get(i).getScore1().equals("")){
				scorelist.add(0);
			}
			else{
				scorelist.add(Double.valueOf(userlist.get(i).getScore1().toString()));
			}
		   }
		 }
		 if(mid.equals("102")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore2().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore2().toString()));
				}
			   }
			 }
		 if(mid.equals("103")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore3().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore3().toString()));
				}
			   }
			 }
		 if(mid.equals("104")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore4().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore4().toString()));
				}
			   }
			 }
		 if(mid.equals("105")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore5().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore5().toString()));
				}
			   }
			 }
		 if(mid.equals("106")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore6().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore6().toString()));
				}
			   }
			 }
		 if(mid.equals("107")){
			 for(int i=0;i<=(userlist.size()-1);i++){
				if(userlist.get(i).getScore7().equals("")){
					scorelist.add(0);
				}
				else{
					scorelist.add(Double.valueOf(userlist.get(i).getScore7().toString()));
				}
			   }
			 }
		System.out.println(scorelist);
 		JSONArray json = JSONArray.fromObject(scorelist);
		req.setAttribute("chartjson2", json.toString());
	return "User_Movie";  
	}

}
