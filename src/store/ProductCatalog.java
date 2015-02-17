package store;

import java.util.*;
import java.sql.*;

public class ProductCatalog {
	
	public static ArrayList<Product> getProducts(DbConnection db){
		db.openDB();
		ResultSet rs = db.search("SELECT * FROM products");
		ArrayList<Product> pdAr = new ArrayList<Product>();
		if(rs == null) return pdAr;
    	try{
    		while(rs.next()){
    			ArrayList<String> ar = new ArrayList<String>();
	    		for(int i = 1; i < 5; i++){
	    			ar.add(rs.getString(i));
	    		}
	    		Product pd = new Product(ar);
	    		pdAr.add(pd);
    		}
    	}catch(SQLException ex){
    		ex.printStackTrace();
    	}
		db.closeDB();
		return pdAr;
	}
}
