package operate;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class PutStep3 {
 public static void put3() throws Exception {
       String dir = "/movie/input/3";
       String localFile = "E:/11/movie.txt";
      
       String remoteFile = dir + "/step3.txt";
       try{
    	  
    	   HdfsUtils.deleteHDFSFile(remoteFile);
    	   HdfsUtils.uploadLocalFile2HDFS(localFile, remoteFile);	 
     }
       catch(Exception ex){
    	   ex.printStackTrace();
       }
       
 }
}