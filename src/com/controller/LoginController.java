package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
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
@RequestMapping("/login") 
public class LoginController {
	@Resource
    private UserDao userDao; 
	@RequestMapping(value="/check" , method = RequestMethod.POST)  
    public String queryUser(ModelMap map,String id,String password,String type,HttpServletRequest req)throws IOException {
		try{
			int uid = Integer.parseInt(id);
			if(uid == 1111){
				if(password.equals("123456")){
			 	    return "redirect:../manager/info"; 
					}
					else
						return "Login";
					}
				
			
			if(userDao.login(uid, password)){
    		User stu=userDao.findById(uid);
    		HttpSession session=req.getSession();
	 	    session.setAttribute("user", stu);
    		 return "redirect:../user/my"; 
			}
			else
				return "Login";
			}
    
		catch(Exception ex) {
			ex.printStackTrace();
			return "Login"; 
		}
	}
}