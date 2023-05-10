package isp.lab6.exercise3;

import java.util.HashMap;
import java.util.Map;

public class ActiveSession {
    private String username;
    private Map<Product, Integer> shoppingChart=new HashMap<>();
    public void addToCart(Product product,int quantity){
        this.shoppingChart.put(product,quantity);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public float productSum(){
        float sum=0;
        for(int i=0;i<shoppingChart.size();i++) {
            Product product_current= (Product) shoppingChart.keySet().toArray()[i];
            sum+=product_current.getPrice()*shoppingChart.get(shoppingChart.keySet().toArray()[i]);
        }
    return sum;
    }
    public Map<Product, Integer> getShoppingChart() {
        for(int i=0;i<shoppingChart.size();i++) {
            Product product_current= (Product) shoppingChart.keySet().toArray()[i];
            System.out.println(shoppingChart.keySet().toArray()[i] + " quantity: " + shoppingChart.get(shoppingChart.keySet().toArray()[i]) + " Price: "+product_current.getPrice()*shoppingChart.get(shoppingChart.keySet().toArray()[i]));
        }
        System.out.println("Total " +productSum());
        return shoppingChart;
    }
    public void closeSession(){
        shoppingChart=new HashMap<>();
    }

    @Override
    public String toString() {
        return "ActiveSession{" +
                "username='" + username + '\'' +
                ", shoppingChart=" + shoppingChart +
                '}';
    }
}
