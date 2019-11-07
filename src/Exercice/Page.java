package Exercice;

import java.util.ArrayList;
import java.util.Collections;

public class Page {
	
	private ArrayList<Integer> listPage;
	
	public Page(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}
	
	public void sort() {
		Collections.sort(listPage);
	}
	
	public String toString() {
		return "";
	}
	

}
