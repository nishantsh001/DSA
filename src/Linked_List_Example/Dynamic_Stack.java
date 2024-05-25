//dynamic stack
package Linked_List_Example;

import java.util.Scanner;

public class Dynamic_Stack
{
    Node tos;

    void createStack() {
        tos = null;
    }

    void push(int e) {
        //create a node
        Node n = new Node(e);
        if (tos == null)//not created but assigned
            tos = n;
        else {
            n.next = tos;//1 1000
            tos = n;//2 800
        }

    }

    void pop() {
        if (tos == null)//linked list not created
            System.out.println("Stack Empty");
        else {
            Node t = tos;//1 temp
            tos = tos.next;//2 1800
            System.out.println(t.data + " Poped");
        }

    }
    void peek() {
        if (tos == null)//linked list not created
            System.out.println("Stack Empty");
        else {
            System.out.println(tos.data + " is at Peek");
        }

    }


    void print_Stack() {
        if (tos == null)//linked list not created
            System.out.println("Stack Empty");
        else {
            Node t = tos;
            while (t != null) {
                System.out.println(t.data );
                t = t.next;
            }
        }
    }

    public static void main(String args[]) {
        int ch,e;
        Scanner in = new Scanner(System.in);
        Dynamic_Stack obj = new Dynamic_Stack();
        obj.createStack();//user given size :stack
        do {
            System.out.println("\n1.Push\n2.Pop\n3.Peek\n4.Print\n0.Exit\n:");
            ch = in.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter data:");
                    e = in.nextInt();
                    obj.push(e);
                    System.out.println("Data to inserted");
                    break;
                case 2:
                    obj.pop();
                    break;
                case 3:
                    obj.peek();
                    break;
                case 4:
                    obj.print_Stack();
                    break;
                case 0:
                    System.out.println("Exiting.....");
                    break;
                default:
                    System.out.println("Wrong option selected");
                    break;
            }
        } while (ch != 0);
    }
}
