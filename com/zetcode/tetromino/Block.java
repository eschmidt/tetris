package com.zetcode.tetromino;

import java.awt.Color;
import java.awt.Graphics;

import com.zetcode.Application;

public class Block {
	private int x;
	private int y;
	private Color color;
	
	public Block(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void moveLeft() {
		moveLeft(1);
	}
	
	public void moveLeft(int n) {
		x -= n;
	}
	
	public void moveRight() {
		moveRight(1);
	}
	
	public void moveRight(int n) {
		x += n;
	}
	
	public void moveUp() {
		moveUp(1);
	}
	
	public void moveUp(int n) {
		y -= n;
	}
	
	public void moveDown() {
		moveDown(1);
	}
	
	public void moveDown(int n) {
		y += n;
	}
	
	public void paintComponent(Graphics g) {
		int x = getX() * Application.BLOCK_SIZE;
		int y = getY() * Application.BLOCK_SIZE;
		Color color = getColor();
		
		g.setColor(color);
		g.fillRect(x + 1, y + 1, Application.BLOCK_SIZE - 2, Application.BLOCK_SIZE - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + Application.BLOCK_SIZE - 1, x, y);
        g.drawLine(x, y, x + Application.BLOCK_SIZE - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + Application.BLOCK_SIZE - 1,
                         x + Application.BLOCK_SIZE - 1, y + Application.BLOCK_SIZE - 1);
        g.drawLine(x + Application.BLOCK_SIZE - 1, y + Application.BLOCK_SIZE - 1,
                         x + Application.BLOCK_SIZE - 1, y + 1);
	}
}