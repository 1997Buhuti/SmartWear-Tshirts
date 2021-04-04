/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.CustomerModel;
import Model.ItemModel;
import Model.OrderDetailModel;
import View.CustmerManage11;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class ItemController {
    
    
    public Connection Connect() throws ClassNotFoundException, SQLException{
        DBConnection conObj=DBConnection.getInstance();
        Connection con= conObj.getConnection();
        return con;
    }
    public boolean saveItem(ItemModel item) throws ClassNotFoundException, SQLException{
        
                Connection con= Connect();
                PreparedStatement pst= con.prepareStatement("insert into item(item_code,item_description,item_unitPrice,item_qtyOnHand) values(? ,? ,?, ?)");
                pst.setString(1, item.getCode());
                pst.setString(2, item.getDescription());
                pst.setDouble(3,item.getUnitPrice());
                pst.setInt(4, item.getQtyOnHand());
                
                return pst.executeUpdate()>0;

    }
    
    public boolean updateItem (ItemModel item) throws SQLException, ClassNotFoundException{
        
            Connection con= Connect();
            PreparedStatement pst = con.prepareStatement("update item set item_description=?,item_unitPrice=?,item_qtyOnHand=? where item_code =?");
            pst.setObject(4, item.getCode());
            pst.setObject(1, item.getDescription());
            pst.setObject(2, item.getUnitPrice());
            pst.setObject(3, item.getQtyOnHand());

            return pst.executeUpdate()>0;
    }
    
    public boolean deleteItem(String Code) throws ClassNotFoundException, SQLException{
        
                Connection con= Connect();
                PreparedStatement pst= con.prepareStatement("delete from item where item_code  =?");
                pst.setObject(1,Code);
                return pst.executeUpdate()>0;

              
    }
    
    public ArrayList<ItemModel> getAllItems() throws ClassNotFoundException, SQLException{
            
            String sql="select * from item";
            Connection con= Connect();
            PreparedStatement pst= con.prepareStatement(sql);
            ResultSet rst= pst.executeQuery(sql);
            
            ArrayList<ItemModel> items= new ArrayList<>();
                while(rst.next()){
                    items.add(new ItemModel(rst.getString(1),rst.getString(2),rst.getDouble(3),rst.getInt(4)));
                }
            return items;
        
    }
    
    public ItemModel searchCustomer(String Id) throws ClassNotFoundException, SQLException{
        
         Connection con= Connect();
         PreparedStatement pst = con.prepareStatement("SELECT * FROM item where item_code =?");
         ItemModel item= new ItemModel();
         pst.setObject(1, Id);
         ResultSet rs = pst.executeQuery();
       
            if(rs.next())
            {
                item.setCode(rs.getString(1));
                item.setDescription(rs.getString(2));
                item.setQtyOnHand(rs.getInt(3));
                item.setUnitPrice(rs.getDouble(4));
           }
        return item;
    }
    
        public static boolean updateStockDec(ArrayList<OrderDetailModel> OrderDetailList) throws ClassNotFoundException, SQLException {
        for (OrderDetailModel OrderDetail : OrderDetailList) {
            boolean isUpdate = ItemController.updateStockDec(OrderDetail);
            if(!isUpdate){
                return false;
            }
        }
        return true;
    }
    public static boolean updateStockDec(OrderDetailModel OrderDetail) throws ClassNotFoundException, SQLException{
        PreparedStatement stm = DBConnection.getInstance().getConnection().prepareStatement("update item set item_qtyOnHand=item_qtyOnHand-? where item_code=?");
        stm.setObject(1, OrderDetail.getQunatity());
        stm.setObject(2, OrderDetail.getItemCode());
        return stm.executeUpdate()>0;
    }
    
}
