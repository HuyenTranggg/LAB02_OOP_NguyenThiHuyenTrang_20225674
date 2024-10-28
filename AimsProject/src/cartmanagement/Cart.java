package cartmanagement;

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
		StringBuilder output = new StringBuilder("*********************CART************************** \nOrdered items: \n");
        for(int i = 0; i < qtyOrdered; i++) {
            output.append(i+1 + ". " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() + " - "
                    + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() + ": "
                    + itemsOrdered[i].getCost() + " $\n");
        }
        output.append("total: ").append(totalCost()).append(" $\n");
        output.append("***************************************************\n");
        System.out.println(output);
	}
}
