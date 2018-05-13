package Section_5;

import java.util.*;

public class ArraySearcher 
{
	static String[] students = new String[]{"Tom","Harry","Merry","Aisha", "Abdullah"};
	static int[] marks = new int[]{63,70, 65, 85, 72};
		
	private static <E extends Comparable<E>, F extends E> int binarySearch
    (E[] sortedValues, F valueToSearch, int start, int end) 
    {
        if(start>=end)
        {
            return -1;
        }
        
        int midIndex = (end+start)/2;
        int comparison = sortedValues[midIndex].compareTo(valueToSearch);
        
        if(comparison==0)
        {
            return midIndex;
        }
        else if(comparison>0)
        {
            return binarySearch(sortedValues, valueToSearch, start, midIndex);
        }
        else
        {
            return binarySearch(sortedValues, valueToSearch, midIndex+1, end);
        }
    }
	
	private static <E extends Comparable<E>, F extends E> int binarySearchNonRecursive(
		    E[] sortedValues, F valueToSearch, int start, int end) 
		    {
		        while(true) 
		        {
		            if (start >= end) 
		            {
		                return -1;
		            }
		            int midIndex = (end + start) / 2;
		            int comparison =sortedValues[midIndex].compareTo(valueToSearch);
		            
		            if (comparison == 0) 
		            {
		                return midIndex;
		            } 
		            else if (comparison > 0) 
		            {
		                end = midIndex;
		            } 
		            else 
		            {
		                start = midIndex + 1;
		            }
		        }
		    }
	
	
			
	public static <E extends Comparable<E>, F extends E> int binarySearch(
	E[] sortedValues, F valueToSearch) 
	{
		return binarySearch(sortedValues, valueToSearch, 0, sortedValues.length);
	}
	
    public static Integer marksForName(String name) 
    {
        int index = linearSearch(students, name);
        if (index >= 0) 
        {
            return marks[index];
        }
        else 
        {
            return null;
        }
    }
		
    public static <E, F extends E> int linearSearch(E[] values,F valueToLookup) 
    {
        for (int i = 0; i < values.length; i++) 
        {
            if (values[i].equals(valueToLookup)) 
            {
                return i;
            }
        }
        return -1;
    }   
    
    public static void main(String[] args)
    {
    	Integer[] integers =new Integer[]{232, 54, 1, 213, 654, 23, 6, 72, 21};

    	System.out.println(linearSearch(integers, 5));
    	System.out.println(linearSearch(integers, 23));       
    			        
    	System.out.println(marksForName("Merry"));

    	int arraySize = 10000000;
        Long array[] = new Long[arraySize];
        
        array[0] = (long)(Math.random()*100);
        
        for(int i=1;i<array.length;i++)
        {
        	array[i] = array[i-1] + (long)(Math.random()*100);
        }
        
        long start = System.currentTimeMillis();
        linearSearch(array, 31232L);
        long linEnd = System.currentTimeMillis();
        
        binarySearch(array, 31232L);
        long binEnd = System.currentTimeMillis();
        
        System.out.println("linear search time :=" + (linEnd -start));
        System.out.println("binary search time :=" +(binEnd -linEnd));
   
    }
}
