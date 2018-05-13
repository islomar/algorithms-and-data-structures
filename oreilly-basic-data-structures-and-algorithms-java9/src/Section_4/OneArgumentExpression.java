package Section_4;

@FunctionalInterface
public interface OneArgumentExpression<A,R> 
{
	R compute(A a);
}


