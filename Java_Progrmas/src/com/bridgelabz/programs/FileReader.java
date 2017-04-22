package com.bridgelabz.programs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReader {

	String reader(String url) throws IOException {
		FileInputStream fis = new FileInputStream(url);
		int data;
		String s1="";
		  while( (data=fis.read())!=-1){
			  s1 = s1 + (char)data;		
		  }
		return s1;
	}

}
