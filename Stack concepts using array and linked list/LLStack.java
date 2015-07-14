//Created by:Ushanth Loganathan
	   //v00810681
public class LLStack <T> implements Stack<T>{
	private Node <T> head;
	private int count;
	public LLStack(){
		head=null;
		count=0;
	}
	//returns size of stack 
	public int size(){
		return count;
	}
	//make stack empty
	public boolean empty(){
		if(head==null){
			return true;
		}
		else{
			return false;
		}
	}
	//push an element to stack
	public void push (T element){
		Node<T> newNode=new Node<T>(element,head);
		head=newNode;
		count++;	
	}
	//pop an element from stack
	public T pop() throws StackEmptyException{
		if(empty()==true){
			throw new StackEmptyException("the stack is empty");
			
		}
		else{
			Node <T> temp=head;
			head=head.next;
			count--;
			return temp.item;
		}
	}
	//return the value at which the head points to
	public T peek() throws StackEmptyException{
		if(empty()==true){
			throw new StackEmptyException("the stack is empty");
		}
		else{
			return head.item;
		}
	}
	//make the stack empty
	public void makeEmpty(){
		head=null;
		count=0;
	}
}
