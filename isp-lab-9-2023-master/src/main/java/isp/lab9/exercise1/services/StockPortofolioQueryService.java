package isp.lab9.exercise1.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import isp.lab9.exercise1.Users.User;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import javax.swing.table.AbstractTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Uses https://financequotes-api.com/ (https://github.com/sstrickx/yahoofinance-api) SDK for getting stock financial data.
 *
 * @author mihai.hulea
 */
public class StockPortofolioQueryService extends AbstractTableModel {
    private String[] columns = new String[]{"Name", "Symbol", "Quantity", "Price/Unit", "Total Price"};
    private String[] symbols = new String[]{"INTC", "BABA", "TSLA", "AIR.PA", "MSFT", "AAPL",
            "OHI", "MPW", "MMM", "SWK", "PFE", "ABB", "JNJ", "MDT", "RIO", "EPD", "ET", "USA",
            "BHP", "BP", "BCE", "VZ", "GOOG"};
    private Map<String, Stock> stocks = new HashMap<String, Stock>();
    private ArrayList<StockItem> items = new ArrayList<>();
    private TreeMap<String, Integer> shares=new TreeMap<>();

    /**
     * Retrieves stocks' data through the Yahoo Finance API and refreshes the table.
     *
     * @throws IOException in case of API communication errors
     */
    public void refreshPortfolioData(UserPortfolio currentuser) throws IOException {

        stocks = YahooFinance.get(symbols);
        System.out.println("@@@@@@@@@");
        shares=currentuser.getShares();
        items = new ArrayList<>();
        stocks.values().stream().forEach(s -> {
            if(shares.keySet().contains(s.getSymbol()))
            {
                items.add(new StockItem(s));
            }
        });

        this.fireTableDataChanged();
    }

    /**
     * Retrieves the price for a single stock symbol.
     *
     * @param symbol the stock symbol (ticker)
     * @return the price
     * @throws IOException in case of API communication errors
     */
    public BigDecimal getStockPrice(String symbol) throws IOException {
        Stock stock = YahooFinance.get(symbol);
        return stock.getQuote().getPrice();
    }

    /**
     * Used to populate drop down button (Combo Box).
     *
     * @return
     */
    public String[] getSymbols() {
        return symbols;
    }

    //--------------------------------------------------------------
    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         StockItem i = items.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return i.getName();
            case 1:
                return i.getSymbol();
            case 2:
                return shares.get(i.getSymbol())+" USD";
            case 3:
                if (i.getPrice() != null) return i.getPrice().toPlainString();
                else return "N/A";
            case 4:
                return i.getPrice().doubleValue()*shares.get(i.getSymbol())+" USD";
        }
        return "N/A";
    }

    @Override
    public String getColumnName(int index) {
        return columns[index];
    }

}

