package com.bridgelabz.programs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class FileWriter {
	void writer(String str , String url) throws IOException {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(url);
			byte b[] = str.getBytes();
			fout.write(b);
			fout.flush();
			System.out.println("Data inserted SuccessFully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(fout != null)
			{
				fout.close();
			}
		}
	}
	
	/*void writer(Integer str[] , String url) throws IOException {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(url);
			
			 ByteBuffer byteBuffer = ByteBuffer.allocate(str.length * 4);        
		     IntBuffer intBuffer = byteBuffer.asIntBuffer();
		     intBuffer.put(data);

			
			fout.write(b);
			fout.flush();
			System.out.println("Data inserted SuccessFully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			if(fout != null)
			{
				fout.close();
			}
		}
	}*/
}
