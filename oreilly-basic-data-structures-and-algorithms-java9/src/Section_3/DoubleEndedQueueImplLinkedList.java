package Section_3;

import Section_2.LinkedList;
import Section_2.*;

public class DoubleEndedQueueImplLinkedList<E> extends StackImplLinkedList<E> implements DoubleEndedQueue<E>
{
	@Override
	protected LinkedList<E> getNewLinkedList()
	{
		return new DoublyLinkedList<E>();
	}
	
	@Override
	public void inject(E value) 
	{
		list.appendLast(value);
	}
	
	@Override
	public E  eject() 
	{
		if(list.getLength()==0)
		{
			return null;
		}
		E value = list.getLast().getValue();
		list.removeLast();
		return value;
	}
	
	@Override
	public E peekLast() 
	{
		if(list.getLength()==0)
		{
			return null;
		}
		return list.getLast().getValue();
	}
	
	public static void main(String[] args)
	{
		  DoubleEndedQueue<Integer> store = new DoubleEndedQueueImplLinkedList<>();
		  
	        store.push(4);
	        store.push(3);
	        store.push(2);
	        store.inject(5);
	        System.out.println(store.pop());
	   
	        System.out.println(store.pop());
	        
	        System.out.println(store.eject());
	        System.out.println(store.eject());	      	        	
	}
	
}
