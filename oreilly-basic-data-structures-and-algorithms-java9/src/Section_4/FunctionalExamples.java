package Section_4;

import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class FunctionalExamples 
{
	public int sum_upto(int n) 
	{
	        int sum = 0;
	        for (int i = 0; i <= n; i++)
	         {
	            sum += i;
	        }
	        return sum;
	  }
	
	public int sum_upto_functional(int n) 
	{
	        return n == 0 ? 0 : n + sum_upto_functional(n - 1);
	}		
		
	public long choose(long n, long r) 
	{
	        if (n < r){
	            return 0;
	        } 
	        else if (r == 0){
	            return 1;
	        } 
	        else if (n == r){
	            return 1;
	        }
	        else
	        {
	            return choose(n - 1, r) + choose(n - 1, r - 1);
	        }
	}	
	
	public static String repeatString(final String seed, int count)
	{
		return LinkedList.ofRange(1,count+1).map((a)->seed).foldLeft("",(a,b)->a+b);
	}
	
	public static String repeatString2(final String seed, int count)
	{
		return LinkedList.ofRange(1,count+1).foldLeft("",(a,b)->a+seed);
	}
	
	public static BigInteger factorial(int x)
	{
		return LinkedList.ofRange(1,x+1).map((a)->BigInteger.valueOf(a)).foldLeft(BigInteger.valueOf(1),(a,b)->a.multiply(b));
	}
				
	public static void main(String[] args)
	{
		
		FunctionalExamples f = new FunctionalExamples();
		
		
        System.out.println(f.sum_upto(10));
        System.out.println(f.sum_upto_functional(10));
        System.out.println(f.choose(10, 6));
        
        
        SampleFunctionalInterface sfi = (x) -> x + 1;
        int y = sfi.modify(1);
        
        System.out.println(y);
        
        Thread t = new Thread(() -> {
            for (int i = 0; i < 500; i++) System.out.println(i);
        });
        
        t.start();
        
        LinkedList<Integer> linkedList =LinkedList.<Integer>emptyList().add(5).add(3).add(0);
        
        while(!(linkedList instanceof LinkedList.EmptyList))
        {
           System.out.println(linkedList.head());
           linkedList = linkedList.tail();
        }
        
        linkedList.forEach((x) -> {System.out.println(x);});
        
        linkedList.forEach(System.out::println);
        
        LinkedList<Integer> tranformedList = linkedList.map((x)->x*2);
        tranformedList.forEach(System.out::println);
        
        LinkedList<String> tranformedListString = linkedList.map((x)->"x*2 = "+(x*2));
        tranformedListString.forEach(System.out::println);
        
        int sum = linkedList.foldLeft(0,(a,b)->a+b);
        System.out.println("Sum:"+sum);
        
        int sum2 = linkedList.foldRight((a,b)->a+b, 0);
        System.out.println("Sum:"+sum2);
        
        LinkedList<Integer> reversedList = linkedList.foldLeft(LinkedList.emptyList(),(l,b)->l.add(b) );
        reversedList.forEach(System.out::println);
        
        LinkedList<Integer> sameList = linkedList.foldRight((b,l)->l.add(b), LinkedList.emptyList());
        sameList.forEach(System.out::println);

        LinkedList<Integer> rangeList = LinkedList.ofRange(1,100);
        rangeList.forEach(System.out::println);
        
        LinkedList<Integer> evenList = LinkedList.ofRange(1,100).filter((a)->a%2==0);
       evenList.forEach(System.out::println);

        int sumOfRange = LinkedList.ofRange(1,101).foldLeft(0, (a,b)->a+b);
        System.out.println(sumOfRange);

        System.out.println(factorial(100));
        System.out.println(repeatString2("Hello",5));
        
        LinkedList<Integer> linkedList2 =LinkedList.<Integer>emptyList().add(6).add(8).add(9);
        
        linkedList.append(linkedList2).forEach(System.out::println);
        
        LinkedList.ofRange(1, 10).flatMap((x) -> LinkedList.ofRange(0, x)).forEach(System.out::println);
        
        
		
		Person person = new Person(new Address(new City(new Country("UK", "United Kingdom"),"London"), "X"), "Harry Potter");
		
		/*if(person!=null
                && person.getAddress()!=null
                && person.getAddress().getCity()!=null
                && person.getAddress().getCity().getCountry()!=null){
            System.out.println(person.getAddress().getCity().getCountry().getName());
        }*/
		
		Option.optionOf(person)
        .flatMap(Person::getAddress)
       .flatMap(Address::getCity)
        .flatMap(City::getCountry)
        .flatMap(Country::getName)
        .forEach(System.out::println);
		
		Try.of(() -> new FileInputStream("E:\\Workspace\\Java 9 Data Structures And Algorithms\\src\\Section_4\\Demo"))
        .map((in) -> new InputStreamReader(in))
        .map((in) -> new BufferedReader(in))
        .map((in) -> in.readLine())
        .processException(System.err::println)
        .forEach(System.out::println);
		
	}
	
	
}
