package Dynamic;

import java.util.Scanner;

class Node{
	int data;
	Node nexNode;
	
	public Node(int data) {
		this.data = data;	
		this.nexNode = null;
	}
}
public class DynamicStack {
	Node tosNode;
	
	void createStack() {
		tosNode = null;
	}
	
	void push(int e) {
		Node node = new Node(e);
		if(tosNode == null) {
			System.out.println("Empty ");
		}
		else {
			node.nexNode = tosNode;
			tosNode = null;
		}
	}
	
	void pop() {
		if(tosNode == null) {
			System.out.println("Empty ");
		}
		else {
			Node tNode = tosNode;
			tosNode = tosNode.nexNode;
			System.out.println(tNode + " popped");
		}
	}
	
	void peek() {
		if(tosNode == null) {
			System.out.println("Empty ");
		}
		else {
			System.out.println(tosNode.data+ " is at peek");
		}
	}
	
	void print_stack() {
		if(tosNode == null) {
			System.out.println(" Stack Empty ");
		}
		else {
			Node tNode = tosNode;
			while(tNode!=null) {
				System.out.println(tNode);
				tNode = tNode.nexNode; 
			}
		}
	}
	public static void main(String args[]) {
        int ch,e;
        Scanner in = new Scanner(System.in);
        DynamicStack obj = new DynamicStack();
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
                    obj.print_stack();
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
