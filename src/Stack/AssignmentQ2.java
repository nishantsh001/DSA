package Stack;

import java.util.Scanner;

public class AssignmentQ2 {
    int maxSize, tos1, tos2;
    int stack[];

    void create_Stack(int size) {
        maxSize = size;
        tos1 = -1;
        tos2 = maxSize;
        stack = new int[maxSize];
    }

    void push1(int ch) {
        if (!isFull1()) {
            tos1++;
            stack[tos1] = ch;
        } else {
            System.out.println("Stack 1 is full..");
        }
    }

    void push2(int ch) {
        if (!isFull2()) {
            tos2--;
            stack[tos2] = ch;
        } else {
            System.out.println("Stack 2 is full..");
        }
    }

    boolean isFull1() {
        return tos1 + 1 == tos2 || tos1 == maxSize - 1;
    }

    boolean isFull2() {
        return tos2 - 1 == tos1 || tos2 == 0;
    }

    int pop1() {
        if (!isEmpty1()) {
            int temp = stack[tos1];
            tos1--;
            return temp;
        } else {
            System.out.println("Stack 1 is empty..");
            return -1; // Indicates an error condition
        }
    }

    int pop2() {
        if (!isEmpty2()) {
            int temp = stack[tos2];
            tos2++;
            return temp;
        } else {
            System.out.println("Stack 2 is empty..");
            return -1; // Indicates an error condition
        }
    }

    boolean isEmpty1() {
        return tos1 == -1;
    }

    boolean isEmpty2() {
        return tos2 == maxSize;
    }

    int peek1() {
        if (!isEmpty1()) {
            return stack[tos1];
        } else {
            System.out.println("Stack 1 is empty..");
            return -1; // Indicates an error condition
        }
    }

    int peek2() {
        if (!isEmpty2()) {
            return stack[tos2];
        } else {
            System.out.println("Stack 2 is empty..");
            return -1; // Indicates an error condition
        }
    }

    void printStack1() {
        if (!isEmpty1()) {
            for (int i = tos1; i > -1; i--) {
                System.out.println(stack[i]);
            }
        } else {
            System.out.println("Stack 1 is empty..");
        }
    }

    void printStack2() {
        if (!isEmpty2()) {
            for (int i = tos2; i < maxSize; i++) {
                System.out.println(stack[i]);
            }
        } else {
            System.out.println("Stack 2 is empty..");
        }
    }

    public static void main(String[] args) {
        AssignmentQ2 assignmentQ2 = new AssignmentQ2();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter size of stack:");
        int size = sc.nextInt();
        assignmentQ2.create_Stack(size);

        int choice;
        do {
            System.out.println("\n1. Push1 \n2. Pop1 \n3. Peek1 \n4. Print1 \n5. Push2 \n6. Pop2 \n7. Peek2 \n8. Print2 \n9. Print All \n0. Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    if (!assignmentQ2.isFull1()) {
                        System.out.println("Enter an element:");
                        int element = sc.nextInt();
                        assignmentQ2.push1(element);
                    } else {
                        System.out.println("Stack 1 is full..");
                    }
                }
                case 2 -> {
                    int poppedElement = assignmentQ2.pop1();
                    if (poppedElement != -1) {
                        System.out.println("Element Popped: " + poppedElement);
                    }
                }
                case 3 -> {
                    int peekedElement = assignmentQ2.peek1();
                    if (peekedElement != -1) {
                        System.out.println("Element @ Peek: " + peekedElement);
                    }
                }
                case 4 -> assignmentQ2.printStack1();

                case 5 -> {
                    if (!assignmentQ2.isFull2()) {
                        System.out.println("Enter an element:");
                        int element = sc.nextInt();
                        assignmentQ2.push2(element);
                    } else {
                        System.out.println("Stack 2 is full..");
                    }
                }
                case 6 -> {
                    int poppedElement = assignmentQ2.pop2();
                    if (poppedElement != -1) {
                        System.out.println("Element Popped: " + poppedElement);
                    }
                }
                case 7 -> {
                    int peekedElement = assignmentQ2.peek2();
                    if (peekedElement != -1) {
                        System.out.println("Element @ Peek: " + peekedElement);
                    }
                }
                case 8 -> assignmentQ2.printStack2();

                case 9 -> {
                  
                    assignmentQ2.printStack1();
                    assignmentQ2.printStack2();
                }

                case 0 -> System.out.println("Thanks for using the code...");
                default -> System.out.println("Wrong option selected..");
            }
        } while (choice != 0);

        sc.close();
    }
}
