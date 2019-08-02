package operate;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
public class PutStep4 {
 public static void put4() throws Exception {
       String dir = "/movie/input/4";
       String relativelyPath=System.getProperty("user.dir"); 
       String localFile1 = relativelyPath+"/step2.txt";
       String localFile2 = relativelyPath+"/step3.txt";
      
       String remoteFile1 = dir + "/step4_1.txt";
       String remoteFile2 = dir + "/step4_2.txt";
       try{
    	  
    	   HdfsUtils.deleteHDFSFile(remoteFile1);
    	   HdfsUtils.uploadLocalFile2HDFS(localFile1, remoteFile1);	 
    	   HdfsUtils.deleteHDFSFile(remoteFile2);
    	   HdfsUtils.uploadLocalFile2HDFS(localFile2, remoteFile2);	 
     }
       catch(Exception ex){
    	   ex.printStackTrace();
       }
       
 }
}