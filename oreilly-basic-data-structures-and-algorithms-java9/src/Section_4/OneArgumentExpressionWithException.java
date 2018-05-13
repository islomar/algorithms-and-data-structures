package Section_4;

@FunctionalInterface
public interface OneArgumentExpressionWithException<A,R> 
{
	R compute(A a) throws Exception;
}
