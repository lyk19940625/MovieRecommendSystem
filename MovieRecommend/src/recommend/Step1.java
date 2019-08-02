package recommend;
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Step1 {
	public static final String CONTROL_I = "\u0009";  
    public static class Step1_ToItemPreMapper extends Mapper<Object, Text, IntWritable, Text> {
        private final static IntWritable k = new IntWritable();
        private final static Text v = new Text();

        @Override
        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
        	String line = value.toString();  
        	if (line == null || line.equals("")) return;  
            String[] values = line.split(",");  
            int userID = Integer.parseInt(values[0]);
            String itemID = values[1];
            String pref = values[2];
            k.set(userID);
            v.set(itemID + ":" + pref);
           
            context.write(k, v);
             
        }
    }

    public static class Step1_ToUserVectorReducer extends Reducer<IntWritable, Text, IntWritable, Text> {
        private final static Text v = new Text();

        @Override
        public void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            StringBuilder s1 = new StringBuilder();
            Iterator<Text> ite = values.iterator();
            while (ite.hasNext()) {
                s1.append("," + ite.next());
            }
            v.set(s1.toString().replaceFirst(",", ""));
            context.write(key, v);
        }
    }
    public static void run(Job job) throws IOException {
    	job.setMapperClass(Step1_ToItemPreMapper .class);//mapper  
 	    job.setReducerClass(Step1_ToUserVectorReducer.class);;//reducer  
 	    job.setMapOutputKeyClass(IntWritable.class);
 	    job.setMapOutputValueClass(Text.class);
 	    job.setOutputKeyClass(IntWritable.class);//设置作业输出数据的关键类  
 	    job.setOutputValueClass(Text.class);//设置作业输出值类  
 	    String inputfile="hdfs://localhost:9000/movie/input/1/movie.txt";
	    FileInputFormat.addInputPath(job, new Path(inputfile));
	    String outputfile="hdfs://localhost:9000/movie/output/1";
	    FileOutputFormat.setOutputPath(job, new Path(outputfile));
    }
/*
    @SuppressWarnings("deprecation")
 	public static void main(String[] args) throws Exception {
 		Configuration conf = new Configuration();
 		
 		
 		Job job = new Job(conf, "Step1");
 	    job.setJarByClass(Step1.class);//主类  
 	    job.setMapperClass(Step1_ToItemPreMapper .class);//mapper  
 	    job.setReducerClass(Step1_ToUserVectorReducer.class);;//reducer  
 	    job.setMapOutputKeyClass(IntWritable.class);
 	    job.setMapOutputValueClass(Text.class);
 	    job.setOutputKeyClass(IntWritable.class);//设置作业输出数据的关键类  
 	    job.setOutputValueClass(Text.class);//设置作业输出值类  
 	    String inputfile="hdfs://localhost:9000/movie/input/movie.txt";
	    FileInputFormat.addInputPath(job, new Path(inputfile));
	    String outputfile="hdfs://localhost:9000/movie/output/1";
	    FileOutputFormat.setOutputPath(job, new Path(outputfile));
 	    System.exit(job.waitForCompletion(true) ? 0 : 1);//等待完成退出.  
 		//System.out.println(otherArgs[0]+"   "+otherArgs[1]);
 		 }
 		*/
 	
} 
