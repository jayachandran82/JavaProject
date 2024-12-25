package interview;

//Java program to illustrate synchronous callback

class CallBackFunctionExample {
	private EventListener mListener; // listener field
	// setting the listener

	public void registerEventListener(EventListener mListene) {
		this.mListener = mListener;
	}

	// my synchronous task
	public void doStuff() {
		// perform any operation
		System.out.println("Performing callback before synchronous Task");
		// check if listener is registered.
		if (this.mListener != null) {
			// invoke the callback method of class A
			mListener.onEvent();
		}
	}

	// Driver Function
	public static void main(String[] args) {
		CallBackFunctionExample obj = new CallBackFunctionExample();
		EventListener mListener = new A();
		obj.registerEventListener(mListener);
		obj.doStuff();
	}
}

interface EventListener {
	// this can be any type of method
	void onEvent();
}

class A implements EventListener {
	@Override
	public void onEvent() {
		System.out.println("Performing callback after synchronous Task");
		// perform some routine operation
	}
	// some class A methods
}