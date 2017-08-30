package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class I extends Tetromino {
	
	public I() {
		
	}

	@Override
	public void initTetromino() {
		color = Color.CYAN;
		
		// [0]
		// [1]
		// [2]
		// [3]
		
		blocks[0] = new Block(Application.B_WIDTH / 2 - 1, -4, color);
		blocks[1] = new Block(Application.B_WIDTH / 2 - 1, -3, color);
		blocks[2] = new Block(Application.B_WIDTH / 2 - 1, -2, color);
		blocks[3] = new Block(Application.B_WIDTH / 2 - 1, -1, color);
	}
	
	/**
	 * rotate 180 degrees at a time, axis of rotation is at blocks[2]
	 */
	public void rotate(int n) {
		for (int i = 0; i < n; ++i) {
			// [0]
			// [1] 
			// [2] => [3][2][1][0]
			// [3]
			if (rotationPercent == 0) {
				blocks[0].moveRight(2);
				blocks[0].moveDown(2);
				
				blocks[1].moveDown();
				blocks[1].moveRight();
				
				blocks[3].moveLeft();
				blocks[3].moveUp();
				
				rotationPercent = 50;
				//                 [0]
				//                 [1]
				// [3][2][1][0] => [2]
				//                 [3]
			} else {
				blocks[0].moveUp(2);
				blocks[0].moveLeft(2);
				
				blocks[1].moveLeft();
				blocks[1].moveUp();
				
				blocks[3].moveDown();
				blocks[3].moveRight();
				
				rotationPercent = 0;
			}
		}
	}
}
