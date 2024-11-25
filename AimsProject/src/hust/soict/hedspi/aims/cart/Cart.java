package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	// them dia DVD vao gio hang
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Can't add more disc");
            return;
        } 
		else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The DVD " + disc.getTitle() + " has been added into cart");
            return;
        }
	}

/*	
	// them list dia DVD vao gio hang 2.1
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
	            System.out.println("The cart is full. Can't add more disc: " + disc.getTitle());
	            return;
	        } 
	        else {
	            itemsOrdered[qtyOrdered] = disc;
	            qtyOrdered++;
	            System.out.println("The DVD " + disc.getTitle() + " has been added into cart");
	        }
	    }
	}
*/


	// them so luong tuy y dia DVD 2.1
	public void addDigitalVideoDisc(DigitalVideoDisc... discs) {
	    for (DigitalVideoDisc disc : discs) {
	        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
	            System.out.println("The cart is full. Can't add more disc: " + disc.getTitle());
	            return;
	        } 
	        else {
	            itemsOrdered[qtyOrdered] = disc;
	            qtyOrdered++;
	            System.out.println("The DVD " + disc.getTitle() + " has been added into cart");
	        }
	    }
	}

	
	// them 2 dia DVD
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    // them dia 1
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd1;
	        qtyOrdered++;
	        System.out.println("The DVD " + dvd1.getTitle() + " has been added into the cart");
	    } 
	    else {
	        System.out.println("The cart is full. Can't add more discs. Failed to add: " + dvd1.getTitle());
	    }

	    // them dia 2
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd2;
	        qtyOrdered++;
	        System.out.println("The DVD " + dvd2.getTitle() + " has been added into the cart");
	    } 
	    else {
	        System.out.println("The cart is full. Can't add more discs. Failed to add: " + dvd2.getTitle());
	    }
	}

	
	// xoa dia DVD khoi gio hang
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        if(itemsOrdered[0] ==  null) {
            System.out.println("Your cart is empty");
            return;
        }
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].equals(disc)) {
                for(int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                System.out.println("Remove DVD " + disc.getTitle() + " successfully");
                return;
            }
        }
        System.out.println("No DVD match");
        return;
    }
	
	// tinh tong gia tien dia
	public float totalCost() {
        float sum = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
	
	// hien thong tin dia
	public void displayDigitalVideoDisc() {
		StringBuilder output = new StringBuilder("***********************CART*********************** \nOrdered items: \n");
        for(int i = 0; i < qtyOrdered; i++) {
            output.append(i+1 + ". DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - "
                    + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": "
                    + itemsOrdered[i].getCost() + " $\n");
        }
        output.append("Total cost: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
	}
	
	// tim kiem boi ID
	public void searchById(int i) {
        if(i > qtyOrdered || i <= 0) {
            System.out.println("No match found!\n");
        } 
        else {
            System.out.println("Result: "+ itemsOrdered[i - 1].getTitle() + " - "
                    + itemsOrdered[i - 1].getCategory() + " - "
                    + itemsOrdered[i - 1].getDirector() + " - "
                    + itemsOrdered[i - 1].getLength() + ": " + itemsOrdered[i - 1].getCost() + " $\n");
        }

    }
	
	// tim kiem bang title
	public void searchByTitle(String title) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getTitle().equals(title)) {
                System.out.println("Result: " + itemsOrdered[i].getTitle() + " - "
                        + itemsOrdered[i].getCategory() + " - "
                        + itemsOrdered[i].getDirector() + " - "
                        + itemsOrdered[i].getLength() + ": " +itemsOrdered[i].getCost() + " $\n");
                return;
            }
        }
        System.out.println("No match found!\n");
    }

}
