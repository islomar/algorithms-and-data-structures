package Section_1;

public class ComputeRemainder 
{
	public static long computeRemainder(long base, long power, long divisor)
	{
			long baseRaisedToPower = 1;

			for(long i=1;i<=power;i++)
			{
				baseRaisedToPower *= base;  
			}

			return baseRaisedToPower % divisor;
	}
	
	public static long computeRemainderCorrected(long base, long power, long divisor)
	{
			long baseRaisedToPower = 1;

			for(long i=1;i<=power;i++)
			{
				baseRaisedToPower *= base;
				baseRaisedToPower %= divisor;
			}

			return baseRaisedToPower;
	}
	
	public static long computeRemainderUsingEBS(long base, long power,long divisor)
	{
	    long baseRaisedToPower = 1;
	    long powerBitsReversed = 0;
	    int numBits=0;

	    while(power>0)
	    {
	      powerBitsReversed <<= 1;
	      powerBitsReversed += power & 1;
	      power >>>= 1;
	      numBits++;
	    }

	    while (numBits-->0)
	    {
	        if(powerBitsReversed%2==1)
	        {
	          baseRaisedToPower *= baseRaisedToPower * base;
	        }
	        else
	        {
	          baseRaisedToPower *= baseRaisedToPower;
	        }

	        baseRaisedToPower %= divisor;
	        powerBitsReversed>>>=1;
	    }

	    return baseRaisedToPower;
	  }
	
	public static void main(String[] args)
	{
		long startTime = System.currentTimeMillis();
		
		long ans=0;

		for(int i=0;i<1_000_000_000;i++)
		{
			ans=computeRemainder(2, 1000, 7);
		}

		long endTime = System.currentTimeMillis();
		System.out.println(ans);
		System.out.println(endTime - startTime);
		
		long startTime2 = System.currentTimeMillis();

	    for(int i=0;i<1000;i++)
	    {
	        computeRemainderCorrected(13, 10_000_000, 7);
	    }
	      
	     long endTime2 = System.currentTimeMillis();
	     System.out.println(endTime2 - startTime2);
	      
	     long startTime3;
	     long endTime3;

	     startTime3 = System.currentTimeMillis();

	     for(int i=0;i<1000;i++)
	     {
	       computeRemainderUsingEBS(13, 10_000_000, 7);
	     }

	     endTime3 = System.currentTimeMillis();
	     System.out.println(endTime3 - startTime3);
	}
}
