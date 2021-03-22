package Cor;

public class InternationalNormalCareHandler extends Handler{
    public InternationalNormalCareHandler(Handler nextHandler) { super(nextHandler);
    }
    @Override
    public void handle(Package thePackage) {
        if (thePackage.isInternational() ) {
            System.out.println("Handle international normal care package");
        } else {
            nextHandler.handle(thePackage);
        }
    }
}
