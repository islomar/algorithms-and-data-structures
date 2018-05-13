package Section_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<E> extends LinkedList<E> 
{
	protected static class DoublyLinkedNode<E> extends Node<E>
	{
		protected DoublyLinkedNode<E> prev;
	}
	
	@Override
	protected Node<E> getNewNode()
	{
		return new DoublyLinkedNode<E>();
	}
	
	 @Override
	 public Node<E> appendFirst(E value) 
	 {
	        Node<E> node = super.appendFirst(value);
	        if (first.next != null)
	        ((DoublyLinkedNode<E>) first.next).prev = (DoublyLinkedNode<E>) first;
	        
	        return node;
	  }
	 
	 public Node<E> appendLast(E value)
	 {
		 DoublyLinkedNode<E> origLast = (DoublyLinkedNode<E>)this.last;
		 Node<E> node = super.appendLast(value);
		 
		 if (origLast == null) 
		 {
			 origLast = (DoublyLinkedNode<E>) first;
		 }
		 
		 ((DoublyLinkedNode<E>) this.last).prev = origLast;
		 return node;
	 }
	 
	 @Override	    
	 public Node<E> insert(int index, E value) 
	 {		         
	 	DoublyLinkedNode<E> inserted = (DoublyLinkedNode<E>) super.insert(index, value);	         
	 
	 	if(index!=0 && index!=length) 
	 	{	             
	 		if (inserted.next != null) 
	 		{	                 
	 			inserted.prev = ((DoublyLinkedNode<E>) inserted.next).prev;
	            ((DoublyLinkedNode<E>) inserted.next).prev = inserted;	             
	 		}	         
	 	}	        
	         return inserted;	     
	 }
	 
	 @Override
	 public Node<E> removeFirst() 
	 {
	   
	   super.removeFirst();
	   if (first != null) 
	   {
	   	 ((DoublyLinkedNode<E>) first).prev = null;
	   }
	   return first;
	 }
	 
	 @Override
	 public Node<E> removeLast() 
	 {
	   
	   Node<E> origLast = last;
	   if(last==null)
	   {
	       throw new IllegalStateException("Removing element from an empty list");
	   }
	   last = ((DoublyLinkedNode<E>)last).prev;
	   if(last!=null)
	   {
	       last.next = null;
	   }
	   else
	   {
	       first = null;
	   }
	   length--;
	   return origLast;
	 }
	 
	 @Override
	 public Node<E> removeAtIndex(int index) 
	 {
	     if(index<0||index>=length)
	     {
	         throw new NoSuchElementException("index = "+index);
	     }
	     if(index==length-1)
	     {
	         return removeLast();
	     }
	     DoublyLinkedNode<E> nodeRemoved = (DoublyLinkedNode<E>) super.removeAtIndex(index);

	     if ((DoublyLinkedNode<E>) nodeRemoved.next != null)
	         ((DoublyLinkedNode<E>) nodeRemoved.next).prev = nodeRemoved.prev;

	     return nodeRemoved;
	 }	
	 
	 protected class ReverseListIterator extends ListIterator
	 {
		 public ReverseListIterator()
		 {
			 nextNode=last;
		 }
		 
		 @Override
		 public E next() 
		 {
		 	if(nextNode == null)
		 	     throw new IllegalStateException();
		 	           
		 	DoublyLinkedNode<E> nodeToReturn = (DoublyLinkedNode<E>) nextNode;
		 	nextNode = nodeToReturn.prev;
		 	return nodeToReturn.value;
		 }
	 }
	 
	 public Iterator<E> reverseIterator()
	 {
	 	return new ReverseListIterator();
	 }
	 
	 public static void main(String [] args)
	 {
	 	DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
	 	doublyLinkedList.appendFirst(4);
	 	doublyLinkedList.appendFirst(1);
	 	doublyLinkedList.appendFirst(2);
	 	doublyLinkedList.appendFirst(3);
	 	doublyLinkedList.appendLast(8);
	 	doublyLinkedList.appendLast(7);
	 	doublyLinkedList.appendLast(18);
	 	doublyLinkedList.appendFirst(3);
	 	doublyLinkedList.appendLast(8);
	 	doublyLinkedList.appendLast(7);
	 	doublyLinkedList.appendLast(18);
	 	doublyLinkedList.insert(2, 51);
	 	doublyLinkedList.insert(0, 510);
	 		 	
	 	while (doublyLinkedList.getLength()>0)
	    {
	      doublyLinkedList.removeLast();
	    }
	 	
	 	Iterator<Integer> reverseIterator = doublyLinkedList.reverseIterator();
	 	while(reverseIterator.hasNext())
	 	{
	 	     System.out.println(reverseIterator.next());
	 	}
	 }
	   
}
