public abstract class CounterState {
    protected final Counter counter;
    public CounterState( Counter counter){
        this.counter=counter;
    }
    public abstract void increment();
    public abstract void decrement();
}
