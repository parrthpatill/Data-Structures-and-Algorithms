import java.util.Stack;

public class PostfixToInfix{
	String postfixToInfix(String s){
		Stack<String> st = new Stack<>();
		for(char ch : s.toCharArray()){
			if(Character.isLetterOrDigit(ch)){
				st.push(Character.toString(ch));
			} else {
				String s1 = st.pop();
				String s2 = st.pop();
				st.push("(" + s2 + ch + s1 + ")");
			}
		}
		return st.peek();
	}
}