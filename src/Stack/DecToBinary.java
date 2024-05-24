package Stack;

import java.util.Scanner;

public class DecToBinary {
	 int MaxSize,tos,stack[];
	    //create_Stack:creates stack,init tos -1 and prepare stack for use
	    void create_Stack(int size)
	    {
	        MaxSize=size;
	        tos=-1;
	        stack=new int[MaxSize];
	    }
	    //push(e):will insert element on top of stack
	    //            tos+1
	    void push(int e)
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
	    //main code for menu driven 1.push 2.pop 3.peek 4.print
	    public static void main(String args[])
	    {
	        int size = 64;//64 bit of processing
	        DecToBinary objBinary = new DecToBinary();
	        Scanner in=new Scanner(System.in);  
	        objBinary.create_Stack(size);
	        // read a number in DEC
	        //Using loop break number /2 and push remainder to stack
	        System.out.println("Enter a number ");
	        int no = in.nextInt();
	       while(no>0) {
	    	   int remainder = no%2;
	    	   objBinary.push(remainder);
	    	   no = no/2;
	       }
	       System.out.println("in binary ");
	       objBinary.print_Stack();
	    }
}
