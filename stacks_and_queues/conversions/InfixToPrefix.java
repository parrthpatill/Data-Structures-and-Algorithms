import java.util.Stack;

public class InfixToPrefix {
	private int priority(char ch){
		if(ch == '^') return 3;
		else if(ch == '*' || ch == '/') return 2;
		else if(ch == '+' || ch == '-') return 1;
		else return -1;
	}
	private String reverse(String s){
		int l = 0;
		int r = s.length() - 1;
		char[] chars = s.toCharArray();
		for(int i = 0; i<chars.length; i++){
			if(chars[i] == '(') chars[i] = ')';
			else if(chars[i] == ')') chars[i] = '(';
		}
		while(l <= r){
			char temp = chars[l];
    		chars[l] = chars[r];
    		chars[r] = temp;
    		l++;
    		r--;
		}
		return new String(chars);
	}
	String infixToPrefix(String s){
		s = reverse(s);
		Stack<Character> st = new Stack<>();
		String ans = "";

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
				if(it == '^'){
					while(!st.empty() && priority(it) <= priority(st.peek())){
						ans += st.pop();
					}
				} else{
					while(!st.empty() && priority(it) < priority(st.peek())){
						ans += st.pop();
					}
				}
				st.push(it);
			}
		}
		while(!st.empty()){
			ans += st.pop();
		}
		return reverse(ans);
	}
}