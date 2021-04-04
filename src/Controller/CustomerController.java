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
import View.CustmerManage11;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class CustomerController {
    
    
    public Connection Connect() throws ClassNotFoundException, SQLException{
        DBConnection conObj=DBConnection.getInstance();
        Connection con= conObj.getConnection();
        return con;
    }
    public boolean saveCustomer(CustomerModel customer) throws ClassNotFoundException, SQLException{
        
                Connection con= Connect();
                PreparedStatement pst= con.prepareStatement("insert into customer(cust_id,cust_name,cust_address,cust_contact_no) values(? ,? ,?, ?)");
                pst.setString(1, customer.getId());
                pst.setString(2, customer.getName());
                pst.setString(3,customer.getAddress());
                pst.setString(4, customer.getContact());
                
                return pst.executeUpdate()>0;

    }
    
    public boolean updateCustomer (CustomerModel customer) throws SQLException, ClassNotFoundException{
        
            Connection con= Connect();
            PreparedStatement pst = con.prepareStatement("update customer set cust_name=?,cust_address=?,cust_contact_no=? where cust_id=?");
            pst.setObject(4, customer.getId());
            pst.setObject(1, customer.getName());
            pst.setObject(2, customer.getAddress());
            pst.setObject(3, customer.getContact());

            return pst.executeUpdate()>0;
    }
    
    public boolean deleteCustomer(String Id) throws ClassNotFoundException, SQLException{
        
                Connection con= Connect();
                PreparedStatement pst= con.prepareStatement("delete from customer where cust_id =?");
                pst.setObject(1,Id);
                return pst.executeUpdate()>0;

              
    }
    
    public ArrayList<CustomerModel> getAllCustomers() throws ClassNotFoundException, SQLException{
            
            String sql="select * from customer";
            Connection con= Connect();
            PreparedStatement pst= con.prepareStatement(sql);
            ResultSet rst= pst.executeQuery(sql);
            
            ArrayList<CustomerModel> customers= new ArrayList<>();
                while(rst.next()){
                    customers.add(new CustomerModel(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4)));
                }
            return customers;
        
    }
    
    public CustomerModel searchCustomer(String Id) throws ClassNotFoundException, SQLException{
        
        Connection con= Connect();
         PreparedStatement pst = con.prepareStatement("SELECT * FROM customer where cust_id=?");
         CustomerModel customer= new CustomerModel();
         pst.setObject(1, Id);
         ResultSet rs = pst.executeQuery();
       
            if(rs.next())
            {
                customer.setId(rs.getString(1));
                customer.setName(rs.getString(2));
                customer.setAddress(rs.getString(3));
                customer.setContact(rs.getString(4));
           }
        return customer;
    }
    
}
