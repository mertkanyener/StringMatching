import java.util.Vector;

public class StrMatcher {
	
	public Vector<Character> produceAlph(String s){
		Vector<Character> result = new Vector<Character>();
		for(int i = 0; i < s.length(); i++){
			char x = s.charAt(i);
			if(!result.contains(x)){
				result.add(x);
			}
		}
		return result;
	}

}
