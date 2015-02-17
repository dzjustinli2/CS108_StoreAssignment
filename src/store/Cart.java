package store;

import java.util.*;

public class Cart {
	
	private HashMap<Product,Integer> shoppingCart;
	
	public Cart(){
		shoppingCart = new HashMap<Product,Integer>();
	}
	
	public void setQuantity(Product pd, int quant){
		if(!shoppingCart.containsKey(pd)) return;
		if(quant == 0){
			shoppingCart.remove(quant);
		}else{
			shoppingCart.put(pd,new Integer(quant));
		}
	}
	
	public int getQuantity(Product pd){
		if(!shoppingCart.containsKey(pd)) return 0;
		return shoppingCart.get(pd).intValue();
	}
	
	public void emptyCart(){
		shoppingCart.clear();
	}
	
	public ArrayList<Product> getProducts(){
		return new ArrayList<Product>(shoppingCart.keySet());
	}
	
}
