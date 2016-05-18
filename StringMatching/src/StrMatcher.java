import java.util.Vector;

public class StrMatcher {
	private String characters=""; // A string to keep the characters of the alphabet of a string pattern
	
	/***
	 * Produces the alphabet of the input string
	 * @param s = An input string
	 * @return
	 */
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
	/***
	 * Computes the transition matrix of a string pattern
	 * @param p = pattern
	 * @return
	 */
	public int[][] computeTranF(String p){
		Vector<Character> alph = produceAlph(p);
		int m = p.length();
		int[][] M = new int[m+1][alph.size()];
		for(int q = 0; q<=m; q++){
			for(char e : alph){
				int k = Math.min(m+1, q+2);
				do{
					k = k-1;
				}while(!(p.substring(0,q) + e).endsWith(p.substring(0,k)));
				int a = alph.indexOf(e);
				M[q][a] = k;
				String str = Character.toString(e);
				if(!characters.contains(str)){
					characters = characters + " " + str;
				}
			}
		}
		return M;
	}
	/***
	 * Prints out the transition matrix
	 * @param t = transition matrix
	 */
	public void printTranF(int[][] t){
		System.out.println("Printing transition function...");
		System.out.println("  " + characters);
		for(int i = 0; i<t.length; i++){
			System.out.print(i+"  ");
			for(int j = 0; j<t[i].length; j++){
				System.out.print(t[i][j] + " ");
			}
			System.out.println("");
		}
	}
	/***
	 * Gets the index of an char if it is in the given alphabet, if not returns -1
	 * @param x = A character
	 * @param alph = An alphabet
	 * @return
	 */
	public int charIndex(char x, Vector<Character> alph){
		int result = -1;
		for(int i = 0; i < alph.size(); i++){
			if(x == alph.elementAt(i)){
				result = i;
			}
		}
		return result;
	}
	/***
	 * Checks if given pattern is in the given text, if so returns true and tells where it occurs, if not returns false
	 * @param text = Text to be searched 
	 * @param t = Transition matrix of the pattern
	 * @param p = Pattern
	 * @return
	 */
	public boolean finiteAutomatonMatcher(String text, int[][] t, String p){
		boolean result = false;
		int n = text.length();
		int m = p.length();
		int q = 0;
		char x;
		int ch;
		Vector<Character> alph = produceAlph(p);
		for(int i = 0; i < n; i++){
			x = text.charAt(i);
			ch = charIndex(x,alph);
			if(ch>=0){
				q = t[q][ch];
			}
			else{
				q = 0;
			}
			if(q==m){
				System.out.println("Pattern occurs with shift " + (i+1-m));
				result = true;
			}
		}
		return result;
		
	}
	

}
