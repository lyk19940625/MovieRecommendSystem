package operate;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class PutStep2 {
 public static void put2() throws Exception {
       String dir = "/movie/input/2";
       String relativelyPath=System.getProperty("user.dir"); 
       String localFile = relativelyPath+"/step1.txt";
      
       String remoteFile = dir + "/step2.txt";
       try{
    	  
    	   HdfsUtils.deleteHDFSFile(remoteFile);
    	   HdfsUtils.uploadLocalFile2HDFS(localFile, remoteFile);	 
     }
       catch(Exception ex){
    	   ex.printStackTrace();
       }
       
 }
}