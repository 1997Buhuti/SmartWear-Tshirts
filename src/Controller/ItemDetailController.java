/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DBConnection;
import Model.OrderDetailModel;
import Model.OrdersModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author dpman
 */
public class ItemDetailController {
    
    public static boolean addItemDetail(ArrayList<OrderDetailModel> orderDetailList) throws ClassNotFoundException, SQLException{
        for (OrderDetailModel orderDetail : orderDetailList) {
            boolean isAdded=addItemDetail(orderDetail);
            if(!isAdded){
                return false;
            }
        }
        return true;
    }
    public static boolean addItemDetail(OrderDetailModel orderDetails) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("insert into OrderDetail values(?,?,?,?)");
        
        stm.setObject(1, orderDetails.getOrderId());
        stm.setObject(2, orderDetails.getItemCode());
        stm.setObject(3,orderDetails.getQunatity());
        stm.setObject(4, orderDetails.getUnitPrice());
        
        return stm.executeUpdate()>0;
    }
}
