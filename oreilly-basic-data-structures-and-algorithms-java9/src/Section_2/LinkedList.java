package Section_2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements Iterable<E>
{
	int length=0;	
	Node<E>[] lastModifiedNode;
	Node<E> first;
	Node<E> last;
	
	public static class Node<E>  
	{
		protected E value;
		protected Node next;
		
		
		public E getValue() {
			return value;
		}
		public Node getNext() {
			return next;
		}
		
		public String toString()
		{
			return value.toString();
		}
	      
	}
	
	protected Node<E> getNewNode()  // Creation of new node
	{
		Node<E> node=new Node<>();
		lastModifiedNode=new Node[]{node};
		
		return node;
	}
	
	public Node<E> appendLast(E value)  //Insertion at the end
	{
		Node node=getNewNode();
		node.value=value;
		
		if(last!=null)
		{
			last.next=node;
			last=node;
		}
		if(first==null)
		{
			first=node;
		}
		length++;
		
		return node;
	}
	
	public Node<E> appendFirst(E value) 
	{
		Node node = getNewNode();
		node.value = value;
		node.next = first;
		first = node;

		if (length == 0)
		last = node;
		
		length++;
		return node;
	}
	
	public Node<E> insert(int index, E value)//Insertion of node at the desired position
	{
		Node<E> node = getNewNode();
		
		if (index < 0 || index > length) 
		{
			throw new IllegalArgumentException("Invalid index for insertion");
		} 
		else if (index == length) 
		{
			return appendLast(value);
		} 
		else if (index == 0) 
		{
			return appendFirst(value);
		}
		else // Append at desired position
		{
			Node<E> result=first; 
			
			while(index>1)
			{
				index--;
				result=result.next; //Result is the node at which we have to add our node i.e at results position
			}
			
			node.value=value;  
			node.next=result.next;
			result.next=node;   //Result will be behind our node which we add right now
			
			length++;
			return node;	
		}
	}
	
	public E findAtIndex(int index)  //Find the node's value at the given index
	{
		Node<E> result=(Node<E>) first;
				
		while(index>=0)
		{
			if(result==null)
			{
				throw new NoSuchElementException();
			}
			else if(index==0)
			{
				return result.value;
			}
			else
			{
				index--;
				result=result.next;
			}
		}
		return result.value;						
	}
	
	public Node<E> removeFirst() 
	{
		if(length==0)
		{
			throw new NoSuchElementException();
		}
		
		Node<E> origFirst=first;
		
		first=first.next;  
		length--;		   
		
		if(length==0)
		{
			last=null;   
		}		
		return origFirst;  //It will return the first element
	}

	protected Node<E> removeAtIndex(int index)  
	{
			if(index>=length||index<0)
			{
				throw new NoSuchElementException();
			}
			if(index==0)
			{
				Node<E> nodeRemoved=first;
				removeFirst();
				return nodeRemoved;
			}
			
			Node justBeforeit=first;
			
			while(--index > 0)
			{
				justBeforeit=justBeforeit.next;
			}
			
			Node<E> nodeRemoved=justBeforeit.next;
			
			if(justBeforeit.next==last)
			{
				last=justBeforeit;
			}
			
			justBeforeit.next=justBeforeit.next.next; 
			
			length--;
			return nodeRemoved;			
		}

	public int getLength()
	{
        return length;
	}
  
	public Node<E> getFirst() 
	{
        if (length == 0) 
        {
            throw new NoSuchElementException();
        }
        	        
    	return first;	        	        
	}
  
	public Node<E> getLast() 
	{
        if (length == 0)
        {
            throw new NoSuchElementException();
        }
        	        	        
        return last;
	}
	
	protected class ListIterator implements Iterator<E>
	{
		protected Node<E> nextNode = first;
		protected Node<E> currentNode = null;
		protected Node<E> prevNode = null;
		
		@Override
		public boolean hasNext() 
		{
			return nextNode != null;
		}
			
		@Override
		public E next() 
		{
			if (!hasNext()) 
			{
				throw new IllegalStateException();
			}
				
			prevNode = currentNode;
			currentNode = nextNode;
			nextNode = nextNode.next;
			return currentNode.value;
		}
	}
	
	@Override
	public Iterator<E> iterator() 
	{		
		return new ListIterator();		
	}
	
	public Node<E> removeLast() 
    {
        return removeAtIndex(length - 1);
    }
	
	public static void main(String[] args)
	{
		 LinkedList<Integer> anotherList = new LinkedList<>();
			  
		 anotherList.appendFirst(4);
		 anotherList.appendFirst(1);
		 anotherList.appendFirst(2);
		 anotherList.appendFirst(3);
		 anotherList.appendLast(8);
		 anotherList.appendLast(7);
		 anotherList.appendLast(1);
		 anotherList.appendLast(2);
		 anotherList.appendLast(3);
		 anotherList.appendLast(18);
		 anotherList.insert(2, 99);
		      
		 for(Integer x:anotherList)
		 {
		    System.out.println(x);
		 }
		      
		 System.out.println("First Element:"+anotherList.getFirst());
		 System.out.println("Last Element:"+anotherList.getLast());
		      
		      
		      
		 System.out.println("After removing the first element and the element at index 4");
		 anotherList.removeFirst();
		 anotherList.removeAtIndex(4);
		      
		 for(Integer x:anotherList)
		 {
		    System.out.println(x);
		 }
		      	      
		 System.out.println("Element at index 2:"+anotherList.findAtIndex(2));
	}
	
}


