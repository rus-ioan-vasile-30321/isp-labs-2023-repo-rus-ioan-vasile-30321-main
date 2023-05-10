package isp.lab6.exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        List<Product> products=new ArrayList<>();
        products.add(new Product("Chips",7.23f));
        products.add(new Product("Fasole",4.12f));
        products.add(new Product("Chocolate",5.22f));

        Map<String,ActiveSession> sessions=new HashMap<>();
        OnlineStore onlineStore=new OnlineStore(products,sessions);

        Set<User> users=new HashSet<User>();
        users.add(new User("admin","admin"));
        users.add(new User("client1","1234"));
        LoginSystem loginSyst=new LoginSystem(users,onlineStore);

        UserInterface userInterface=new UserInterface(loginSyst,onlineStore);
        char answer;
        String line;

        BufferedReader fluxIn = new BufferedReader(new InputStreamReader(System.in));
        do{
            System.out.println("Menu");
            System.out.println("1-Login");
            System.out.println("2-Register");
            System.out.println("e-exit");
            line=fluxIn.readLine();
            answer=line.charAt(0);

            switch (answer) {
                case '1':
                    String username,password;
                    System.out.println("Username: ");
                    username=fluxIn.readLine();
                    System.out.println("Password: ");
                    password=fluxIn.readLine();
                    if(loginSyst.login(username,password)){
                        userInterface.loadInterface();
                    }
                    break;
                case '2':
                    System.out.println("Username: ");
                    username=fluxIn.readLine();
                    System.out.println("Password: ");
                    password=fluxIn.readLine();
                    loginSyst.register(username,password);
                    break;
                default:
                    System.out.println("Incorrect input!");
            }
        }while (answer!='e' && answer!='E');
        System.out.println("Program Finish!");


    }
}
