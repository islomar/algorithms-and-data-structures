package Section_4;

@FunctionalInterface
public interface TwoArgumentExpression<A,B,R> 
{
	R compute(A lhs,B rhs);
}
