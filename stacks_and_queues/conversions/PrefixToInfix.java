import java.util.Stack;

public class PrefixToInfix{
	String prefixToInfix(String s){
		char[] chars = s.toCharArray();
		Stack<String> st = new Stack<>();
		for(int i = chars.length - 1; i >= 0; i--){
			if(Character.isLetterOrDigit(chars[i])){
				st.push(Character.toString(chars[i]));
			} else {
				String s1 = st.pop();
				String s2 = st.pop();
				st.push("(" + s1 + chars[i] + s2 + ")");
			}
		}
		return st.peek();
	}
}