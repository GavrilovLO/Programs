public class Customer {

    private int id;
    private String fullName;
    private String phone;
    private String address;
    private String name;

    public Customer() {
    }

    public Customer(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getid() {
        return id;
    }

    public void setCode_customer(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}