/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.Users.User;
import isp.lab9.exercise1.services.StockPortofolioQueryService;
import isp.lab9.exercise1.services.StockPortofolioQueryService;
import isp.lab9.exercise1.services.UserPortfolio;
import isp.lab9.exercise1.services.StockMarketQueryService;

import javax.swing.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class StockMarketJFrame extends JFrame {
    private StockMarketQueryService marketService;
    private StockPortofolioQueryService portofoliuService;
    private UserPortfolio portfolio;

    /**
     * Creates new form StockMarketJFrame
     */
    public StockMarketJFrame(User currentuser) {
        try {
            portofoliuService =new StockPortofolioQueryService();
            portofoliuService.refreshPortfolioData(currentuser.getUserPortfolio());
            marketService = new StockMarketQueryService();
            marketService.refreshMarketData();
            portfolio = new UserPortfolio(currentuser.getUserPortfolio());
        } catch (IOException ex) {
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setVisible(true);
    }

    /**
     * Initializes the window with the tabs and main panels. Each panel is definied in its own class.
     */
    private void initComponents() {
        this.setBounds(400,50,700,400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // configure windows the tabs
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Market", new MarketJPanel(this));
        tabs.addTab("UserPortfolio", new PortofolioJPanel(this,portfolio));
        tabs.addTab("Buy", new BuyJPanel(this));
        tabs.addTab("Sell", new SellJPanel());
        this.add(tabs);

    }

    public StockMarketQueryService getMarketService() {
        return marketService;
    }

    public StockPortofolioQueryService getUserService() {
        return portofoliuService;
    }

    public UserPortfolio getPortfolio() {
        return portfolio;
    }
    public void modifyPortofolio(float cost){
        portfolio.setCash(cost);
    }
}
