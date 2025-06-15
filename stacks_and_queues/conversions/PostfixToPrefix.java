import java.util.Stack;
public class PostfixToPrefix {
	String postfixToPrefix(String s){
		Stack<String> st = new Stack<>();
		for(char ch : s.toCharArray()){
			if(Character.isLetterOrDigit(ch)){
				st.push(Character.toString(ch));
			} else {
				String t1 = st.pop();
				String t2 = st.pop();
				st.push(ch + t2 + t1);
			}
		}
		return st.peek();
	}
}