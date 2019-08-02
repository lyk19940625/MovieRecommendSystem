package operate;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
public class GetStep1 {
	public static void get1(String uri,Configuration config) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(uri), config);
		 String localpath = "step1.txt";
		 fs.copyToLocalFile(new Path("/movie/output/1/part-r-00000"), new Path(localpath));
	}
}
