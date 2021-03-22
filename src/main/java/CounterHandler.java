import Cor.Package;

public class CounterHandler {
    private Handler chainOfHandlers;
    public void setChainOfHandlers(Handler chainOfHandlers) {
        this.chainOfHandlers = chainOfHandlers;
    }
    public void handlePackage(Counter counter) {
        chainOfHandlers.handle(counter);
    }
}
