package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class L extends Tetromino {

	public L() {
		
	}
	
	@Override
	public void initTetromino() {
		color = Color.ORANGE;
		
		// [0]
		// [1]
		// [2][3]
		
		blocks[0] = new Block(Application.B_WIDTH / 2 - 1, -3, color);
		blocks[1] = new Block(Application.B_WIDTH / 2 - 1, -2, color);
		blocks[2] = new Block(Application.B_WIDTH / 2 - 1, -1, color);
		blocks[3] = new Block(Application.B_WIDTH / 2, -1, color);
	}
	
	/**
	 * rotate 90 degrees at a time, axis of rotation is at blocks[1]
	 */
	public void rotate(int n) {
		for (int i = 0; i < n; ++i) {
			//
			// [0]    
			// [1]    => [2][1][0]
			// [2][3]    [3]
			//
			if (rotationPercent == 0) {
				blocks[0].moveRight();
				blocks[0].moveDown();
				
				blocks[2].moveLeft();
				blocks[2].moveUp();
				
				blocks[3].moveLeft(2);
				
				rotationPercent += 25;
			//
			// [2][1][0]    [3][2]
			// [3]       =>    [1]
			//                 [0]
			//
			} else if (rotationPercent == 25) {
				blocks[0].moveDown();
				blocks[0].moveLeft();
				
				blocks[2].moveUp();
				blocks[2].moveRight();
				
				blocks[3].moveUp(2);
				
				rotationPercent += 25;
			//
			// [3][2]          [3]
			//    [1] => [0][1][2]
			//    [0]             
			//
			} else if (rotationPercent == 50) {
				blocks[0].moveLeft();
				blocks[0].moveUp();
				
				blocks[2].moveRight();
				blocks[2].moveDown();
				
				blocks[3].moveRight(2);
				
				rotationPercent += 25;
			//
			//       [3]    [0]
			// [0][1][2] => [1]
			//              [2][3]
			//
			} else {
				blocks[0].moveUp();
				blocks[0].moveRight();
				
				blocks[2].moveDown();
				blocks[2].moveLeft();
				
				blocks[3].moveDown(2);
				
				rotationPercent = 0;
			}
		}
	}
}
