public class Level3 extends CounterState{
    public Level3(Counter counter) {
        super(counter);
    }
    @Override
    public void increment() {
        counter.setCount(counter.getCount()+3);
    }

    @Override
    public void decrement() {
        counter.setCount(counter.getCount()-3);
        checkForUpgrade();

    }

    public void checkForUpgrade() {
        if(counter.getCount()<100){
            CounterState newlevel = new Level2(counter);
            counter.setCounterState(newlevel);
        }


    }



}
