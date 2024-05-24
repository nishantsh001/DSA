package Queue;

import java.util.Scanner;

public class Priority_Queue {
	    int queue[],MaxSize,front,rear;
	    void createQueue(int size)
	    {
	        rear=-1;
	        front=0;
	        MaxSize=size;
	        queue=new int[MaxSize];

	    }
	    void enqueue(int element)
	    {
	        //accept element in queue then sort the queue
	        rear++;
	        queue[rear]=element;
	        //sorting code comes here
	        for(int i=front;i<rear;i++)
	        {
	            for(int j=front;j<rear;j++)
	            {
	                if(queue[j]>queue[j+1])//APQ     < DPQ
	                {
	                    int temp=queue[j];
	                    queue[j]=queue[j+1];
	                    queue[j+1]=temp;
	                }
	            }
	        }
	    }
	    boolean is_Full()
	    {
	        if(rear==MaxSize-1)
	            return true;
	        else
	            return false;
	    }
	    int dequeue()
	    {
	        int temp=queue[front];
	        front++;
	        return(temp);
	    }
	    boolean is_Empty()
	    {
	        if(front>rear)
	            return true;
	        else
	            return false;
	    }


	    void print_queue()
	    {
	        for(int i=front;i<=rear;i++)
	            System.out.print(queue[i]+"--");
	    }

	    public static void main(String args[])
	    {
	        int ch;
	        Scanner in=new Scanner(System.in);
	        Priority_Queue  obj=new Priority_Queue();
	        System.out.println("Enter size of queue:");
	        int size=in.nextInt();
	        obj.createQueue(size);//user given size :stack
	        do
	        {
	            System.out.println("1.Enqueue\n2.Dequeue\n3.Print\n0.Exit\n:");
	            ch=in.nextInt();
	            switch(ch)
	            {
	                case 1:
	                    if(!obj.is_Full())//if not full then take data
	                    {
	                        System.out.println("Enter data to insert:");
	                        int e=in.nextInt();
	                        obj.enqueue(e);
	                        System.out.println("Data to enqueued");
	                    }
	                    else {
	                        System.out.println("Queue Full");
	                    }
	                    break;
	                case 2:
	                    if(!obj.is_Empty())//if not Empty then dequeue
	                    {
	                        int e=obj.dequeue();
	                        System.out.println("Data dequeued:"+e);
	                    }
	                    else
	                    {
	                        System.out.println("Queue Empty");
	                    }
	                    break;
	                case 3:
	                    if(!obj.is_Empty())//if not Empty then print
	                    {
	                        System.out.println("Data in queue");
	                        obj.print_queue();
	                    }
	                    else
	                    {
	                        System.out.println("Queue Empty");
	                    }
	                    break;
	                case 0:
	                    System.out.println("Exiting.....");
	                    break;
	                default:
	                    System.out.println("Wrong option selected");
	                    break;
	            }
	        }while(ch!=0);
	    }
	}
