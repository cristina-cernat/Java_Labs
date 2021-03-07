package Lab_2;

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

}
