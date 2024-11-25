package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc[] itemsInStore;
	private int numItems;
	private static final int MAX_CAPACITY = 1000;
	
	public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_CAPACITY];
        numItems = 0;
    }

    public boolean checkDVD(DigitalVideoDisc disc) {
        for (DigitalVideoDisc digitalVideoDisc : itemsInStore) {
            if (digitalVideoDisc != null && digitalVideoDisc.equals(disc)) {
                return true;
            }
        }
        return false;
    }

    public void removeDVD(DigitalVideoDisc disc) {
    	if(!checkDVD(disc)) {
    		System.out.println("There is no "+ disc.getTitle() + " in the store!");
    		return;
    	}
    	for (int i = 0; i < numItems; i++) {
            if (itemsInStore[i].getTitle().equals(disc.getTitle())) {
                System.out.println("DVD \"" + itemsInStore[i].getTitle() + "\" has been removed from the store.");
                
                for (int j = i; j < numItems - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[numItems - 1] = null; 
                numItems--;
                return;
            }
        }
    }

    public void addDVD(DigitalVideoDisc disc) {
        if(!checkDVD(disc)) {
            itemsInStore[numItems] = disc;
            numItems++;
            System.out.println( disc.getTitle() + " has been added to the store!");
        } 
        else {
            System.out.println( disc.getTitle() + " already exists in the store!");
        }

    }

    public String toString() {
        StringBuilder string = new StringBuilder("****************STORE***************\nItems in the store: \n");
        if(numItems == 0) string.append("There is no dvd in the store!\n");
        else {
            for (DigitalVideoDisc dvd : itemsInStore) {
            	if (dvd != null)
            		string.append(dvd.getTitle() + " - " + dvd.getCost() + " $\n");
            }
        }
        string.append("***************************************");
        return string.toString();
    }
}
