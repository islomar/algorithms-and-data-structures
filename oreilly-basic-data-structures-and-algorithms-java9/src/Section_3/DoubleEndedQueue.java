package Section_3;

public interface DoubleEndedQueue<E> extends Stack<E> 
{
	void inject(E value);
	E eject();
	E peekLast();
}
