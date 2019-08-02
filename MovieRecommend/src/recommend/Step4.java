package recommend;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class Step4 {
	public static final String CONTROL_I = "\u0009";  
	public static class MapClass extends Mapper<Object, Text, Text, Text> {           
       
        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
             // 获取输入文件的全路径和名称  
             String pathName = ((FileSplit)context.getInputSplit()).getPath().toString();  
             String userinfo=context.getConfiguration().get("userinfo");
             String movieinfo=context.getConfiguration().get("movieinfo");
             ArrayList<Integer> listA = new ArrayList(Arrays.asList(userinfo.split(",")));
             ArrayList<Integer> listB = new ArrayList(Arrays.asList(movieinfo.split(",")));
             if (pathName.contains("step4_1")) {           
                  String line = value.toString();  
                  String[] values = line.split(CONTROL_I);  
                  String v2 = values[1];  
                  String[] value1 = values[0].split(":");  
                  String key1 = value1[0];  
                  String v1 = value1[1];  
                  /*
                  context.write(new Text(1+":"+key1), new Text("a#"+v1+"#"+v2));  
                  context.write(new Text(2+":"+key1), new Text("a#"+v1+"#"+v2));  
                  context.write(new Text(3+":"+key1), new Text("a#"+v1+"#"+v2));  
                  context.write(new Text(4+":"+key1), new Text("a#"+v1+"#"+v2));  
                  context.write(new Text(5+":"+key1), new Text("a#"+v1+"#"+v2));  
                  */
                  for(int i=0;i<listA.size();i++){
                	  context.write(new Text(listA.get(i)+":"+key1), new Text("a#"+v1+"#"+v2));  
                  }
                  
             }
             if (pathName.contains("step4_2")) {           
                 String line = value.toString();  
                 String[] values = line.split(CONTROL_I);  
                 String v1 = values[0]; 
                 String[] value1 = values[1].split(":");  
                 String key1 = value1[0];  
                 String v2 = value1[1];  
                 for(int j=0;j<listB.size();j++){
                	 context.write(new Text(key1+":"+listB.get(j)), new Text("b#"+v1+"#"+v2));  
                 }
                 /*
                 context.write(new Text(key1+":"+101), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+102), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+103), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+104), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+105), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+106), new Text("b#"+v1+"#"+v2));  
                 context.write(new Text(key1+":"+107), new Text("b#"+v1+"#"+v2));  
               */
                 
            }  
    }
	}
        public static class Reduce extends Reducer<Text, Text, Text, Text> {
    		private IntWritable result = new IntWritable();

    		public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
    			ArrayList A = new ArrayList();
    			ArrayList B = new ArrayList();
    			
    			
    			double res = 0;
    			 Iterator<Text> ite = values.iterator();
    			  
                 while (ite.hasNext()) { 
                	 String value = ite.next().toString();
                	 if (value.startsWith("a#")) {  
                		A.add(value);
                	}
                	 if (value.startsWith("b#")) {  
                		 B.add(value);
                	}
                           }  
                 
                 for(int i=0;i<=(B.size()-1);i++){
                	 for(int j=0;j<=(A.size()-1);j++){
                		 String b1 = B.get(i).toString().split("#")[1];
                		 String a1 = A.get(j).toString().split("#")[1];
                		 if(b1.equals(a1)){
                			 double b = Double.valueOf(B.get(i).toString().split("#")[2]);
                			 double a = Double.valueOf(A.get(j).toString().split("#")[2]);
                			 res = res+a*b;
                		 }
                 }
     
            }  
                 context.write(key, new Text(res+""));   
    		}
        }
        
        public static void run(Job job,Configuration conf) throws IOException {
        	String[] ioArgs = new String[]{"hdfs://localhost:9000/movie/input/4","hdfs://localhost:9000/movie/output/4"};
     		String[] otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
     		if (otherArgs.length != 2) {
     			System.err.println("aaa");
     			System.exit(2);
     		}
     		job.setMapperClass(MapClass.class);//mapper  
      	   //job.setCombinerClass(IntSumReducer.class);//作业合成类  
      	    job.setReducerClass(Reduce.class);;//reducer  
      	    job.setMapOutputKeyClass(Text.class);
      	    job.setMapOutputValueClass(Text.class);
      	    job.setOutputKeyClass(Text.class);//设置作业输出数据的关键类  
      	    job.setOutputValueClass(Text.class);//设置作业输出值类  
      	   // FileInputFormat.addInputPath(job, new Path(otherArgs[0]));//文件输入
      	    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
      	    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
      	   // FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));//文件输出  
        }
/*
        @SuppressWarnings("deprecation")
     	public static void main(String[] args) throws Exception {
     		Configuration conf = new Configuration();
     		String[] ioArgs = new String[]{"hdfs://localhost:9000/movie/input/4","hdfs://localhost:9000/movie/output/4"};
     		String[] otherArgs = new GenericOptionsParser(conf, ioArgs).getRemainingArgs();
     		if (otherArgs.length != 2) {
     			System.err.println("aaa");
     			System.exit(2);
     		
     		}
     		
     		Job job = new Job(conf, "Step4");
     	    job.setJarByClass(Step4.class);//主类  
     	    job.setMapperClass(MapClass.class);//mapper  
     	   //job.setCombinerClass(IntSumReducer.class);//作业合成类  
     	    job.setReducerClass(Reduce.class);;//reducer  
     	    job.setMapOutputKeyClass(Text.class);
     	    job.setMapOutputValueClass(Text.class);
     	    job.setOutputKeyClass(Text.class);//设置作业输出数据的关键类  
     	    job.setOutputValueClass(Text.class);//设置作业输出值类  
     	   // FileInputFormat.addInputPath(job, new Path(otherArgs[0]));//文件输入
     	    FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
     	    FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));
     	   // FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));//文件输出  
     	    System.exit(job.waitForCompletion(true) ? 0 : 1);//等待完成退出.  
     		//System.out.println(otherArgs[0]+"   "+otherArgs[1]);
     		
     	
        }
        */
}