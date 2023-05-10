package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.Users.*;
import static isp.lab9.exercise1.Users.userHandling.*;


import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class LoginJFrame extends JFrame {

    public LoginJFrame() {
        //add users

        //setup the window
        this.setTitle("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(700, 200, 300, 270);

        //create and add components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setFont(new Font("Arial", FontUIResource.BOLD,18));
        userLabel.setBounds(30, 40, 100, 20);
        this.add(userLabel);

        JTextField userInputField = new JTextField();
        userInputField.setBounds(150, 42, 100, 20);
        this.add(userInputField);

        JLabel pwdLabel = new JLabel("Password:");
        pwdLabel.setFont(new Font("Arial", FontUIResource.BOLD,18));
        pwdLabel.setBounds(30, 80, 100, 20);
        this.add(pwdLabel);

        JPasswordField pwdInputField = new JPasswordField();
        pwdInputField.setBounds(150, 80, 100, 20);
        this.add(pwdInputField);

        JButton button = new JButton("Login");
        button.setBounds(20, 160, 240, 20);
        this.add(button);


        // add event listener to button
        button.addActionListener(e -> verifyCredentials(userInputField, pwdInputField));


        //display
        this.setVisible(true);
    }

    private void verifyCredentials(JTextField userInputField, JPasswordField pwdInputField) {
        // todo: implement the login by checking the credentials
        //  show an error message (in a JDialog) in case of bad credentials
        //close login-window
        AtomicReference<User> acurrentuser = new AtomicReference<>();
        List<User> users=readUsers();
        AtomicBoolean isAuthorized= new AtomicBoolean(false);
        users.forEach(user -> {
            if(Integer.parseInt(user.getUsername())==userInputField.getText().hashCode() && (Integer.parseInt(user.getPassword())==(pwdInputField.getText()).hashCode())){
                isAuthorized.set(true);
                acurrentuser.set(user);
            }
        });
        //to delete this in future

        User currentuser=acurrentuser.get();
        if(isAuthorized.get()){
            new StockMarketJFrame(currentuser);
            this.setVisible(false);
        }
        else new ErrorLoginJPanel("The password is wrong!");

    }

}
