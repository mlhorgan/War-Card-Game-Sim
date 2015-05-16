package War;

import java.util.Random;

public class MyStack<T> {

	// number of elements in array and next available position in the array
	private int top;
	private int initialStackSize;
	//private array of T
	private T[] stack;


	MyStack (){
		initialStackSize=1;
		top=0;
		stack = (T[])(new Object[initialStackSize]);
	}


	public int size() {
		return top;
	}


	public boolean isEmpty(){
		return (top <= 0);
	}


	public String toString(){
		String temp= "";
		for (int i = 0; i < size(); i++ ){
			temp +=  stack[i] + " ";
		}

		return temp;
	}



	private void expandStack(){
		T[] larger = (T[])(new Object[stack.length*2]);

		for (int index=0; index < stack.length; index++)
			larger[index] = stack[index] ;
		stack = larger;
	}


	void push(T c){
		if(size() == stack.length)
			expandStack();
		stack[top] = c;
		top++;
	}

	public T pop () {
		if (isEmpty())
			return null;

		top--;
		T result = stack[top];
		stack[top] = null;
		return result;
	}


	public T peek (){
		if (isEmpty())
			return null;

		return stack[top-1];
	}

	/* ******************************************************** */


	void shuffle(long seed){
		Random 	rnd = new Random(seed);
		for (int i = top-1; i > 0 ; i-- ){
			int r= rnd.nextInt(i);
			T num = stack[i];
			stack[i]=stack[r];
			stack[r] = num;
		}
	}


	public void addStackToBottom(MyStack<T> s){
		MyStack<T> temp = new MyStack<T>();
		for (int i = size(); i > 0; i--){
			temp.push(pop());
		}
		for (int i = s.size(); i > 0; i--){
			temp.push(s.pop());
		}
		for (int i = temp.size(); i > 0; i--){
			push((T) temp.pop());
		}

	}

}
