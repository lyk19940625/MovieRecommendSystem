package com.controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;  
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStreamReader;  
import java.io.BufferedReader;  

import jxl.read.biff.BiffException;

import com.dao.*;
import com.entity.Movie;
import com.entity.User;
import com.entity.Step1;
import com.entity.Step2;
import com.entity.Step3;
import com.entity.Step4;
import com.util.ExclUtil;

@Controller  
@RequestMapping("/manager") 
public class ManagerController {
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
	public static ArrayList getRes1(){
		ArrayList res1 = new ArrayList();
		 try { 
             /* 读入TXT文件 */  
             String pathname = "H:\\HadoopWorkSpace\\MovieRecommend\\movie.txt";
             File filename = new File(pathname); // 要读取以上路径的input。txt文件  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // 建立一个输入流对象reader  
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
             String line = "";  
             line = br.readLine();  
             while (line != null) {  
            	 res1.add(line);
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
	return res1;  
	}
	
	
	public static void write(ArrayList<User> info){
		FileOutputStream out = null;   

        FileOutputStream outSTr = null;   

        BufferedOutputStream Buff=null;   
        FileWriter fw = null;   
      
        try {   
            out = new FileOutputStream(new File("H:\\HadoopWorkSpace\\MovieRecommend\\movie.txt"));   
            for (int i = 0; i < info.size(); i++) {
            	if(!info.get(i).getScore1().equals("")){
            		out.write((info.get(i).getUid()+","+"101"+","+info.get(i).getScore1()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore2().equals("")){
            		out.write((info.get(i).getUid()+","+"102"+","+info.get(i).getScore2()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore3().equals("")){
            		out.write((info.get(i).getUid()+","+"103"+","+info.get(i).getScore3()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore4().equals("")){
            		out.write((info.get(i).getUid()+","+"104"+","+info.get(i).getScore4()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore5().equals("")){
            		out.write((info.get(i).getUid()+","+"105"+","+info.get(i).getScore5()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore6().equals("")){
            		out.write((info.get(i).getUid()+","+"106"+","+info.get(i).getScore6()+"\r\n").getBytes());   
            	}
            	if(!info.get(i).getScore7().equals("")){
            		out.write((info.get(i).getUid()+","+"107"+","+info.get(i).getScore7()+"\r\n").getBytes());   
            	}
            }   
            out.close();
	 } catch (Exception e) {   
         e.printStackTrace(); 
     }   
	}
	/*
	@RequestMapping(value="/update", method = RequestMethod.POST)  
    public String updateInfo(HttpServletRequest req) {
		System.out.println("0");
		ArrayList res1 = getRes1();
		ArrayList mlist = new ArrayList();
		ArrayList ulist = new ArrayList();
		for(int i=0;i<(res1.size()-1);i++){
			User u = new User();
			String[] item = res1.get(i).toString().split(",");
			if(userDao.findById(Integer.parseInt(item[0])) == null){
				u.setUid(Integer.parseInt(item[0]));
				if(item[1].equals("101")){
					u.setScore1(item[2]);
				}
				if(item[1].equals("102")){
					u.setScore2(item[2]);
				}
				if(item[1].equals("103")){
					u.setScore3(item[2]);
				}
				if(item[1].equals("104")){
					u.setScore4(item[2]);
				}
				if(item[1].equals("105")){
					u.setScore5(item[2]);
				}
				if(item[1].equals("106")){
					u.setScore6(item[2]);
				}
				if(item[1].equals("107")){
					u.setScore7(item[2]);
				}
			userDao.save(u);
			}
			else{
				User user = userDao.findById(Integer.parseInt(item[0]));
				if(item[1].equals("101")){
					user.setScore1(item[2]);
				}
				if(item[1].equals("102")){
					user.setScore2(item[2]);
				}
				if(item[1].equals("103")){
					user.setScore3(item[2]);
				}
				if(item[1].equals("104")){
					user.setScore4(item[2]);
				}
				if(item[1].equals("105")){
					user.setScore5(item[2]);
				}
				if(item[1].equals("106")){
					user.setScore6(item[2]);
				}
				if(item[1].equals("107")){
					user.setScore7(item[2]);
				}
				userDao.merge(user);
				}
				if(!mlist.contains(item[1])){
					mlist.add(item[1]);
				}
			
			}
			
		
		for(int j=0;j<=(mlist.size()-1);j++){
			Movie m = new Movie();
			m.setMid(Integer.parseInt((String) mlist.get(j)));
			movieDao.merge(m);
		}
		return "redirect:/manager/update1"; 
    }  
	*/
	@RequestMapping(value="/update1", method = RequestMethod.POST)  
    public String updateStep1(HttpServletRequest req) {
		System.out.println("1");
		 try { 

             /* 读入TXT文件 */  
             String pathname = "H:\\HadoopWorkSpace\\MovieRecommend\\step1.txt";
             File filename = new File(pathname); // 要读取以上路径的input。txt文件  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // 建立一个输入流对象reader  
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
             String line = "";  
             line = br.readLine();  
             while (line != null) {  
            	 String[] item = line.toString().split(CONTROL_I);
            	 Step1 s1 = new Step1();
            	 s1.setStep1Key(item[0]);
            	 s1.setStep1Value(item[1]);
            	 step1Dao.save(s1);
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
		
		 
		 
		 return "redirect:/manager/update2"; 
	}
	@RequestMapping(value="/update2", method = RequestMethod.GET)  
    public String updateStep2(HttpServletRequest req) {
		System.out.println("2");
		 try { 

             /* 读入TXT文件 */  
             String pathname = "H:\\HadoopWorkSpace\\MovieRecommend\\step2.txt";
             File filename = new File(pathname); // 要读取以上路径的input。txt文件  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // 建立一个输入流对象reader  
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
             String line = "";  
             line = br.readLine();  
             while (line != null) {  
            	 String[] item = line.toString().split(CONTROL_I);
            	 Step2 s2 = new Step2();
            	 s2.setStep2Key(item[0]);
            	 s2.setStep2Value(item[1]);
            	 step2Dao.save(s2);
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
		
		 
		 
		 return "redirect:/manager/update3"; 
	}
	@RequestMapping(value="/update3", method = RequestMethod.GET)  
    public String updateStep3(HttpServletRequest req) {
		System.out.println("3");
		 try { 

             /* 读入TXT文件 */  
             String pathname = "H:\\HadoopWorkSpace\\MovieRecommend\\step3.txt";
             File filename = new File(pathname); // 要读取以上路径的input。txt文件  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // 建立一个输入流对象reader  
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
             String line = "";  
             line = br.readLine();  
             while (line != null) {  
            	 String[] item = line.toString().split(":");
            	 Step3 s3 = new Step3();
            	 s3.setStep3Key(item[0]);
            	 s3.setStep3Value(item[1]);
            	 step3Dao.save(s3);
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
		
		 
		 
		 return "redirect:/manager/update4"; 
	}
	@RequestMapping(value="/update4", method = RequestMethod.GET)  
    public String updateStep4(HttpServletRequest req) {
		System.out.println("4");
		 try { 

             /* 读入TXT文件 */  
             String pathname = "H:\\HadoopWorkSpace\\MovieRecommend\\step4.txt";
             File filename = new File(pathname); // 要读取以上路径的input。txt文件  
             InputStreamReader reader = new InputStreamReader(  
                     new FileInputStream(filename)); // 建立一个输入流对象reader  
             BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
             String line = "";  
             line = br.readLine();  
             while (line != null) {  
            	 String[] item = line.toString().split(CONTROL_I);
            	 Step4 s4 = new Step4();
            	 s4.setStep4Key(item[0]);
            	 s4.setStep4Value(item[1]);
            	 step4Dao.save(s4);
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
		
		 
		 
		 return "redirect:/manager/recommend"; 
	}
	@RequestMapping(value="/recommend", method = RequestMethod.GET)  
    public String recommend(HttpServletRequest req) {
		System.out.println("5");
		 List<Step4> step4list = step4Dao.findAll();
		 int size = movieDao.findAll().size();
		 String res = "";
		 for(int i=0;i<=(step4list.size()-1);i++){
			 Step4 step4 = step4list.get(i);
			 int uid = Integer.parseInt(step4.getStep4Key().split(":")[0]);
			 res = res+step4.getStep4Value()+",";
			 if((i+1)%size==0){
				 User user = userDao.findById(uid);
				 user.setRecommend(res);
				 userDao.merge(user);
				 res = "";
			 }
			 
			 }
		
		 
		 
		 return "redirect:/manager/info"; 
	}
	@RequestMapping(value="/info", method = RequestMethod.GET)  
	 public String movieInfo(HttpServletRequest req) {
		ArrayList movie = new ArrayList();
		List<Step2> s2list = step2Dao.findAll();
		for(int i=0;i<=(s2list.size()-1);i++){
			Step2 s2 = s2list.get(i);
			String[] item = s2.getStep2Key().split(":");
			if(item[0].equals(item[1])){
				movie.add(Integer.parseInt(s2.getStep2Value()));
			}
		}
		/*
		List<Movie> mlist= movieDao.findAll();
		for(int j=0;j<=(mlist.size()-1);j++){
			movie.add(mlist.get(j).getMname());
		}
		*/
		JSONArray json2 = JSONArray.fromObject(movie);
		req.setAttribute("chartjson3", json2.toString());
	return "Manager";  
	}
	//查询电影
		@RequestMapping(value="/movie", method = RequestMethod.GET)  
		 public String Movie(HttpServletRequest req) {
			List<Movie> movielist= movieDao.findAll();
			req.getSession().setAttribute("movielist", movielist);
		return "Manager_Movie";  
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
						scorelist.add(Double.valueOf(userlist.get(i).getScore3().toString()).doubleValue());
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
			
	 		JSONArray json = JSONArray.fromObject(scorelist);
			req.setAttribute("chartjson4", json.toString());
		return "Manager_Movie";  
		}
		
		//查询step1
		@RequestMapping(value="/step1", method = RequestMethod.GET)  
		 public String step1(HttpServletRequest req) {
			List<Step1> step1list= step1Dao.findAll();
			req.getSession().setAttribute("step1list", step1list);
		return "Manager_Step1";  
		}
		//查询step2
		@RequestMapping(value="/step2", method = RequestMethod.GET)  
		public String step2(HttpServletRequest req) {
			List<Step2> step2list= step2Dao.findAll();
			req.getSession().setAttribute("step2list", step2list);
		return "Manager_Step2";  
		}
		//查询step3
		@RequestMapping(value="/step3", method = RequestMethod.GET)  
		public String step3(HttpServletRequest req) {
			List<Step3> step3list= step3Dao.findAll();
			req.getSession().setAttribute("step3list", step3list);
		return "Manager_Step3";  
		}
		//查询step4
		@RequestMapping(value="/step4", method = RequestMethod.GET)  
		public String step4(HttpServletRequest req) {
			List<Step4> step4list= step4Dao.findAll();
			req.getSession().setAttribute("step4list", step4list);
		return "Manager_Step4";  
		}
		//查询user
		@RequestMapping(value="/user", method = RequestMethod.GET)  
		public String user(HttpServletRequest req) {
			List<User> userlist= userDao.findAll();
			req.getSession().setAttribute("userlist", userlist);
		return "Manager_User";  
		}
		//查询movie
		@RequestMapping(value="/minfo", method = RequestMethod.GET)  
		public String MInfo(HttpServletRequest req) {
			List<Movie> movielist= movieDao.findAll();
			req.getSession().setAttribute("minfolist", movielist);
		return "Manager_MInfo";  
		}
		
		//上传用户
		@RequestMapping(value = "/uploadU", method = RequestMethod.POST)
		public String uploadUser(HttpServletRequest request) throws BiffException, IOException {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
			// 获得文件名：
			String realFileName = file.getOriginalFilename();
			System.out.println("获得文件名：" + realFileName);
			// 获取路径
			String ctxPath = "E://Excel//";
			// 创建文件
			File dirPath = new File(ctxPath);
			if (!dirPath.exists()) {
				dirPath.mkdir();
			}
			File uploadFile = new File(ctxPath + realFileName);
			try {
				FileCopyUtils.copy(file.getBytes(), uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[][] user = ExclUtil.readExcel(ctxPath + realFileName);
			ArrayList<User> users = new ArrayList<User>();
			
			for(int i=0; i<user.length; i++) {
				
				User u = new User(Integer.parseInt(user[i][0]), user[i][1],user[i][2],
						user[i][3],user[i][4],user[i][5],user[i][6],user[i][7],user[i][8],user[i][9],user[i][10]);
				users.add(u);
				
			}
			userDao.importUser(users);
			write(users);
			return "redirect:/manager/user"; 
		}
		
		//上传电影
				@RequestMapping(value = "/uploadM", method = RequestMethod.POST)
				public String uploadMovie(HttpServletRequest request) throws BiffException, IOException {
					MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
					CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("uploadFile");
					// 获得文件名：
					String realFileName = file.getOriginalFilename();
					System.out.println("获得文件名：" + realFileName);
					// 获取路径
					String ctxPath = "E://Excel//";
					// 创建文件
					File dirPath = new File(ctxPath);
					if (!dirPath.exists()) {
						dirPath.mkdir();
					}
					File uploadFile = new File(ctxPath + realFileName);
					try {
						FileCopyUtils.copy(file.getBytes(), uploadFile);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String[][] movie = ExclUtil.readExcel(ctxPath + realFileName);
					ArrayList<Movie> movies = new ArrayList<Movie>();
					
					for(int i=0; i<movie.length; i++) {
						
						Movie m = new Movie(Integer.parseInt(movie[i][0]), movie[i][1]);
						movies.add(m);
						
					}
					movieDao.importMovie(movies);
					return "redirect:/manager/minfo"; 
				}
}
