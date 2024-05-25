package Doubly_LinkedList;

public class DLL {
	DNode root;
		public void create_list() {
			root = null;// indicate list is not created till now
	}
		
		 void insert_left(int data) {
			DNode n = new DNode(data);
			if (root == null) {
				root = n;
			} else {
				n.right = root;//1
				root.left = n;//2
				root = n;//3
			}
		}
		 
		 void delete_left() {
				
				if(root==null) {
					System.out.println("Empty list");
				}
				else {
					DNode tNode = root;//1 copy
					root = root.right;//2
					if(root!=null) 
						root.left = null;
					
					System.out.println(tNode.data+ " deleted");
				}
			}
		 
			void insert_right(int data) {
				DNode n = new DNode(data);
				if(root==null) {
					root = n ;
				}
				else {
					DNode tNode = root;	//1
					while(tNode.right!=null) //2 
					{
						tNode = tNode.right ;
					}
					tNode.right = n;//3
					tNode.left = tNode;
				}
			}
			
			void delete_right() {
				
				if(root==null) {
					System.out.println("Empty list");
				}
				else {
					DNode t, t2;
					t = root;//1 copy
					while (t.right!=null) {
						t = t.right;//moves ahead
					}
					if(t==root)//only for single node
						root = null;
					else {
						t2 = t.left;//3
						t2.right = null;//4
						System.out.println("Deleted "+t.data);
					}
				}
			}
			
			void rev_print_list() {
				
				if (root == null) {
					System.out.println("Empty ");
				}
				else {
					DNode t = root;
					while(t!=null) {
						System.out.print("|"+t.data + "|->");
						t = t.right;
					}
				}
				
			}
			
			void front_print_list() {
				
				if (root == null) {
					System.out.println("Empty ");
				}
				else {
					DNode t = root;
					while(t.right!=null) {
						t = t.right;
					}
					while(t!=null) 
					{
						System.out.println("|" + t.data + "|-");
						t = t.left;
					}
				}
				
			}

			
}
