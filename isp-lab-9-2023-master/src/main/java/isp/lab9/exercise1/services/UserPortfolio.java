/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab9.exercise1.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Uses Lombok to get rid of boilerplate code.
 *
 * @author mihai.hulea
 * @author radu.miron
 */
@Data // it creates getters, setters, equals(), hashCode() and toString() (at compile time)
@AllArgsConstructor // it creates the constructor with arguments for all the attributes (at compile time)
public class UserPortfolio {
    private BigDecimal cash;
    private TreeMap<String, Integer> shares; // a map of number of shares by stock symbol
    public UserPortfolio(UserPortfolio userPortfolio) {
        this.cash = userPortfolio.getCash();
        this.shares = userPortfolio.getShares();
    }
    public BigDecimal getCash() {
        return cash;
    }
    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }
    public void setShares(TreeMap<String, Integer> shares) {
        this.shares = shares;
    }
    @Override
    public String toString() {
        return "UserPortfolio{" +
                "cash=" + cash +
                ", shares=" + shares +
                '}';
    }

    public void setCash(float cost) {
        this.cash= BigDecimal.valueOf(cost);
    }
}
