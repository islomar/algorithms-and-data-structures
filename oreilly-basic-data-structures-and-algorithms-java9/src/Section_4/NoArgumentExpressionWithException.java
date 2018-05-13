package Section_4;

@FunctionalInterface
public interface NoArgumentExpressionWithException<R> 
{
	R evaluate() throws Exception;
}
