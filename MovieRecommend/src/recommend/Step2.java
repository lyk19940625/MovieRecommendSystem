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
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Step2 {
	public static final String CONTROL_I = "\u0009";
    public static class Step2_UserVectorToCooccurrenceMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        private final static Text k = new Text();
        private final static IntWritable v = new IntWritable(1);

        @Override
        public void map(LongWritable key, Text values,Context context) throws IOException, InterruptedException {
        	String line = values.toString();  
        	if (line == null || line.equals("")) return; 
        	String value0 = line.split(CONTROL_I)[1];
            String[] value1 = value0.split(",");  
            for (int i = 0; i <= value1.length-1; i++) {
            	  String itemID = value1[i].split(":")[0];
            	  int a = value1.length-1;
            	  for (int j = 0; j <= value1.length-1;j++) {
            		  String itemID2 = value1[j].split(":")[0];
                      k.set(itemID + ":" + itemID2);
                      context.write(k, v);
            		  
            		  
            	  }
            	
            }
        	/*
            StringTokenizer itr=new StringTokenizer(values.toString());
            ArrayList tokens = new ArrayList();
            while(itr.hasMoreTokens()){ 
            	String[] value1 = itr.split(",");  
            	tokens.add(itr.nextToken());
    		}
            for (int i = 0; i <= tokens.size()-1; i++) {
            	
                String itemID = ((String) tokens.get(i)).split(":")[0];
                for (int j = 1; j < tokens.size();j++) {
                    String itemID2 = ((String) tokens.get(j)).split(":")[0];
                    k.set(itemID + ":" + itemID2);
                    context.write(k, v);
                }
            }
            */
        }
    }

    public static class Step2_UserVectorToConoccurrenceReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();
  
        public void reduce(Text key, Iterable<IntWritable> values,Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
				sum += val.get();
			}
            result.set(sum);
            context.write(key, result);
        }
    }
    public static void run(Job job) throws IOException {
    	job.setMapperClass(Step2_UserVectorToCooccurrenceMapper .class);//mapper  
  	    job.setCombinerClass(Step2_UserVectorToConoccurrenceReducer.class);
  	    job.setReducerClass(Step2_UserVectorToConoccurrenceReducer.class);;//reducer  
  	    
  	    job.setMapOutputKeyClass(Text.class);
  	    job.setMapOutputValueClass(IntWritable.class);
  	    job.setOutputKeyClass(Text.class);//设置作业输出数据的关键类  
  	    job.setOutputValueClass(IntWritable.class);//设置作业输出值类  
  	    String inputfile="hdfs://localhost:9000/movie/input/2/step2.txt";
 	    FileInputFormat.addInputPath(job, new Path(inputfile));
 	    String outputfile="hdfs://localhost:9000/movie/output/2";
 	    FileOutputFormat.setOutputPath(job, new Path(outputfile));
    }
    /*
    @SuppressWarnings("deprecation")
 	public static void main(String[] args) throws Exception {
 		Configuration conf = new Configuration();
 		
 		
 		Job job = new Job(conf, "Step2");
 	    job.setJarByClass(Step2.class);//主类  
 	    job.setMapperClass(Step2_UserVectorToCooccurrenceMapper .class);//mapper  
 	    job.setCombinerClass(Step2_UserVectorToConoccurrenceReducer.class);
 	    job.setReducerClass(Step2_UserVectorToConoccurrenceReducer.class);;//reducer  
 	    
 	    job.setMapOutputKeyClass(Text.class);
 	    job.setMapOutputValueClass(IntWritable.class);
 	    job.setOutputKeyClass(Text.class);//设置作业输出数据的关键类  
 	    job.setOutputValueClass(IntWritable.class);//设置作业输出值类  
 	    String inputfile="hdfs://localhost:9000/movie/input/2/step2.txt";
	    FileInputFormat.addInputPath(job, new Path(inputfile));
	    String outputfile="hdfs://localhost:9000/movie/output/2";
	    FileOutputFormat.setOutputPath(job, new Path(outputfile));
 	    System.exit(job.waitForCompletion(true) ? 0 : 1);//等待完成退出.  
 		//System.out.println(otherArgs[0]+"   "+otherArgs[1]);
 		
 	}
 	*/
} 