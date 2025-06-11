import java.util.Stack;

public class InfixToPostfix {

	private int priority(char ch){
		if(ch == '^') return 3;
		else if(ch == '*' || ch == '/') return 2;
		else if(ch == '+' || ch == '-') return 1;
		else return -1;
	}
	
	String infixToPostfix(String s){
		String ans = "";
		Stack<Character> st = new Stack<>();
		for(char it : s.toCharArray()){
			if((it >= 'A' && it <= 'Z') ||
			 	(it >= 'a' && it <= 'z') ||
				(it >= '0' && it <= '9')){

				ans += it;
			} else if(it == '('){
				st.push(it);
			} else if(it == ')'){
				while(!st.empty() && st.peek() != '('){
					ans += st.pop();
				}
				st.pop();
			} else {
				while(!st.empty() && priority(it) <= priority(st.peek())){
					ans += st.pop();
				}
				st.push(it);
			}
		}
		while(!st.empty()){
			ans += st.pop();
		}

		return ans;
	}
}