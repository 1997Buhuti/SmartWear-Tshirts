/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author dpman
 */
public class OrderDetailModel {
    
    private String OrderId;
    private String ItemCode;
    private int Qunatity;
    private double UnitPrice;

    public OrderDetailModel() {
    }

    public OrderDetailModel(String OrderId, String ItemCode, int Qunatity, double UnitPrice) {
        this.OrderId = OrderId;
        this.ItemCode = ItemCode;
        this.Qunatity = Qunatity;
        this.UnitPrice = UnitPrice;
    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String OrderId) {
        this.OrderId = OrderId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String ItemCode) {
        this.ItemCode = ItemCode;
    }

    public int getQunatity() {
        return Qunatity;
    }

    public void setQunatity(int Qunatity) {
        this.Qunatity = Qunatity;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }
    
    
    
}
