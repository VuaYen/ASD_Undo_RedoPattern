public class Level2 extends CounterState{
    public Level2(Counter counter) {
        super(counter);
    }

    @Override
    public void increment() {
        counter.setCount(counter.getCount()+2);
        checkForUpgrade();
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount()-2);
        checkForUpgrade();

    }


    public void checkForUpgrade() {
        if(counter.getCount()>=100){
            CounterState newlevel = new Level3(counter);
            counter.setCounterState(newlevel);
        }
        if(counter.getCount()<10)
        {
            CounterState newlevel = new Level1(counter);
            counter.setCounterState(newlevel);
        }

    }

}
