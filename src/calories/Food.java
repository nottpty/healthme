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
 * Food that contains name and categories categorized into Thai food and
 * International food.
 * 
 * @author Narut Poovorakit
 * 
 * @version 20.05.2017
 *
 */
public class Food {
	private Map<String, Integer> foodMap, thaifoodMap;
	static Food food;

	/**
	 * Create food in map.
	 */
	protected Food() {
		foodMap = new HashMap<String, Integer>();
		thaifoodMap = new HashMap<String, Integer>();
	}

	public static Food getInstance() {
		if (food == null)
			food = new Food();
		return food;
	}

	/**
	 * Put all list of food from file into a map.
	 * 
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
			foodMap.put(name, calories);
		}
		// Sort map by key
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(foodMap);
		foodMap = treeMap;
		br.close();
	}

	/**
	 * Put all list of food from file into a map.
	 * 
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
			thaifoodMap.put(name, calories);
		}
		// Sort map by key
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(thaifoodMap);
		thaifoodMap = treeMap;
		br.close();
	}

	/**
	 * Get an international food map.
	 * 
	 * @return a map of international food containing name and calories.
	 */
	public Map<String, Integer> getFood() {
		return this.foodMap;
	}

	/**
	 * Get a thai food map.
	 * 
	 * @return a map of thai food containing name and calories.
	 */
	public Map<String, Integer> getThaiFood() {
		return this.thaifoodMap;
	}
}
