public class Counter extends Subject{
	
	private int count=0;
	private CounterState counterState;

	public Counter(int count) {
		this.count = count;
	}

	public Counter() {
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CounterState getCounterState() {
		return counterState;
	}

	public void setCounterState(CounterState counterState) {
		this.counterState = counterState;
	}

	public void increment(){
//		count++;
		counterState.increment();
    	donotify(count);
	}
	
	public void decrement(){
//		count--;
    	counterState.decrement();
		donotify(count);
	}

}
