package Stack;

import java.util.Scanner;

//First ADT


//Linear, static, one ended, Nature-LIFO
// use push() and pop()
public class Stack_Basic {
		int MaxSize, tos, stack[];
		//create stack init tos-1 and prepare stack for use
		void create_Stack(int size) {
			MaxSize = size;
			tos = -1;
			stack = new int[MaxSize];
		}
		
		//push(e)::will insert element on top of stack
		//tos+1
		void push(int e) {
			tos++;//1
			stack[tos] = e;//pushed---stack[++tos] = e
		}
		
		//isFull(): returns true if full else false
		boolean isFull()
		{
			if(tos==MaxSize-1)//as array
				return true;
			else 
				return false;
		}
		//pop():e return  element from tos, tos -1
		int pop() {
			int temp = stack[tos];
			tos--;
			return(temp);
		}
		
		//peek(): e only returns element from tos on the top
		int peek() {
			return (stack[tos]);
		}
		
		boolean isEmpty() {
			if(tos==-1)//as array
				return true;
			else {
				return false;
			}
			
		}
		
		//print_Statck(): prints data in LIFO return tos to 0
		void print_Stack() {
			for (int i = tos; i >-1; i--) {
				System.out.println(stack[i]);
			}
		}
		//main code for menu driven push to 1. push, 2.pop, 3.peek, 4.print
		public static void main(String[] args) {
			int size, element, choice;
			
			Stack_Basic objBasic = new Stack_Basic();
			
			System.out.println("Enter size of stack ");
			Scanner scanner = new Scanner(System.in);
			size = scanner.nextInt();
			do {
				System.out.println("\n 1.Push\n2.Pop\n3.Peek\n4.Print");
				choice = scanner.nextInt();
				switch (choice) {
				case 1: {
					if(objBasic.isFull()!=true){//!obj.isFull()
						System.out.println("Enter all elements ");
					element = scanner.nextInt();
					objBasic.push(element);
				}
				else {
					System.out.println("stack is full");
				}
				}
			}while(choice!=0);//condition exit choice is inverted to option
		}
	}
