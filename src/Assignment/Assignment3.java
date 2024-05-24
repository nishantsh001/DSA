
/*
 Coding Challenge: Menu-Driven Employee Management with Linked Lists

Develop a menu-driven program in your preferred programming language that utilizes linked lists to manage employee records. Each employee record should contain the following information:

Employee ID (a unique identifier)
Name
Gender
Salary
The program should present a user-friendly menu with the following options:

Add Employee Record:

Prompt the user to enter the details of a new employee.
Add this record to the linked list, ensuring the ID is unique.
Search Employee Record:

Ask the user for an employee ID.
Search the linked list for a matching record and display the employee's details if found. If not found, indicate that the record doesn't exist.
List All Employee Records:

Traverse the linked list and display all employee records in a clear format.
Delete Employee Record:

Prompt the user for an employee ID to delete.
Locate and remove the corresponding record from the linked list. If not found, notify the user.
Exit:

Terminate the program.*/
package Assignment;

import java.util.*;

class Node{
	int empId;
	static int statid;
	String nameString;
	String genderString;
	double salary;
	Node nextNode;
	
	Node( String nameString, String genderString, Double salary){
		statid++;
		this.empId = statid;
		this.genderString = genderString;
		this.nameString = nameString;
		this.salary = salary;
		this.nextNode = null;
	}
}
public class Assignment3 {
	Node rootNode;
	
	void insert_right(String namString, String geString, Double salary) {
		Node node = new Node( namString, geString, salary);
		
		if (rootNode==null) {
			rootNode = node;
		}
		else {
			Node tNode = rootNode;
			while(tNode!=null) {
				tNode = tNode.nextNode;
			}
			tNode.nextNode = node;
		}
		
	}
	
	void search(int key) {
		if(rootNode== null) {
			System.out.println("Empty ");
		}
		else {
			Node tNode = rootNode;
			while(tNode!=null && tNode.empId!=key) {
				tNode = tNode.nextNode;
			}
			if(tNode==null)
				System.out.println(key+" not found");
		else {
			System.out.println(key+" found");
		}
	}
	}
	void deleteSpecific(int key) {
		if(rootNode== null) {
			System.out.println("Empty list ");
		}
		else {
			Node tNode = rootNode;
			Node tNode2 = tNode;
			while (tNode.empId!=key && tNode!=null) {
				tNode2 = tNode;
				tNode = tNode.nextNode;
			}
			if(tNode==null) 
			{
				System.out.println("not Found in the list ");
			}
			else {
				if(tNode == rootNode) {
					rootNode = rootNode.nextNode;
				}
				else if (tNode.nextNode == null) {
					tNode2.nextNode = null;
				}
				else {
					tNode2.nextNode = tNode.nextNode;
					System.out.println("deleted "+tNode.empId);
				}
			}
		}
	}
	
	void printList() {
		if (rootNode == null) {
			System.out.println("Empty ");
		}
		else {
			Node tNode = rootNode;
			while (tNode!=null) {
				System.out.print("|"+tNode.empId + " " +"|"+tNode.genderString + " " +"|"+tNode.nameString + " " + "|"+tNode.salary + "|->" );
				tNode = tNode.nextNode;
			}
		}
	}	
	
	public static void main(String[] args) {
		Assignment3 assignment3 = new Assignment3();
		Scanner scanner = new Scanner(System.in);
		int n;
		do {
			System.out.println("1.insert\n2.search\n3.delete\n4.print\n0.exit");
			n = scanner.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter name");
				String nameString = scanner.next();
				
				System.out.println("Enter gender ");
				String geString = scanner.next();
				
				System.out.println("Enter salary");
				double salary = scanner.nextDouble();
				
				assignment3.insert_right( nameString, geString, salary);
				break;
			case 4:
				System.out.println("Details ");
				assignment3.printList();
				break;
		 
			case 0:
				System.out.println("Exit ");
				break;
			default:
				break;
			}
			
		} while (n!=0);
}
}
