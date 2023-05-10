package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.Users.User;
import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  todo: implement portfolio panel; for each owned stock add symbol, quantity, price per unit, total price of the position
 *  it should look similar to the 'Market' panel
 */
public class PortofolioJPanel extends JPanel {
    private StockMarketJFrame frame;
    private UserPortfolio currentuser;
    private JLabel founds = new JLabel();
    public PortofolioJPanel(StockMarketJFrame frame,UserPortfolio currentuser){
        this.frame = frame;
        this.currentuser=currentuser;
        initComponent();
    }
    private void initComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTable jTableMarket = new JTable();
        jTableMarket.setModel(frame.getUserService());
        JScrollPane marketScrollablePane = new JScrollPane(jTableMarket);

        add(marketScrollablePane);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(evt -> buttonRefreshActionPerformed(evt));


        //available founds
        founds.setText("Available Founds: "+currentuser.getCash()+" $");
        founds.setFont(new Font("Arial", FontUIResource.ROMAN_BASELINE,16));
        this.add(founds);



        add(marketScrollablePane);
        add(refreshButton);

    }

    /**
     * Refreshes the stock data.
     */
    private void buttonRefreshActionPerformed(ActionEvent evt) {
        try {
            frame.getUserService().refreshPortfolioData(currentuser);
            founds.setText("Available Founds: "+currentuser.getCash()+" $");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
