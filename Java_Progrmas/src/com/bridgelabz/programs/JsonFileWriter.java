package com.bridgelabz.programs;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileWriter {

	public static void jsonFileWriter(String url) throws IOException {
		
		JSONObject jsonObjMain = new JSONObject();
		JSONArray rice = new JSONArray();
		JSONArray wheet = new JSONArray();
		JSONArray pulses = new JSONArray();
		JSONObject jsonSub;
		
		
		System.out.println("Enter The number of data you want to enter");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		for (int i = 0; i < num; i++) {
			jsonSub = new JSONObject();
			
			System.out.println("1. Wheat::");
			System.out.println("2. Pulse::");
			System.out.println("3. Rice::");
			System.out.print("Enter the choice::");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Enter the wheat type");
				jsonSub.put("Type", scanner.next());
				System.out.println("Enter the wheat Weight");
				jsonSub.put("Weight", scanner.next());
				System.out.println("Enter the wheat Price");
				jsonSub.put("Price", scanner.next());
				wheet.add(jsonSub);
				jsonObjMain.put("Wheet", wheet);
				break;
			case 2:
				System.out.println("Enter the Pulse type");
				jsonSub.put("Type", scanner.next());
				System.out.println("Enter the Pulse Weight");
				jsonSub.put("Weight", scanner.next());
				System.out.println("Enter the Pulse Price");
				jsonSub.put("Price", scanner.next());
				pulses.add(jsonSub);
				jsonObjMain.put("Pulses", pulses);
				break;
			case 3:
				System.out.println("Enter the Rice type");
				jsonSub.put("Type", scanner.next());
				System.out.println("Enter the Rice Weight");
				jsonSub.put("Weight", scanner.next());
				System.out.println("Enter the Rice Price");
				jsonSub.put("Price", scanner.next());
				rice.add(jsonSub);
				jsonObjMain.put("Rice", rice);
				break;
			default:
				break;
			}
		}
		FileWriter jsonfw=null;
		try {
			jsonfw = new FileWriter(url);
			jsonfw.write(jsonObjMain.toJSONString());
			jsonfw.flush();
			System.out.println("DataInserted successfully");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			scanner.close();
			try {
				jsonfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static JSONObject jsonFileReader(String url) throws IOException {
		FileReader fis=null;
		JSONParser parser1 = new JSONParser();
		JSONObject jsonobj = null;
		try {
			 
			fis= new FileReader(url);
			Object obj = parser1.parse(fis);
			jsonobj = (JSONObject) obj;
			System.out.println("Data Retrived Successfully");
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (ParseException e) {
			System.out.println("File not found");
		}
		return jsonobj;
	}
}
