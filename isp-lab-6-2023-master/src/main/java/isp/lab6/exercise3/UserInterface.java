package isp.lab6.exercise3;

import isp.lab6.exercise2.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class UserInterface {
    private LoginSystem loginSyst;
    private OnlineStore store;

    public UserInterface(LoginSystem loginSyst, OnlineStore store) {
        this.loginSyst = loginSyst;
        this.store = store;
    }

    public void loadInterface() throws IOException {
        char answer;
        String line;

        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu");
            System.out.println("1-Add product to cart");
            System.out.println("2-See my cart");
            System.out.println("3-List of products in store");
            System.out.println("4-List of products in store sorted by name or price");
            System.out.println("5-Checkout");
            System.out.println("6-Logout");
            System.out.println("e-exit");

            line=fluxIn.readLine();
            answer=line.charAt(0);
            //star Session
            switch (answer) {
                case '1':
                    String nameProduct;
                    System.out.println("Introduceti numele produsului: ");
                    nameProduct=fluxIn.readLine();
                    int quantityProduct;
                    System.out.println("Introduceti cantitatea: ");
                    quantityProduct= Integer.parseInt(fluxIn.readLine());
                    if(store.getPriceProduct(nameProduct)!=0f)
                        store.addToCart(loginSyst.getCurrentUser().getUsername(),new Product(nameProduct, store.getPriceProduct(nameProduct)),quantityProduct);
                    else System.out.println("Name of the product is wrong!");
                    break;
                case '2':
                    store.seeMyCart();
                    break;
                case '3':
                    store.getProducts();
                    break;
                case '4':
                    System.out.println("You have 2 option of sorting: type \"price\" or \"name\": ");
                    String sorting_type=fluxIn.readLine();
                    if(sorting_type.equals("name"))store.getProductsSorted(new ProductNameComparator());
                    else store.getProductsSorted(new ProductPriceComparator());
                    break;
                case '5':
                    store.getSessions();
                    System.out.println("TOTOL to pay:--------------"+store.getSumAllProducts());
                    store.addSeession(loginSyst.getCurrentUser().getUsername());
                    store.closeSession();
                    break;
                case '6':

                    break;
                default:
                    System.out.println("Incorrect input!");
            }


        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");

    }

}
