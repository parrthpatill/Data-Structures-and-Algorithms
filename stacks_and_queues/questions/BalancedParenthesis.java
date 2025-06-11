import java.util.Stack;

public class BalancedParenthesis {
	boolean balancedParenthesis(String s){
		Stack<Character> st = new Stack<>();
		for(char it : s.toCharArray()){
			if((it == '(') || (it == '{') || (it == '[')){
				st.push(it);
			} else {
				if(st.empty()) return false;
				if((it == '}') && (st.peek() == '{') ||
					(it == ']') && (st.peek() == '[') ||
					(it == ')') && (st.peek() == '(')){
					st.pop();;
				} else {
					return false;
				}
			}
		}
		return st.empty();
	}
}