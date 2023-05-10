package isp.lab6.exercise3;

import java.util.HashSet;
import java.util.Set;

public class LoginSystem {
    private Set<User> users;
    private OnlineStore store;

    private User currentUser=new User("","");

    public LoginSystem(Set<User> users, OnlineStore store) {
        this.users = users;
        this.store = store;
    }

    public void register(String username, String password){
        if(this.users.contains(new User(username,password))){
            System.out.println("User already in the database!");
        }
        else {
            users.add(new User(username, password));
            System.out.println("User registered successfully!");
        }

    }
    public boolean login(String username,String password){
        if(users.contains(new User(username, password))){
            for(Object i:users)
                if(i.equals(new User(username, password))) {
                    currentUser.setUsername(username);
                    currentUser.setPassword(password);
                    System.out.println("Login successfully!");
                    return true;
                }
            System.out.println("The password is incorect!");
        }
        System.out.println("This user is not registered !");
        return false;
    }
    public boolean logout(String username){
        if(currentUser.getUsername().equals(username)){
            currentUser=new User("","");
            System.out.println("User logout successfully!");
            return true;
        }
        System.out.println("User not logout or nor exist!");
        return false;
    }
    public void getallusers(){
        for(Object i:users)
            System.out.println(i+"   ");
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
