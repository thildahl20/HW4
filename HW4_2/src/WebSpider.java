import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class reads through the html code of a website to find links to other sites, stores them, then can later explore those links
 * @author thildahl20
 * @version 1.0
 */
public class WebSpider {

	public static void main(String[] args) {
		
			HashMap<String, Boolean> map = new HashMap<String, Boolean>();
			
			try {
				//Start with a url, and then send to checkSite to search it for more urls
				//URL url = new URL("http://www.espn.com/");
				map.put("http://www.espn.com/", false);
				String Site;
				
				//This will check 100 sites for their urls, then finish searching
				for (int siteCount = 0; siteCount < 100; siteCount++) {
					//Get the first site that has not been visited
					Site = getURL(map);
					URL url = new URL(Site);	
	
					try {
						BufferedReader rdr = new BufferedReader(new InputStreamReader(url.openStream()));
						String line = rdr.readLine();
					
						//While there is text remaining, search through the url line by line to find other urls
						while ( line != null) {
							Pattern site = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
							Matcher matcher = site.matcher(line);
						
							//if there is another instance of a url, add it to the map
							if (matcher.find()) 
								map.put(matcher.group(1), false);

							line = rdr.readLine();
							}	
					
					//Check the values in the map, if one matches the string searched last, change its value to true
					for (Map.Entry<String, Boolean> e: map.entrySet()) {
						if (e.getKey() == Site) {
							e.setValue(true);
						}
						
					}
					}
					catch (Exception ex) {System.out.printf("Uh oh: %s", ex.getMessage());}
					
				}
			//This was used to test the program
			//System.out.print(map);
			
			}
			catch (Exception ex) {System.out.printf("Oh no: %s", ex.getMessage());}

	}

	/**
	 * This takes the hashmap, finds the next URL that has a false value and returns that string
	 * @param map take in the map of urls
	 * @return the string of the first "false" string in the map
	 */
	private static String getURL(HashMap<String, Boolean> map) {
		//Check every url in the map until it finds one that has not yet been checked, then return the string
		for (Map.Entry<String, Boolean> e: map.entrySet()) {
			if (e.getValue() == false)
				return e.getKey();
		}
		//else return null
		return null;
	}
}
