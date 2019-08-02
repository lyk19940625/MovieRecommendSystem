package operate;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class GetStep2 {
	public static void get2(String uri,Configuration config) throws IOException {
 
		FileSystem fs = FileSystem.get(URI.create(uri), config);
		String localpath = "step2.txt";
		fs.copyToLocalFile(new Path("/movie/output/2/part-r-00000"), new Path(localpath));
	}
}
