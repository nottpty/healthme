package calories;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Food that contains name and categories categorized into Thai food and International food.
 * @author Narut Poovorakit
 * 
 * @version 20.05.2017
 *
 */
public class Food {
	private Map<String, Integer> food, thaifood;
	
	/**
	 * Create food in map.
	 */
	public Food() {
		food = new HashMap<String, Integer>();
		thaifood = new HashMap<String, Integer>();
	}
	
	/**
	 * Put all list of food from file into a map.
	 * @throws IOException
	 */
	public void putFood() throws IOException {
		InputStream inputStream = new FileInputStream("src/calories/food.txt");
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
	
	/**
	 * Put all list of food from file into a map.
	 * @throws IOException
	 */
	public void putThaiFood() throws IOException {
		InputStream inputStream = new FileInputStream("src/calories/Thaifood.txt");
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
	
	/**
	 * Get an international food map.
	 * @return a map of international food containing name and calories.
	 */
	public Map<String, Integer> getFood() {
		return this.food;
	}
	
	/**
	 * Get a thai food map.
	 * @return a map of thai food containing name and calories.
	 */
	public Map<String, Integer> getThaiFood() {
		return this.thaifood;
	}
}
