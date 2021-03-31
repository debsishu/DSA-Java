package stack;
public class MainClass {
  public static void main(String[] args) throws Exception {
    Stack s = new Stack(12);
    s.push(12);
    s.push(13);
    s.push(34);
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
  }
}
