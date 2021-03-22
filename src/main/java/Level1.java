public class Level1 extends CounterState{
    public Level1(Counter counter) {
        super(counter);
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount()+1);
        checkForUpgrade();
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount()-1);
        checkForUpgrade();

    }


    public void checkForUpgrade() {
        if(counter.getCount()>=10){
            CounterState newlevel = new Level2(counter);
            counter.setCounterState(newlevel);
        }

    }

}
