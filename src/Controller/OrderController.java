/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DBConnection;
import Model.ItemModel;
import Model.OrdersModel;
import View.Orderform;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dpman
 */


public class OrderController {
    

    public ArrayList <String> loadCustomerId() throws ClassNotFoundException, SQLException{
        
        String sql="select* from customer";
        ArrayList <String> custIds = new ArrayList<>();
        DBConnection dbcon = DBConnection.getInstance();
        Connection con=dbcon.getConnection();
        PreparedStatement pst= con.prepareStatement(sql);
        ResultSet rst=pst.executeQuery();
        
        while(rst.next()){
            
            custIds.add(rst.getString(1));
        }
        return custIds;
    }
    
    
    public  ArrayList <String> loadItemNames() throws ClassNotFoundException, SQLException{
        
        
        String sql2="select* from item";
        ArrayList <String> itemNames= new ArrayList<>();
        DBConnection dbcon = DBConnection.getInstance();
        Connection con=dbcon.getConnection();
        PreparedStatement pst= con.prepareStatement(sql2);
        ResultSet rst2=pst.executeQuery();
        
            while(rst2.next()){
              
                itemNames.add(rst2.getString(2));
            }
            
            return  itemNames;
    }
 
    public static boolean placeOrder(OrdersModel order) throws ClassNotFoundException, SQLException {
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("Insert into Orders values(?,?,?)");
        stm.setObject(1, order.getOrder_id());
        stm.setObject(2, order.getOrder_date());
        stm.setObject(3, order.getCustomerId());
        int res = stm.executeUpdate();
        if(res>0){
            boolean isAdded = ItemDetailController.addItemDetail(order.getOrderDetailList());
            if(isAdded){
                boolean isUpdated = ItemController.updateStockDec(order.getOrderDetailList());
                if(isUpdated){
                    return true;
                }
            }
        }
        return false;
    }
}
