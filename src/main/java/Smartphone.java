public class Smartphone extends Product{
    public String getProducer() {
        return producer;
    }

    private String producer;

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        } else {
            return getProducer().contains(search);
        }
    }
}
