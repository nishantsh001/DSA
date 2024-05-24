package Stack;

import java.util.Scanner;

public class Paranthesis_complex {
    int MaxSize, tos;
    char stack[];
    char postfix[];
    int postfixIndex;

    // Create stack, initialize tos -1 and prepare stack for use
    void create_Stack(int size) {
        MaxSize = size;
        tos = -1;
        stack = new char[MaxSize];
        postfix = new char[MaxSize];
        postfixIndex = 0;
    }

    // Push element on top of stack
    void push(char e) {
        stack[++tos] = e;
    }

    // Check if stack is full
    boolean isFull() {
        return tos == MaxSize - 1;
    }

    // Pop element from top of stack
    char pop() {
        return stack[tos--];
    }

    // Peek element at top of stack
    char peek() {
        return stack[tos];
    }

    // Check if stack is empty
    boolean isEmpty() {
        return tos == -1;
    }

    // Print stack in LIFO manner
    void print_Stack() {
        for (int i = tos; i > -1; i--) {
            System.out.println(stack[i]);
        }
    }

    // Return precedence of operator
    int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
            case '+':
            case '-':
                return 1;
            case '(':
            case ')':
                return 0; // Parentheses handled separately
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter infix expression:");
        String line = in.next();
        Paranthesis_complex obj = new Paranthesis_complex();
        obj.create_Stack(line.length());

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            // If the character is an operand, add it to the output
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
                obj.postfix[obj.postfixIndex++] = c;
            }
            // If the character is '(', push it to the stack
            else if (c == '(') {
                obj.push(c);
            }
            // If the character is ')', pop and output from the stack until an '(' is encountered
            else if (c == ')') {
                while (!obj.isEmpty() && obj.peek() != '(') {
                    obj.postfix[obj.postfixIndex++] = obj.pop();
                }
                if (!obj.isEmpty() && obj.peek() != '(') {
                    System.out.println("Invalid Expression"); // invalid expression
                    return;
                } else {
                    obj.pop();
                }
            }
            // An operator is encountered
            else {
                while (!obj.isEmpty() && obj.precedence(c) <= obj.precedence(obj.peek())) {
                    obj.postfix[obj.postfixIndex++] = obj.pop();
                }
                obj.push(c);
            }
        }

        // Pop all the operators from the stack
        while (!obj.isEmpty()) {
            obj.postfix[obj.postfixIndex++] = obj.pop();
        }

        System.out.print("Postfix expression: ");
        for (int i = 0; i < obj.postfixIndex; i++) {
            System.out.print(obj.postfix[i]);
        }
    }
}
