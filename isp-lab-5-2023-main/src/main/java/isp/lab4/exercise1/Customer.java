package isp.lab4.exercise1;

public class Customer {
    private String customerId;
    private String name;
    private String phone;
    private Address address;

    public Customer(String customerId, String name, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.phone = phone;
    }

    public String getAddress(){
        return "Address is: "+this.address.getCity()+this.address.getStreet();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString(){
        return getClass().getName()+"{customerId="+this.customerId+",name="+this.name+",phone"+this.phone+"}";
    }
}
