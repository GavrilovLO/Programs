public class Good {
    int code_representative;
    String description;
    String delivery;
    int price;
    String typeOfGood;
    int number;

    public int getCode_representative() {
        return code_representative;
    }

    public void setCode_representative(int code_representative) {
        code_representative = code_representative;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfGood() {
        return typeOfGood;
    }

    public void setTypeOfGood(String typeOfGood) {
        this.typeOfGood = typeOfGood;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Good{" +
                "description=" + description +
                ", delivery='" + delivery + '\'' +
                "price="+price+'\''+
                "typeOfGood="+typeOfGood+'\''+
                "number="+number+
                '}';
    }

}
