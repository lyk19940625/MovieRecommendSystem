package operate;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class PutStep1 {
	public static void put1() throws IOException {
	       String dir = "/movie/input/1";
	       String localFile = "E:/11/movie.txt";
	       String remoteFile = dir + "/movie.txt";
	       try{
	    	  
	    	   HdfsUtils.deleteHDFSFile(remoteFile);
	    	   HdfsUtils.uploadLocalFile2HDFS(localFile, remoteFile);	 
	     }
	       catch(Exception ex){
	    	   ex.printStackTrace();
	       }
	 }
	
 
}