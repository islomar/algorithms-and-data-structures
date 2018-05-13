package Section_5;

import java.util.*;
import java.math.*;

public class ArraySorter 
{
    public static <E extends Comparable<E>> int findMin(E[] array,int start) 
    {
        if (start == array.length - 1) 
        {
            return start;
        }
        
        int restMinIndex = findMin(array, start + 1);
        E restMin = array[restMinIndex];
        
        if (restMin.compareTo(array[start]) < 0) 
        {
            return restMinIndex;
        } 
        else 
        {
            return start;
        }
    }
    
    public static <E> void swap(E[] array, int i, int j) 
    {
        if (i == j)
            return;
            
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public static <E extends Comparable<E>> void insertElementSorted(E[] array, int valueIndex) 
    {

        if (valueIndex > 0 && array[valueIndex].compareTo(array[valueIndex - 1]) < 0) 
        {
            swap(array, valueIndex, valueIndex - 1);
            insertElementSorted(array, valueIndex - 1);
        }
        else
        {
        	return;
        }

    }
    
    public static <E extends Comparable<E>> void insertElementSortedNonRecursive
    (E[] array, int valueIndex) 
    {
        while(true) 
        {
            if (valueIndex > 0
                && array[valueIndex].compareTo(array[valueIndex - 1]) < 0) 
            {
                swap(array, valueIndex, valueIndex - 1);
                valueIndex =  valueIndex - 1;
            }
            else
            {
                return;
            }
        }

    } 
    
    public static <E extends Comparable<E>> void insertionSort(E[] array, int boundary) 
    {
        if (boundary == 0) 
        {
            return;
        }

        insertionSort(array, boundary - 1);
        insertElementSorted(array, boundary);
    }
    
    public static BigInteger factorialRecursive(int x)
    {
    	if(x==0)
    	{
    		return BigInteger.ONE;
    	}
    	else
    	{
    		return factorialRecursive(x-1).multiply(BigInteger.valueOf(x));
    	}
    }
    
    public static BigInteger factorialRecursiveNonRecursive(int x)
    {
    	BigInteger prod = BigInteger.ONE;
    	
    	for(int i=1;i<=x;i++)
    	{
    		prod = prod.multiply(BigInteger.valueOf(x));
    	}
    	return prod;
    }
    
    public static <E extends Comparable<E>> void insertionSortNonRecursive(E[] array) 
    {
        for(int boundary = 0;boundary<array.length;boundary++) 
        {
            insertElementSortedNonRecursive(array, boundary);
        }
    }
    
    
    public static <E extends Comparable<E>> void insertionSort(E[] array) 
    {
        insertionSort(array, array.length - 1);
    }
    
    public static <E extends Comparable<E>> void bubbleSort(E[] array) 
    {
        boolean sorted = false;
        while (!sorted) 
        {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) 
            {
                if (array[i].compareTo(array[i + 1]) > 0) 
                {
                    swap(array, i, i + 1);
                    sorted = false;
                }
            }
        }
    }
    
    public static <E extends Comparable<E>> void selectionSort(E[] array, int start) 
    {
        if (start >= array.length) 
        {
            return;
        }
        
        int minElement = findMin(array, start);
        swap(array, start, minElement);
        selectionSort(array, start + 1);
    }
    
    public static <E extends Comparable<E>> void selectionSort(E[] array) 
    {
        selectionSort(array, 0);
    } 
    
    public static void main(String[] args)
    {
    	Integer[] array = new Integer[]{10, 5, 2, 3, 78, 53, 3};
    	
    	selectionSort(array);
        insertionSort(array);
        bubbleSort(array);
        insertionSortNonRecursive(array);
    	insertionSortNonRecursive(array);
    	System.out.println( Arrays.toString(array));  	
    }
       
}
