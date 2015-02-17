package store;

import java.util.*;

public class Cart {
	
	private HashMap<Product,Integer> shoppingCart;
	
	public Cart(){
		shoppingCart = new HashMap<Product,Integer>();
	}
	
	public void setValue(String id, int quant){
		ArrayList<Product> items = getProducts();
		int size = items.size();
		for(int i = 0; i < size; i++){
			Product pd = items.get(i);
			if(pd.getId().equals(id)){
				setQuantity(pd,quant);
				return;
			}
		}
	}
	
	public void setQuantity(Product pd, int quant){
		if(!shoppingCart.containsKey(pd)) return;
		if(quant == 0){
			shoppingCart.remove(pd);
			//System.out.println("Removed");
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
	
	public void addProduct(Product pd){
		if(!shoppingCart.containsKey(pd)){
			shoppingCart.put(pd,1);
		}else{
			shoppingCart.put(pd,shoppingCart.get(pd) + 1);
		}
	}
}
