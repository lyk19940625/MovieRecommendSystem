package recommend;
import java.io.IOException;
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
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Step3 {
	 public static class Step31_UserVectorSplitterMapper extends Mapper<LongWritable, Text, IntWritable, Text> {
	        private final static IntWritable k = new IntWritable();
	        private final static Text v = new Text();

	        @Override
	        public void map(LongWritable key, Text values,Context context) throws IOException, InterruptedException {
	        	String line = values.toString();  
	        	if (line == null || line.equals("")) return; 
	            String[] value1 = line.split(",");
	                int itemID = Integer.parseInt(value1[1]);
	                String pref = value1[2];
	                String userID = value1[0];
	                k.set(itemID);
	                v.set(userID + ":" + pref);
	                context.write(k, v);
	            
	        	
	        }
	    }

	
	 
	 public static void run(Job job) throws IOException {
		    job.setMapperClass(Step31_UserVectorSplitterMapper .class);//mapper  
	 	    job.setMapOutputKeyClass(IntWritable.class);
	 	    job.setMapOutputValueClass(Text.class);
	 	    job.setOutputKeyClass(IntWritable.class);//设置作业输出数据的关键类  
	 	    job.setOutputValueClass(Text.class);//设置作业输出值类  
	 	    String inputfile="hdfs://localhost:9000/movie/input/3/step3.txt";
		    FileInputFormat.addInputPath(job, new Path(inputfile));
		    String outputfile="hdfs://localhost:9000/movie/output/3";
		    FileOutputFormat.setOutputPath(job, new Path(outputfile));
	 }

	    @SuppressWarnings("deprecation")
	 	public static void main(String[] args) throws Exception {
	 		Configuration conf = new Configuration();
	 		Job job = new Job(conf, "Step3");
	 	    job.setJarByClass(Step3.class);//主类  
	 	    run(job);
	 	    System.exit(job.waitForCompletion(true) ? 0 : 1);//等待完成退出.  
	 		//System.out.println(otherArgs[0]+"   "+otherArgs[1]);
	 		
	 	}
	} 