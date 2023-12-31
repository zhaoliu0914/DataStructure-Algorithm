package stack;

public class TestStack {

    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<String>();

        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        stack.printStack();

        stack.push("6");
        stack.push("7");
        stack.push("8");
        stack.push("9");
        stack.push("10");

        stack.push("11");
        stack.push("12");
        stack.push("13");
        stack.push("14");
        stack.push("15");

        stack.push("16");
        stack.push("17");
        stack.push("18");
        stack.push("19");
        stack.push("20");

        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();

        stack.pop();
        stack.printStack();
    }

}
