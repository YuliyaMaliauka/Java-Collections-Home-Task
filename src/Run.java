import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Run {
	
	public static void print(Map<?, ?> map)
	{
		for(Map.Entry<?,?> temp: map.entrySet()) {
			System.out.println(temp);
		}
	}
	
	public static void main(String[] args) {
	    Scanner sc = null;
		final String INPUT_CSV = "src/in.txt";
		final String DELIMETER = "[.,]?\\s+";		
		
		Map<String, Integer> map = new HashMap<String, Integer> ();
	    
		try {	
			sc = new Scanner(new FileReader(INPUT_CSV)).useDelimiter(DELIMETER);
			while(sc.hasNextLine()){
				String s = sc.next();
				s.toLowerCase();
				if(map.containsKey(s)){
					Integer in = map.get(s) + 1;
					map.put(s, in);
				}
				else
					{
					map.put(s, 1);
					}	    
		}
		print(map);
		} catch (NoSuchElementException e) {
			e.getMessage();

		} catch (FileNotFoundException e) {
            System.err.println("Input file is not found");

        } finally {
            if(sc != null) {
                sc.close();
            }
        }
}
		
}
