package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class J extends Tetromino {

	public J() {
		
	}
	
	@Override
	public void initTetromino() {
		color = Color.BLUE;
		
		//    [0]
		//    [1]
		// [2][3]
		
		blocks[0] = new Block(Application.B_WIDTH / 2, -3, color);
		blocks[1] = new Block(Application.B_WIDTH / 2, -2, color);
		blocks[2] = new Block(Application.B_WIDTH / 2 - 1, -1, color);
		blocks[3] = new Block(Application.B_WIDTH / 2, -1, color);
	}
	
	/**
	 * rotate 90 degrees at a time, axis of rotation is at blocks[1]
	 */
	public void rotate(int n) {
		for (int i = 0; i < n; ++i) {
			//
			//    [0]    [2]
			//    [1] => [3][1][0]
			// [2][3]
			//
			if (rotationPercent == 0) {
				blocks[0].moveRight();
				blocks[0].moveDown();
				
				blocks[2].moveUp(2);
				
				blocks[3].moveLeft();
				blocks[3].moveUp();
				
				rotationPercent += 25;
			//
			// [2]          [3][2]
			// [3][1][0] => [1]
			//              [0]
			//
			} else if (rotationPercent == 25) {
				blocks[0].moveDown();
				blocks[0].moveLeft();
				
				blocks[2].moveRight(2);
				
				blocks[3].moveUp();
				blocks[3].moveRight();
				
				rotationPercent += 25;
			//
			// [3][2]
			// [1]    => [0][1][3]
			// [0]             [2]
			//
			} else if (rotationPercent == 50) {
				blocks[0].moveLeft();
				blocks[0].moveUp();
				
				blocks[2].moveDown(2);
				
				blocks[3].moveRight();
				blocks[3].moveDown();
				
				rotationPercent += 25;
				
			//
			//                 [0]
			// [0][1][3] =>    [1]
			//       [2]    [2][3]
			//
			} else {
				blocks[0].moveUp();
				blocks[0].moveRight();
				
				blocks[2].moveLeft(2);
				
				blocks[3].moveDown();
				blocks[3].moveLeft();
				
				rotationPercent = 0;
			}
		}
	}
}
