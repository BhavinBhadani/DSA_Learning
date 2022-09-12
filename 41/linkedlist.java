/*
Q. Linked-List

Problem Description
Design and implement a Linked List data structure.
A node in a linked list should have the following attributes - an integer value and a pointer to the next node. It should support the following operations:

insert_node(position, value) - To insert the input value at the given position in the linked list.
delete_node(position) - Delete the value at the given position from the linked list.
print_ll() - Print the entire linked list, such that each element is followed by a single space.

Note:
    If an input position does not satisfy the constraint, no action is required.
    Each print query has to be executed in a new line.


Problem Constraints
1 <= value <= 10^5
1 <= position <= n where, n is the size of the linked-list.



Input Format
First line contains an integer denoting number of cases, let's say t.
Next t line denotes the cases.


Output Format
When there is a case of print_ll(),  Print the entire linked list, such that each element is followed by a single space.
NOTE: You don't need to return anything.


Example Input
5
i 1 23
i 2 24
p
d 1
p



Example Output
23 24
24



Example Explanation

After first two cases linked list contains two elements 23 and 24.
At third case print: 23 24.
At fourth case delete value at first position, only one element left 24.
At fifth case print: 24.

*/


  static Node head = null;      //  reference pointer of the Node
	static int length = 0;     //  variable to keep a track of length of List
    
    //  Node Class
    public static class Node{
        int val;        //  Value of node
        Node next;      //  reference pointer of the next Node
        
        //  Constructor
        Node(int val){
            this.val = val;
            this.next = null;
        }
        
    }
    
    
    //  Get the value at the given index
    public static int get(int index) {
        if(index >= length || index < 0)
        	return -1;
        
        int counter = 0;
        Node temp = head;
        
        while(counter < index) {
        	counter++;
        	temp = temp.next;
        }
        return temp.val;
    }
    
    //  Add element at the head(START) of linkedList
    public static void addAtHead(int val) {
        Node newVal = new Node(val);
        newVal.next = head;
        head = newVal;
        length++;
    }
    
    //  Add element at the tail(END) of linkedList
    public static void addAtTail(int val) {
        if(head == null) {
        	addAtHead(val);
        }else {
        	Node temp = head;
        	while(temp.next != null)
        		temp = temp.next;
        	Node newnew = new Node(val);
        	temp.next = newnew;
        	length++;
        }
    }
    
    //  Add element at the given index of linkedList
    public static void insert_node(int index, int val) {
    	if(index > length)
    		return;
        if(index == 0)
        	addAtHead(val);
        else {
        	int counter = 1;
        	Node temp = head;
        	while(counter < index) {
        		temp = temp.next;
        		counter++;
        	}
        	Node newnew = new Node(val);
        	Node next = temp.next;
        	temp.next = newnew;
        	newnew.next = next;
        	length++;
        }
    }
    
    //  delete element at the given index of linkedList
    public static void delete_node(int index) {
        if(index >= length)
        	return;
        if(index == 0) {
        	head = head.next;
        	length--;
        }else {
        	int counter = 1;
        	Node temp = head;
        	while(counter < index) {
        		counter++;
        		temp = temp.next;
        	}
        	temp.next = temp.next.next;
        	length--;
        }
    }

    public static void print_ll() {
        // Output each element followed by a space
        for(int i=0; i<length; i++) {
            System.out.print(get(i) + " ");
        }
    }
