package Linked_List_Example;
import java.util.Scanner;


public class Linear_Linked_List {
	Node root;

	public void create_list() {
		root = null;// indicate list is not created till now
	}

	public void insert_left(int data) {
		Node n = new Node(data);
		if (root == null) {
			root = n;
		} else {
			n.next = root;//1
			root = n;//2
		}
	}
	
	void insert_right(int data) {
		Node n = new Node(data);
		if(root==null) {
			root = n ;
		}
		else {
			Node tNode = root;	//1
			while(tNode.next!=null) //2 
			{
				tNode = tNode.next ;
			}
			tNode.next = n;//3
		}
	}
	
	void delete_left() {
		
		if(root==null) {
			System.out.println("Empty list");
		}
		else {
			Node tNode = root;//1 copy
			root = root.next;//2
			System.out.println(tNode.data+ " deleted");
		}
	}
	
	void delete_right() {
		Node tNode, tNode2;
		tNode=tNode2 = root;//1
		while(tNode.next!=null) //2
		{
			tNode2 = tNode;
			tNode = tNode.next;
		}
		if(root==null) 
		{
			System.out.println("Empty list");
		}
		else 
		{
					tNode2.next = null;
		}
		System.out.println("Deleted "+ tNode.data);
	}
	
	void print_list() {
		
		if (root == null) {
			System.out.println("Empty ");
		}
		else {
			Node t = root;
			while(t!=null) {
				System.out.print("|"+t.data + "|->");
				t = t.next;
			}
		}
		
	}
	
	void search(int key) {
		if(root == null) 
		{
			System.err.println("Empty");
		}
		else 
		{
			Node tNode = root;
			while(tNode!=null && tNode.data!=key) {
				tNode = tNode.next;
			}
			if(tNode==null)
			      System.out.println(key+" not found in list");
            else
                System.out.println(key+" found in list");
		}
	}
	
	
    void deleteSpecific(int key) {
        if (root == null)//root is assigned not created
            System.out.println("Empty List");
        
        else 
        {
			Node tNode = root;
			Node t2 = tNode;
			
			while (tNode!=null && tNode.data !=key)
			{
				tNode = tNode.next;
			}
			
			if(tNode==null) 
			{
				System.out.println("not Found in the list ");
			}
			else //found
			{
				//case1: delete left;
				//case2:delete right;
				//case3:in between;
				if(tNode==root)//case 1
                    root=root.next;
				else if (tNode.next==null)//case 2
					t2.next = null;
				else 
					t2.next = tNode.next;
				System.out.println("Deleted:"+tNode.data);
			}
		}
        
    }
	public static void main(String[] args) {
		Linear_Linked_List obj = new Linear_Linked_List();
		Scanner scanner = new Scanner(System.in);
		
		int ch, e;
		obj.create_list();
		do {
            System.out.println("\n1.Insert Left\n2.Insert Right\n3.Delete Left\n4.Delete Right\n5.Print List\n6.Search\n7.Delete On Data\n8.Insert at\n0.Exit\n:");
            ch = scanner.nextInt();
            
            switch (ch)
            {
			case 1: System.out.println("Insert Left ");
				e = scanner.nextInt();
				obj.insert_left(e);
				break;
			
			case 2: System.out.println("Insert Right ");
				e = scanner.nextInt();
				obj.insert_right(e);
				break;
			
			case 3: 
				obj.delete_left();
			break;
			

			case 4: 
				obj.delete_right();
				break;
				

			case 5: 
				obj.print_list();
				break;
				
			case 0:
				System.out.println("Exiting.....");
                break;
            }
            
		} while (ch!=0);
		scanner.close();
	}
	
}
