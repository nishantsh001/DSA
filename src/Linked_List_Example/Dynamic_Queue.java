package Linked_List_Example;
import java.util.Scanner;
public class Dynamic_Queue
{	
    Node front,rear;

    void createQueue() {
        front =rear= null;
    }


    void dequeue() {
        if (front == null)//linked list not created
            System.out.println("Queue empty");
        else
        {
            Node t = front;//1 temp
            if (front==rear)//single node
            {
                front=rear=null;
            }
            else
            {
                front = front.next;//2 1800
            }
            System.out.println(t.data + "Deleted");
        }
    }



    void Enqueue(int e) {
        Node n = new Node(e);
        if (rear==null)//not created but assigned
        {
            rear=front= n;
        }
        else
        {
            rear.next=n;
            rear=n;
        }
    }
    void print_queue()
    {
        if (front == null)//linked list not created
            System.out.println("Queue Empty");
        else
        {
            Node t = front;
            while (t != null) {
                System.out.print("|" + t.data + "|---");
                t = t.next;
            }
        }
    }

    public static void main(String args[]) {
        int ch,e;
        Scanner in = new Scanner(System.in);
        Dynamic_Queue obj = new Dynamic_Queue();
        obj.createQueue();//user given size :stack
        do {
            System.out.println("\n1.Enqueue\n2.Dequeue\n3.Print\n0.Exit\n:");
            ch = in.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter data:");
                    e = in.nextInt();
                    obj.Enqueue(e);
                    System.out.println("Data to inserted");
                    break;
                case 2:
                    obj.dequeue();
                    break;
                case 3:
                    obj.print_queue();
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
