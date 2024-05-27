//Author full name: Yash Jain
//==================================================


/**
 * Your documentation for this interface ....
 *
 *
 */

//COMMENTS
//The Interface Class for Stack which has 5 abstract methods
//Abstract Method push (Object item) allows disks to be pushed into the stack @return type void
//Abstract Method pop () retrieves and removes the top item @return type Object
//Abstract Method peek () allows to see the top item in the stack but does not remove it @return type Object
//Abstract Method isEmpty () checks if the stack is empty @return type Boolean
//Abstract Method size () checks the size of the stack @return type int

public interface Stack {
	//your code here
	public abstract void push(Object item);
	public abstract Object pop();
	public abstract Object peek();
	public abstract boolean isEmpty();
	public abstract int size();
}