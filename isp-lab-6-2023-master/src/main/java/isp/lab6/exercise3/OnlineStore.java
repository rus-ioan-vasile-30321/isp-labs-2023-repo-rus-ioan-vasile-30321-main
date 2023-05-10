package isp.lab6.exercise3;

import java.util.*;

public class OnlineStore {
    private List<Product> products;
    private Map<String, ActiveSession> sessions;

    private ActiveSession activeSession;

    public OnlineStore(List<Product> products, Map sessions) {
        this.products = products;
        this.sessions = sessions;
        this.activeSession=new ActiveSession();
    }

    public List<Product> getProducts() {
        for(Object i:products)
            System.out.println(i);
        return products;
    }
    public List<Product> getProductsSorted(Comparator<Product> sortCritiria) {
        List<Product> sorted=products;

        if(new ProductNameComparator()==sortCritiria)
            Collections.sort(sorted,new ProductNameComparator());
        else
            Collections.sort(sorted,new ProductPriceComparator());

        for(Object i:sorted)
            System.out.println(i);
        return sorted;
    }
    //aici nu sunt sigur cum trebuie facut,adica in diagrama trebuie ca methodele sa fie package
    public void addSeession(String username){
        System.out.println("aici se adauga sesiune@@@");
        this.sessions.put(username,activeSession);
        for(int i=0;i<sessions.size();i++)
        System.out.println(sessions.keySet().toArray()[i]+" "+sessions.get(sessions.keySet().toArray()[i]));
        System.out.println("DImensiune dupa adaugare"+sessions.size());
        System.out.println("aici se termina add sesiune@@@");
    }
    public void removeSeession(){

    }
    public void addToCart(String username,Product product,int quantity){
        if(activeSession.getUsername()==null)activeSession.setUsername(username);
        activeSession.addToCart(product,quantity);


    }
    public void seeMyCart(){
        activeSession.getShoppingChart();
        }
    public float getPriceProduct(String name){
        for(int i=0;i<products.size();i++)
            if(products.get(i).getName().equals(name))return products.get(i).getPrice();
        return 0;
    }
    public float getSumAllProducts(){
        return activeSession.productSum();
    }

    public Map<String, ActiveSession> getSessions() {
        System.out.println("TOATE SESIUNILE######");
        for(int i=0;i<sessions.size();i++)
            System.out.println(sessions.toString());
        System.out.println("SIZE"+sessions.size());
        System.out.println("FINAL TOATE SESIUNILE######");
        return sessions;
    }
    public void closeSession(){
        activeSession=new ActiveSession();
    }
}
