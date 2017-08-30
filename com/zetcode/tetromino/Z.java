package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class Z extends Tetromino {

	public Z() {
		
	}
	
	@Override
	public void initTetromino() {
		color = Color.RED;
		
		// [0][1]
		//    [2][3]
		
		blocks[0] = new Block(Application.B_WIDTH / 2 - 1, -2, color);
		blocks[1] = new Block(Application.B_WIDTH / 2, -2, color);
		blocks[2] = new Block(Application.B_WIDTH / 2, -1, color);
		blocks[3] = new Block(Application.B_WIDTH / 2 + 1, -1, color);
	}
	
	/**
	 * rotate 180 degrees at a time, axis of rotation is at blocks[1]
	 */
	public void rotate(int n) {
		for (int i = 0; i < n; ++i) {
			//
			//                  [0]
			// [0][1]     => [2][1]
			//    [2][3]     [3]
			//
			if (rotationPercent == 0) {
				blocks[0].moveUp();
				blocks[0].moveRight();
				
				blocks[2].moveLeft();
				blocks[2].moveUp();
				
				blocks[3].moveLeft(2);
				
				rotationPercent += 50;
			//
			//    [2]
			//    [3][0] =>    [0][1]
			//       [1]    [2][3] 
			//
			} else {
				blocks[0].moveLeft();
				blocks[0].moveDown();
				
				blocks[2].moveDown();
				blocks[2].moveRight();
				
				blocks[3].moveRight(2);
				
				rotationPercent = 0;
			}
		}
	}
}
