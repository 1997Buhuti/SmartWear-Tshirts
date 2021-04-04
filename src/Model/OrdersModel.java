/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author dpman
 */
public class OrdersModel {
    private String order_id ;
    private String  order_date;
    private String customerId;
    private ArrayList<OrderDetailModel> OrderDetailList;
    
    public OrdersModel() {
    }

    public OrdersModel(String order_id, String order_date, String customerId, ArrayList<OrderDetailModel> OrderDetailList) {
        this.order_id = order_id;
        this.order_date=this.order_date;
        this.customerId = customerId;
        this.OrderDetailList = OrderDetailList;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date= order_date;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public ArrayList<OrderDetailModel> getOrderDetailList() {
        return OrderDetailList;
    }

    public void setOrderDetailList(ArrayList<OrderDetailModel> OrderDetailList) {
        this.OrderDetailList = OrderDetailList;
    }



    
    
}
