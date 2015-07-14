public class Node<T>{
	public T item;
	public Node<T> next;
	
	public Node(){
		item=null;
		next=null;
	}
	public Node(T n){
		item=n;
		next=null;
	}
	public Node(T n,Node<T> nextNode){
		item=n;
		next=nextNode;
	}
	public T getItem(){
		return item;
	}
	public void setItem(T newItem){
		item=newItem;
	}
	public Node<T> getNext(){
		return next;
	}
	public void setNext(Node<T> nextNode){
		next=nextNode;
	}
}
