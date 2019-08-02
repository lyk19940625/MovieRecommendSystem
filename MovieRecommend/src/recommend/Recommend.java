package recommend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapreduce.Job;
import operate.*;
public class Recommend {
	public static ArrayList<ArrayList<Integer>> getInfo(){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		ArrayList<Integer> movie = new ArrayList<Integer>();
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
            	 String[] item = line.split(",");
            	 int uid = Integer.parseInt(item[0]);
            	 int mid = Integer.parseInt(item[1]);
            	 if(!user.contains(uid)){
            		 user.add(uid); 
            	 }
            	 if(!movie.contains(mid)){
            		 movie.add(mid);
            	 }
                 line = br.readLine(); // 一次读入一行数据 
             }  
		 } catch (Exception e) {  
             e.printStackTrace();  
         }  
		 res.add(user);
		 res.add(movie);
	return res;  
	}
    public static void main(String[] args) throws Exception {
    	String uri = "hdfs://localhost:9000/";
    	Configuration conf = new Configuration();
    	ArrayList<Integer> user = getInfo().get(0);
    	ArrayList<Integer> movie = getInfo().get(1);
    	conf.set("userinfo", StringUtils.join(user,","));
    	conf.set("movieinfo", StringUtils.join(movie,","));
    	PutStep1.put1();
    	Job job1 = new Job(conf, "Step1");
 	    job1.setJarByClass(Step1.class);//主类  
 	    Step1.run(job1);
 	    while((job1.waitForCompletion(true) ? 0 : 1)==1){
 	    	Thread.sleep(100);
 	    }
 	    GetStep1.get1(uri, conf);
 	    
    	PutStep2.put2();
    	Job job2 = new Job(conf, "Step2");
 	    job2.setJarByClass(Step2.class);//主类  
 	    Step2.run(job2);
 	   while((job2.waitForCompletion(true) ? 0 : 1)==1){
	    	Thread.sleep(100);
	    }
 	    GetStep2.get2(uri, conf);
 	    
    	PutStep3.put3();
 		Job job3 = new Job(conf, "Step3");
 	    job3.setJarByClass(Step3.class);//主类  
 	    Step3.run(job3);
 	   while((job3.waitForCompletion(true) ? 0 : 1)==1){
	    	Thread.sleep(100);
	    }
 	    GetStep3.get3(uri, conf);
 	    PutStep4.put4();
		Job job4 = new Job(conf, "Step4");
	    job4.setJarByClass(Step4.class);//主类  
	    Step4.run(job4,conf);
	    while((job4.waitForCompletion(true) ? 0 : 1)==1){
 	    	Thread.sleep(100);
 	    }
	    GetStep4.get4(uri, conf);
	    
    }
    
   

}