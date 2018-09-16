class ShoppingCart{
	Item[] catalog;
	Item[] cart;
	int cartSize;
	int catalogSize;
	String[] validCoupons ={"IND10","IND20","IND30","IND50"};
	static double discount = 0.0;
	static boolean couponApplied = false;

	ShoppingCart(){
		catalog = new Item[20];
		cart = new Item[20];
		cartSize=0;
		catalogSize =0;
	}

	void addToCatalog(Item item){
		catalog[catalogSize++] = item;

	}
	void addToCart(Item item){
		if(!inCart(item)){
			if(checkCatalog(item)){
				cart[cartSize++] = item;
			}
		}
	}
	boolean inCart(Item item){
		for(Item s : cart){
			if(s!=null){
				if(s.equals(item)){
					s.quantity =s.quantity+item.quantity;
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkCatalog(Item given){
		for(Item i : catalog){
			if(i!=null){
				if(i.equals(given)){
					if(given.quantity<= i.quantity){
						i.quantity = i.quantity- given.quantity;
						return true;
					}

				}
			}
		}
		return false;
	}

	void removeFromCart(Item item){
		for(int i =0;i<cartSize;i++){
			if(item.equals(cart[i])){
				cart[i].quantity= cart[i].quantity-item.quantity;
			}
		}

	}
	void showCart(){
		for(Item i : cart){
			if(i!=null){
				if(i.quantity!=0){
					System.out.println(i.name+" "+i.quantity);
				}
			}
		}
	}
	void showCatalog(){
		for(Item i : catalog){
			if(i!=null){
				System.out.println(i);
			}
		}
	}
	double getTotalAmount(){
		double total=0;
		for(int i =0; i< cartSize;i++){
			total += cart[i].quantity * getPrice(cart[i]);
		}
		return total;

	}
	double getPrice(Item given){
		for(Item i : catalog){
			if(i!=null){
				if(i.equals(given)){
					return i.price;
				}
			}
		}
		return 0.0;
	}
	void applyCoupon(String cou){
		boolean valid= false;
		for(String s : validCoupons){
			if(s.equals(cou)){
				valid = true;
			}
		}
		if(!valid){
			System.out.println("Invalid coupon");
			return;
		}
		if(couponApplied){
			return;
		}
		for(String s : validCoupons){
			if(s.equals(cou)){
				int num =  Integer.parseInt(cou.substring(3));
				discount = getTotalAmount()/100*num;
				couponApplied = true;
			}
		}
	}
	void printInvoice(){
		System.out.println("Name   quantity   Price");
		for(Item s : cart){
			if(s!=null){
				if(s.quantity!=0) {
			        System.out.println(s.name+" "+s.quantity+" "+getPrice(s));
		        }
		    }
		}
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal *15/100;
		System.out.println("Total:"+getTotalAmount());
		System.out.println("Disc%:"+discount);
		System.out.println("Tax:"+tax);
		System.out.println("Payable amount: "+getPayableAmount());
	}
    public double getPayableAmount() {
		double total = getTotalAmount();
		double newTotal = total - discount;
		double tax = newTotal *15/100;
		return newTotal+tax;
    }
}
