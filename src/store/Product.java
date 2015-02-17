package store;

import java.util.*;

public class Product {
	
	String id = "";
	String name = "";
	String imageFile = "";
	double price = 0.0;
	
	public Product(ArrayList<String> info){
		id = info.get(0);
		name = info.get(1);
		imageFile = info.get(2);
		price = Double.parseDouble(info.get(3));
	}
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getImageFile(){
		return imageFile;
	}
	
	public double getPrice(){
		return price;
	}
	
	public int hashCode() {
		return id.hashCode();
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Product)) return false;
		if (obj == this) return true;
		Product pd = (Product)obj;
		if(pd.getId().equals(this.getId())){
			return true;
		}else{
			return false;
		}
	}
	
}
