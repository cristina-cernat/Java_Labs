package Lab_2;

import Lab_12.Cris;

public class Factory extends Source{
    public Factory() {}
    public Factory(String name) {
        super(name);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }


    @Cris
    public static void printHello(){
        System.out.println("Hello there...");
    }

    public static int Add(int a, int b) {
        return a+b;
    }
}
