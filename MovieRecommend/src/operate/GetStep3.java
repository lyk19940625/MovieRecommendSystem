package operate;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class GetStep3 {
	public static void get3(String uri,Configuration config) throws IOException {
 
		FileSystem fs = FileSystem.get(URI.create(uri), config);
		String localpath = "step3.txt";
		fs.copyToLocalFile(new Path("/movie/output/3/part-r-00000"), new Path(localpath));
	}
}
