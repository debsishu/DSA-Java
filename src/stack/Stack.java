package stack;

public class Stack {

    public static void main(String[] args) throws Exception {
        Stack s = new Stack(12);
        s.push(12);
        s.push(13);
        s.push(34);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }

    int Stack[], top = -1;
    int size;

    public Stack(int size) {
        this.size = size;
        Stack = new int[size];
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(int item) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is already full");
        } else {
            Stack[++top] = item;
        }
    }

    public int pop() {
        if (isEmpty()) {
            return 0;
        } else {
            return Stack[top--];
        }
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        } else {
            return Stack[top];
        }
    }

    public void traverse() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is already full");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(Stack[i]);
            }
        }
    }
}
