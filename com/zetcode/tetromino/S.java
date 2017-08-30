package com.zetcode.tetromino;

import java.awt.Color;

import com.zetcode.Application;

public class S extends Tetromino {

	public S () {
		
	}
	
	@Override
	public void initTetromino() {
		color = Color.GREEN;
		
		//
		//    [0][1]
		// [2][3]
		//
		
		blocks[0] = new Block(Application.B_WIDTH / 2, -2, color);
		blocks[1] = new Block(Application.B_WIDTH / 2 + 1, -2, color);
		blocks[2] = new Block(Application.B_WIDTH / 2 - 1, -1, color);
		blocks[3] = new Block(Application.B_WIDTH / 2, -1, color);
	}
	
	/**
	 * rotate 180 degrees at a time, axis of rotation is at blocks[0]
	 */
	public void rotate(int n) {
		for (int i = 0; i < n; ++i) {
			//
			//              [2]
			//    [0][1] => [3][0]
			// [2][3]          [1]
			//
			if (rotationPercent == 0) {
				blocks[1].moveDown();
				blocks[1].moveLeft();
				
				blocks[2].moveUp(2);
				
				blocks[3].moveLeft();
				blocks[3].moveUp();
				
				rotationPercent += 50;
			//
			//    [2]
			//    [3][0] =>    [0][1]
			//       [1]    [2][3] 
			//
			} else {
				blocks[1].moveRight();
				blocks[1].moveUp();
				
				blocks[2].moveDown(2);
				
				blocks[3].moveDown();
				blocks[3].moveRight();
				
				rotationPercent = 0;
			}
		}
	}
}
