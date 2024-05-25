package TreeExamples;
import java.util.*;

public class Binary_Tree
{
    Dnode rootDnode;
    
    void init_tree(){
    	rootDnode = null;
    }
    
    void insert(Dnode r, Dnode n)//r:root as ref and    n:new node to insert
    {
    	if(rootDnode == null)
    		rootDnode = n;
    	
    	else //Tree exist
    	{
			if(n.data<r.data) //if lesser left
			{
				if(r.left==null) 
					r.left=n;
				
				else 
					insert(r.left, n);			
			}
			else {
				if(r.data>n.data) {
					if(r.right==null) {
						r.right=n;
					}
					else 
						insert(r.right, n);
				}
			}
		}
    }
    
    void inOrder(Dnode r) //LPR 
    {
    	if(rootDnode!= null) {
    		inOrder(r.left);
    		System.out.println(r.data);
    		inOrder(r.right);
    	}
    	
    }
    
    void preOrder(Dnode r) //PLR
    {
		if(rootDnode!=null) {
			System.out.println(r.data);
			preOrder(r.left);
			preOrder(r.right);
		}
	}
        
    void postOrder(Dnode r) {
    	if(rootDnode!=null) {
    		postOrder(r.left);
    		postOrder(r.right);
    		System.out.println(r.data);
    	}
    }
    
    boolean booleanSearch(Dnode r, int key) {
    	boolean left, right;
    	if(r==null) 
    		return false;
    	else {
			if(r.data==key) {
				return true;
			}
		}
    	left = booleanSearch(r.left, key);
    	right = booleanSearch(r.right, key);
    	return left||right;
    }
    
    int count(Dnode r)
    {
    	int left, right;
    	if(r==null)
    		return 0;
    	else {
			left = count(r.left);
			right = count(r.right);
			return right + left;
		}
    }
    
    int depth(Dnode r) {
    	int left, right;
    	if(r==null)
    		return 0;
    	else {
			left = depth(r.left);
			right = depth(r.right);
			//return Math.max(left, right);
			return (left>right? left:right );
		}
    }
    boolean IsBalance(Dnode r) {
    	int left, right;
    	if(r==null)
    		return false;
    	else {
			right = depth(r.left);
			left = depth(r.right);
			int balanceFactor= left - right;
	    	return balanceFactor == -1 || balanceFactor == 0 || balanceFactor == 1;
		}
    }
    public static void main(String args[]) {
        int ch,e;
        Scanner in = new Scanner(System.in);
        Binary_Tree obj = new Binary_Tree();
        obj.init_tree();
        do {
            System.out.println("\n1.Insert\n2.Inorder\n3.Search\n4.Count\n5.Depth\n0.Exit\n:");
            ch = in.nextInt();
            switch (ch)
            {
                case 1:
                    System.out.println("Enter data:");
                    e = in.nextInt();
                    Dnode n=new Dnode(e);//n(150)
                    obj.insert(obj.rootDnode,n);//insert((100),n(150))
                    System.out.println("Data to inserted");
                    break;
                case 2:
                    System.out.println("Data in inorder:");
                    obj.inOrder(obj.rootDnode);//inorder(root:100)
                    break;
                case 3:
                    System.out.println("Enter data to search:");
                    e = in.nextInt();
                    System.out.println(e+" Found in tree:"+ obj.booleanSearch(obj.rootDnode,e));
                    break;
                case 4:
                    System.out.println("Total nodes :"+obj.count(obj.rootDnode));
                    break;
                case 5:
                    System.out.println("Depth is:"+(obj.depth(obj.rootDnode)-1));
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












