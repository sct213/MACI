package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class LocalFileUpload {

	public static void main(String[] args) throws Exception {
		
		try {
			
			Configuration conf = new Configuration();
			conf.set("fs.defaultFS", "hdfs://192.168.122.1");
			FileSystem hdfs = FileSystem.get(conf);
			
			System.out.println(hdfs.getHomeDirectory());
			System.out.println(hdfs.getWorkingDirectory());
			
			Path path = new Path("/localFile");
			Path localPath = new Path("\\Users\\dead_line\\Downloads\\example_test_statistic_ex2_population.csv");
			
			System.out.println(hdfs.exists(path));
			if(hdfs.exists(path)) {
				hdfs.delete(path, true);
			}
			
			hdfs.copyFromLocalFile(localPath, path);
			
			System.out.println("Local File Upload Finished!!");
			
			hdfs.close();
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
