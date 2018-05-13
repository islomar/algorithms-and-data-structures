package Section_4;

@FunctionalInterface
public interface FunctionalInterfaceWithDefaultMethod 
{
	int modify(int x);
	default int modifyTwice(int x){return modify(modify(x));}
}
