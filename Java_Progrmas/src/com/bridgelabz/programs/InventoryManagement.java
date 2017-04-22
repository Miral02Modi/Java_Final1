package com.bridgelabz.programs;

import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InventoryManagement {
	public static void main(String[] args) {
		JsonFileWriter fw = new JsonFileWriter();
		try {
			fw.jsonFileWriter("/home/bridgeit/workspace/JsonJava/txtFile/jsonjava.txt");
			JSONObject js = fw.jsonFileReader("/home/bridgeit/workspace/JsonJava/txtFile/jsonjava.txt");
			JSONArray ja = (JSONArray) js.get("Wheet");
			System.out.println();
			for (int i = 0; i < ja.size(); i++) {
				JSONObject js1 = (JSONObject) ja.get(i);
				System.out.println("Type  ::" + js1.get("Type"));
				System.out.println("Price ::" + js1.get("Price"));
				System.out.println("Weight::" + js1.get("Weight"));
				System.out.println("--------------------------");

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
