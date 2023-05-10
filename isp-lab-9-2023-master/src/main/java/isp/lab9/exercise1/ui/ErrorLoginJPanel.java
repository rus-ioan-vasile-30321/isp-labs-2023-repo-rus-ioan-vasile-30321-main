package isp.lab9.exercise1.ui;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

public class ErrorLoginJPanel extends JFrame {
    public ErrorLoginJPanel(String message){

        //setup the window
        this.setTitle("Warning");
        this.setLayout(null);
        this.setBounds(200, 200, 300, 150);
        this.setLocation(700,300);

        //warning ico
        ImageIcon icon=new ImageIcon("./src/main/java/isp/lab9/warningY.png");
        // Get the scaled instance of the image
        Image img = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        // Create a new ImageIcon with the scaled image
        ImageIcon scaledIcon = new ImageIcon(img);


        // Create the label with the scaled icon
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(10, 10, 40, 40);
        this.add(label);
        //
        JLabel warning = new JLabel(message);
        warning.setFont(new Font("Arial", FontUIResource.BOLD,16));
        warning.setForeground(Color.RED);
        warning.setBounds(60, 20, 300, 20);
        this.add(warning);
        //
        JButton button = new JButton("Ok");
        button.setBounds(90, 70, 110, 20);
        this.add(button);
        button.addActionListener(e->dispose());

        //display
        this.setVisible(true);
    }
}
