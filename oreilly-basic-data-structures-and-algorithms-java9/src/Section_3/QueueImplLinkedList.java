package Section_3;

import Section_2.LinkedList;
import java.util.Iterator;

public class QueueImplLinkedList<E> implements Queue<E> 
{
	protected LinkedList<E> list=getNewLinkedList();
	
	protected LinkedList<E> getNewLinkedList()
	{
		return new LinkedList<>();
	}
	
	@Override
	public void enqueue(E value)
	{
		list.appendLast(value);
	}
	
	@Override
	public E dequeue() 
	{
				
		if(list.getLength()==0)
		{
			return null;
		}
						
		E value=list.getFirst().getValue();
						
		list.removeFirst();
		
		return value;			
	}
	
	@Override
	public E peek()
	{
		if(list.getLength()==0)
		{
			return null;
		}		
		return list.getFirst().getValue();
	}
	
	public static void main(String[] args)
	{		
		Queue<Integer> store=new QueueImplLinkedList<>();
		
		store.enqueue(4);
	    store.enqueue(3);
	    store.enqueue(2);
	           	        
	    System.out.println(store.peek());	
	    System.out.println(store.dequeue());	
	}
}
