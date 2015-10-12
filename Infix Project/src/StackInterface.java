
public interface StackInterface<T>
{
	void pop() throws StackUnderFlowException;
	
	T top() throws StackUnderFlowException;
	
	boolean isEmpty();
}
