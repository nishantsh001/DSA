package Stack;

import java.util.Scanner;

public class Wellness
{
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
        char pop()
        {
            char temp=stack[tos];//1
            tos--;//2
            return(temp);//3
        }
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

        public static void main(String args[])
        {
            boolean flag=true;
            char temp;
            Scanner in = new Scanner(System.in);
            System.out.println("Enter to Check:");// read a word from user
            String line=in.next();
            Wellness obj=new Wellness();
            obj.create_Stack(line.length());
            for(int i=0;i<line.length();i++)// and push in stack
            {
                char c = line.charAt(i);
                if (c == '{')
                    obj.push(c);
                else if (c == '}' && obj.isEmpty()!=true)
                    temp = obj.pop();
                else if(c == '}' && obj.isEmpty()==true)
                {
                    System.out.println("Error:} unexpected");
                    flag = false;
                    break;
                }

            }
            if(obj.isEmpty()==true && flag==true)
                System.out.println("Perfectly balanced:.....");
            else if(!obj.isEmpty())
                System.out.println("Error: } is expected");
        }
    }