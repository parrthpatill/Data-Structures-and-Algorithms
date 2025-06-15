import java.util.Stack;

public class ImplementMinStack {
    Stack<Integer> st;
    int min;

    ImplementMinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    void push(int val) {
        if (st.isEmpty()) {
            st.push(val);
            min = val;
        } else if (val < min) {
            st.push(2 * val - min); // Encode value
            min = val;
        } else {
            st.push(val);
        }
    }

    void pop() {
        if (st.isEmpty()) return;

        int top = st.pop();
        if (top < min) {
            // Recover previous min
            min = 2 * min - top;
        }
    }

    int peek() {
        if (st.isEmpty()) throw new RuntimeException("Stack is empty");
        int top = st.peek();
        if (top < min) {
            return min;
        } else {
            return top;
        }
    }

    int getMin() {
        if (st.isEmpty()) throw new RuntimeException("Stack is empty");
        return min;
    }
}
