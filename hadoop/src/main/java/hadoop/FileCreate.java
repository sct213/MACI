package hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class FileCreate {
	
	public static void main(String[] args) throws Exception{
		
		// 인자 값이 2개가 아니라면, 
		if(args.length !=2) {
			System.out.println("");
			System.exit(2);
		}
		
		try {
			Configuration conf = new Configuration();
			FileSystem hdfs = FileSystem.get(conf);
			// 설치된 하둡설정으로부터 HDFS정보 가져오기 
			
			Path path = new Path(args[0]);
			if(hdfs.exists(path)) {
				hdfs.delete(path, true);
			}
			// 생성할 파일명이 존재하면, HDFS에서 삭제하기
			
			FSDataOutputStream outStream = hdfs.create(path);
			outStream.writeUTF(args[1]);
			outStream.close();
			/* 생성할 파일에 내용을 넣기위해 Stream 형태로 객체를 생성해서
			 * 두번째 인자값의 내용을 넣고, 파일 생성  
			 */
			
			FSDataInputStream inputStream = hdfs.open(path);
			String inputString = inputStream.readUTF();
			inputStream.close();
			// 방금 생성한 파일의 내용 읽기
			
			System.out.println("## inputString : " + inputString);
			System.out.println("HEllO");
			
			hdfs.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
