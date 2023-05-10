package isp.lab4.exercise4;

public enum TicketType {
    VIP("Vip Ticket",43.99f),
    NORMAL("Normal Ticket",25.2f),
    EARLY("Early Bird Ticket",20.44);
    private String dispaly_name;
    private double price;
    TicketType(String dispaly_name,double price){
        this.dispaly_name=dispaly_name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }
}
