import java.util.Stack;
public class PrefixToPostfix {
	String prefixToPostfix(String s){
		Stack<String> st = new Stack<>();
		char[] chars = s.toCharArray();
		for(int i = chars.length - 1; i>=0; i--){
			if(Character.isLetterOrDigit(chars[i])){
				st.push(Character.toString(chars[i]));
			} else {
				String t1 = st.pop();
				String t2 = st.pop();
				st.push(t1 + t2 + chars[i]);
			}
		}
		return st.peek();
	}
}