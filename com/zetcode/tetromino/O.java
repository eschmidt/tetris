package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class O extends Tetromino {

	public O() {
		
	}

	@Override
	public void initTetromino() {
		color = Color.YELLOW;
		
		// [0][1]
		// [2][3]
		
		blocks[0] = new Block(Application.B_WIDTH / 2 - 1, -2, color);
		blocks[1] = new Block(Application.B_WIDTH / 2, -2, color);
		blocks[2] = new Block(Application.B_WIDTH / 2 - 1, -1, color);
		blocks[3] = new Block(Application.B_WIDTH / 2, -1, color);
	}
	
	public void rotate(int n) {
		// do not rotate
	}
}
