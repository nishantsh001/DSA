package Stack;

import java.util.Scanner;

public class ReverseString {
	int MaxSize,tos;
	char stack[];
    //create_Stack:creates stack,init tos -1 and prepare stack for use
    void create_Stack(int size)
    {
        MaxSize=size;
        tos=-1;
        stack=new char[MaxSize];
    }
    //push(e):will insert element on top of stack
    //            tos+1
    void push(char e)
    {
        tos++;//1
        stack[tos]=e;//pushed---stack[++tos]=e
    }
    //isFull():returns true if full else false
    boolean isFull()
    {
        if(tos==MaxSize-1)//as array
            return true;
        else
            return false;
    }
    //pop():e remove and return element from tos,tos-1
    int pop()
    {
        int temp=stack[tos];//1
        tos--;//2
        return(temp);//3
    }
    //peek():e only returns element from tos/on the top
    int peek()
    {
        return(stack[tos]);
    }
    //isEmpty():returns true if empty else false
    boolean isEmpty()
    {
        if(tos==-1)//as array
            return true;
        else
            return false;
    }
    //print_stack():prints data in LIFO manner,tos to 0
    void print_Stack()
    {
        for(int i=tos;i>-1;i--)
        {
            System.out.println(stack[i]);
        }
    }
    public static void main(String[] args) {
    	
    	Scanner inScanner = new Scanner(System.in);
    	System.out.println("Enter a word: ");
    	String woString = inScanner.next();
    	
		// read from user
    	ReverseString reverseString = new ReverseString();
    	reverseString.create_Stack(woString.length());
    	for (int i = 0; i < woString.length(); i++) {
			reverseString.push(woString.charAt(i));
		}
    	
    	String rWordString = " ";
    	while (reverseString.isEmpty()!=true) {
			rWordString = rWordString+reverseString.pop();
		}
    	System.out.println(rWordString);
    	//let stack be size of word length itself
    	//use loop read char by char element from 0th to end
    	//and push in stack
    	//when all on stack print --pop(string +)
    	
	}
}
