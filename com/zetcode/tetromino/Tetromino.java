package com.zetcode.tetromino;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

public abstract class Tetromino  {
	protected Block[] blocks;
	protected Color color;
	protected int rotationPercent = 0;
	
	public Tetromino() {
		blocks = new Block[4];
		initTetromino();
	}
	
	public abstract void initTetromino();
	
	public void rotate() {
		rotate(1);
	}
	
	public abstract void rotate(int n);
	
	public void moveLeft() {
		for (Block b : getBlocks()) {
			b.moveLeft();
		}
	}
	
	public void moveRight() {
		for (Block b : getBlocks()) {
			b.moveRight();
		}
	}
	
	public void moveUp() {
		for (Block b : getBlocks()) {
			b.moveUp();
		}
	}
	
	public void moveDown() {
		for (Block b : getBlocks()) {
			b.moveDown();
		}
	}
	
	public void position(int x, int y) {
		if (x < 0) {
			for (int i = x; i < 0; ++i) {
				for (Block b : getBlocks()) {
					b.moveLeft();
				}
			}
		} else {
			for (int i = 0; i < x; ++i) {
				for (Block b : getBlocks()) {
					b.moveRight();
				}
			}
		}
		
		if (y < 0) {
			for (int i = y; i < 0; ++i) {
				for (Block b : getBlocks()) {
					b.moveUp();
				}
			}
		} else {
			for (int i = 0; i < y; ++i) {
				for (Block b : getBlocks()) {
					b.moveDown();
				}
			}
		}
	}
	
	public List<Block> getBlocks() {
		return Arrays.asList(blocks);
	}
	
	public void paintComponent(Graphics g) {
		for (Block b : getBlocks()) {
			b.paintComponent(g);
		}
	}
}
