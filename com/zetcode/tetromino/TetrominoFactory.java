package com.zetcode.tetromino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TetrominoFactory {
	private List<Tetromino> bag = null;
	
	public TetrominoFactory () {
		createNewBag();
	}
	
	private void createNewBag() {
		bag = new ArrayList<Tetromino>();
		
		bag.add(new I());
		bag.add(new J());
		bag.add(new L());
		bag.add(new O());
		bag.add(new S());
		bag.add(new T());
		bag.add(new Z());
		
		Collections.shuffle(bag);
	}
	
	/**
	 * Create Tetrominoes using a 7-bag randomizer
	 * 
	 * Create a bag of the 7 pieces, order them at random, and repeat
	 */
	public Tetromino create() {
		if (bag.size() == 0) {
			createNewBag();
		}
		
		return bag.remove(0);
	}
}
