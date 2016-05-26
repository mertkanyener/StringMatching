
public class Test {
	public static void main(String[] args){
		String p = "yener";
		String text = "mertkanyener";
		StrMatcher s = new StrMatcher();
		int[][] t = s.computeTranF(p);
		//s.printTranF(t);
		boolean check = s.finiteAutomatonMatcher(text, t, p);
		System.out.println(check);
	}

}
