public class IncrementCommand implements ICommand{
    JFrameCounter fcount= new JFrameCounter();
    Counter counter= new Counter();

    public IncrementCommand(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void execute() {
        counter.increment();

    }

    @Override
    public void unexecute() {
        counter.decrement();
    }
}
