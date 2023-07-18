import java.util.Date;

public class Order {
    private int Code_customer;
    String paymentType;
    java.sql.Date date;
    int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getCode_customer() {
        return Code_customer;
    }

    public void setCode_customer(int id) {
        this.Code_customer = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + Code_customer +
                ", paymentType='" + paymentType + '\'' +
                "date="+date+'\''+
                "cost="+cost+
                '}';
    }
}
