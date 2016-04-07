import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Run {	
	
	//method search word (key) in the text and its frequency (value)
	public static void findWord(Map<?, ?> map, String word){ 
		System.out.println("In the original text the word "+ word);
		System.out.println(map.get(word) == null ? " not found" :" found: "+ map.get(word)+" times");
	}
	
	public static void main(String[] args) {
	    Scanner sc = null;
		final String INPUT_CSV = "src/in.txt";
		final String DELIMETER = "[.,]?\\s+";				
		Map<String, Integer> map = new HashMap<String, Integer> ();	    
		try {	
			//Parse the data from a file
			sc = new Scanner(new FileReader(INPUT_CSV)).useDelimiter(DELIMETER);
			while(sc.hasNextLine()){
				String s = sc.next();
				s.toLowerCase();
				//fill collection
				if(map.containsKey(s)){
					Integer in = map.get(s) + 1;
					map.put(s, in);
				}
				else{
					map.put(s, 1);
				}	    
			}
			//call search methods
			findWord(map,"Collections"); 
			findWord(map,"Yuliya");
			
		} 
		catch (NoSuchElementException e) {
			e.getMessage();
		} 
		catch (FileNotFoundException e) {
			System.err.println("Input file is not found");
		} 
		finally {
			if(sc != null) {
                	sc.close();
			}
		}
	}
}
