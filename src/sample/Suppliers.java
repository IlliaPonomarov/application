package sample;

public class Suppliers {

    private String id;
    private String name;
    private String surname;
    private String adress;
    private String phone_number;

    public Suppliers(String id, String name, String surname,String adress, String phone_number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone_number = phone_number;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}

class Things extends Suppliers {
  private String product;
  private int quantity;
  private float price;
  private float weight;


    public Things(String id, String name, String surname,String adress, String phone_number, String product, int quantity, float price, float weight) {
        super(id, name, surname,adress, phone_number);
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\nSuppliers:" +
                "\nID:" + super.getId() +
                "\nName:" + super.getName() +
                "\nSurname:" + super.getSurname() +
                "\nAdress:" + super.getAdress() +
                "\nPhone:" + super.getPhone_number() +


                "Things:" +
                "\nProduct:" + product +
                "\nQuantity:" + quantity +
                "\nPrice:" + price +
                "\nWeight:" + weight + "\n";
    }
}
