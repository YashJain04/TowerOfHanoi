//Author full name: Yash Jain
//==================================================


/**
 * Your documentation for this class ....
 *
 *
 */

//The class for the LinkedStack which implements the interface Stack and has all of its methods

public class LinkedStack implements Stack {

	//Nested class for LinkedStack

	private static class Elem {

		//Private instance variables which checks the value and the next for linkedStacks to work
		//value is of type Object
		//next is of type Elem

        private Object value;
        private Elem next;

		//Constructor with 2 parameters Object value, and Elem next
		//Initialize the parameters to the instance variables

        private Elem(Object value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

	//Instance variables for the top of the linked stack and the size of the linked stack
	//top is of type elem
	//size is of type int

	private Elem top;
	private int size;

	//Constructor with 0 parameters
	//set the instance variable top to null
	//set the instance variable size to 0

	public LinkedStack() {
		this.top = null;
		this.size = 0;
	}

	//isEmpty method for the LinkedStacks
	//Takes no parameters
	//@return type boolean "true" if the LinkedStack is empty else returns "false"
	public boolean isEmpty() {
		return top == null;
	}

	//push method for the LinkedStacks
	//Parameter is an item of type Object (this item is the item that will be pushed into the LinkedStack)
	//@return type void = nothing is being returned from this method
	//Increase the size of the stack since a new item was being pushed into it

	public void push( Object item) {
		if (top == null) { top = new Elem(item, null); }

		else {
            Elem temp=new Elem(item,top);
			top=temp;
		}

		size++;
	}

	//peek method for the LinkedStacks
	//Takes no parameters
	//@return type Object
	//If the stack is empty it will return 0 (this 0 is used later to manage the stacks in HanoiTowerGame = line 136)
	//If the stack is not empty it will just return the top value

	public Object peek() {
		
		if (isEmpty()) return 0;

		return top.value;
	}

	//pop method for LinkedStacks
	//Takes no parameters
	//@return type Object
	//If the stack is empty return null
	//Else remove the element from the stack
	//Decrement the size of the stack since an item was removed from it
	//Return the popped value (top value)

	public Object pop() {
		Elem temp;

		if (isEmpty()) { return null; }

		temp = top;
		top = top.next;
		temp.next = null;
		size--;
		return temp.value;
	}

	//size method for LinkedStacks
	//Takes no parameters
	//@return type int
	//Returns the size of the stack

	public int size() {
		return this.size;
	}
	
	//toString method for the stacks
	//Helps prints the stack and the game with the disks (dashse)
	//Takes no parameters
	//@return type : String

	public String toString() {
		String dashes = "";

		LinkedStack temp = new LinkedStack();

		while (!isEmpty()) {
			Object popped = pop();
			temp.push(popped);
			dashes += "-".repeat((int)popped) + Utils.NEW_LINE;
		}

		while (!temp.isEmpty()) {
			Object popped = temp.pop();
			push(popped);
		}

		return dashes;
	}
}