package Cor;

public class HeavyWeightSpecialCareHandler extends Handler{
    public HeavyWeightSpecialCareHandler(Handler nextHandler) { super(nextHandler);
    }
    @Override
    public void handle(Package thePackage) {
        if (thePackage.getWeight()>100 && thePackage.isSpecialCare()) {
            System.out.println("Handle HeavyWeight special care package");
        } else {
            nextHandler.handle(thePackage);
        }
    }
}
