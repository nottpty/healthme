package calories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Food {
	
	private int Calories;
	private String name;
	private Map<String, Integer> food, thaifood;
	
	public Food() {
		food = new HashMap<String, Integer>();
		thaifood = new HashMap<String, Integer>();
	}
	
	public void putFood() throws IOException {
		InputStream inputStream = new FileInputStream("src/user/food.txt");
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(reader);
		
		String line;
		// Read file
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(",");
				
			// remove space in calories
			arr[1] = arr[1].replaceAll("\\s", "");
			int calories = Integer.parseInt(arr[1]);
			String name = arr[0];
			
			// Put keys and values in map each sentence
			food.put(name, calories);
		}
		// Sort map by key
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(food);
		food = treeMap;
		br.close();
	}
	
	public void putThaiFood() throws IOException {
		InputStream inputStream = new FileInputStream("src/user/Thaifood.txt");
		InputStreamReader reader = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(reader);
		
		String line;
		// Read file
		while ((line = br.readLine()) != null) {
			String[] arr = line.split(":");
				
			// remove space in calories
			arr[1] = arr[1].replaceAll("\\s", "");
			int calories = Integer.parseInt(arr[1]);
			String name = arr[0];
			
			// Put keys and values in map each sentence
			thaifood.put(name, calories);
		}
		// Sort map by key
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(thaifood);
		thaifood = treeMap;
		br.close();
	}
	
	public Map<String, Integer> getFood() {
		return this.food;
	}
	
	public Map<String, Integer> getThaiFood() {
		return this.thaifood;
	}
}
