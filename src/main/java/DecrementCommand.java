public class DecrementCommand implements ICommand{
    JFrameCounter fcount= new JFrameCounter();
    Counter counter= new Counter();

    public DecrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.decrement();
    }

    @Override
    public void unexecute() {
        counter.increment();

    }
}
