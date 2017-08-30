package com.zetcode.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.zetcode.Application;
import com.zetcode.tetromino.Block;
import com.zetcode.tetromino.Tetromino;
import com.zetcode.tetromino.TetrominoFactory;

public class GameBoardPanel extends BorderedPanel implements Runnable {

	private static final long serialVersionUID = 3334467382926295551L;
	
	private static final int INPUT_DELAY = 30;
	
	private long lastDrop;
	private long speedDelay = 1000;
	private Thread animator;
	
	private TetrominoFactory tetrominoFactory = new TetrominoFactory();
	private Tetromino currentPiece;
	private Tetromino nextPiece;
	private Block[][] pile;
	
	private NextPanel nextPanel;
	private StatisticsPanel statisticsPanel;
	
	public GameBoardPanel(StatisticsPanel sp, NextPanel np) {
		this.statisticsPanel = sp;
		this.nextPanel = np;
		
		initBoard();
	}
	
	private void initBoard() {
		setPreferredSize(new Dimension(Application.B_WIDTH * Application.BLOCK_SIZE, Application.B_HEIGHT * Application.BLOCK_SIZE));
		addKeyListener(new TAdapter());
		setBackground(Color.BLACK);
		setFocusable(true);
		
		// initialize an empty pile
		pile = new Block[Application.B_WIDTH][Application.B_HEIGHT];
		for (int i = 0; i < Application.B_WIDTH; ++i) {
			for (int j = 0; j < Application.B_HEIGHT; ++j) {
				pile[i][j] = null;
			}
		}
		
		lastDrop = System.currentTimeMillis();
		
		// set initial current piece and next piece
		currentPiece = tetrominoFactory.create();
		nextPiece = tetrominoFactory.create();
		nextPanel.setNext(nextPiece);
		statisticsPanel.updateCount(currentPiece);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintGameBoard(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void paintGameBoard(Graphics g) {
		// paint current piece
		currentPiece.paintComponent(g);
		
		// paint pile
		for (int i = 0; i < Application.B_WIDTH; ++i) {
			for (int j = 0; j < Application.B_HEIGHT; ++j) {
				if (pile[i][j] != null) {
					pile[i][j].paintComponent(g);
				}
			}
		}
	}
	
	@Override
	public void addNotify() {
		super.addNotify();
		
		animator = new Thread(this);
		animator.start();
	}
	
	private void createNewTetromino() {
		currentPiece = nextPiece;
		statisticsPanel.updateCount(currentPiece);
		nextPiece = tetrominoFactory.create();
		nextPanel.setNext(nextPiece);
	}
	
	private void updateTetromino() {
		if ((System.currentTimeMillis() - lastDrop) > speedDelay) {
			for (Block b : currentPiece.getBlocks()) {
				// check pile
				if (b.getY() > 0 && b.getY() < (Application.B_HEIGHT - 1) && pile[b.getX()][b.getY() + 1] != null) {
					addToPile(currentPiece);
					createNewTetromino();
					return;
				}
			
				// check floor
				if ((b.getY() * Application.BLOCK_SIZE + Application.BLOCK_SIZE) >= Application.B_HEIGHT * Application.BLOCK_SIZE) {
					addToPile(currentPiece);
					createNewTetromino();
					return;
				}
			}
			currentPiece.moveDown();
			lastDrop = System.currentTimeMillis();
		}
	}
	
	private void addToPile(Tetromino t) {
		for (Block b : t.getBlocks()) {
			pile[b.getX()][b.getY()] = b;
		}
	}
	
	@Override
	public void run() {
		long startTime, timeDiff, sleep;
		
		startTime = System.currentTimeMillis();
		
		while (true) {
			
			// check for collisions with walls, floor, or pile
			// if collisions with floor or pile, then add to pile and start over
			updateTetromino();
			
			repaint();
			
			timeDiff = System.currentTimeMillis() - startTime;
			sleep = INPUT_DELAY - timeDiff;
			
			if (sleep < 0) {
				sleep = 2;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			startTime = System.currentTimeMillis();
		}
	}
	
	private class TAdapter extends KeyAdapter {
		@Override
        public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			boolean isClear = true;
			
			if (key == KeyEvent.VK_LEFT) {
				for (Block b : currentPiece.getBlocks()) {
					// check wall
					if (b.getX() < 1) {
						isClear = false;
					}
					
					// check pile @TODO
				}
				if (isClear) {
					currentPiece.moveLeft();
				}
			}
			
			if (key == KeyEvent.VK_RIGHT) {
				for (Block b : currentPiece.getBlocks()) {
					// check wall
					if ((b.getX() * Application.BLOCK_SIZE + Application.BLOCK_SIZE) >= Application.B_WIDTH * Application.BLOCK_SIZE) {
						isClear = false;
					}
					
					// check pile @TODO
				}
				if (isClear) {
					currentPiece.moveRight();
				}
			}
			
			if (key == KeyEvent.VK_DOWN) {
				for (Block b : currentPiece.getBlocks()) {
					// check pile
					if (b.getY() > 0 && b.getY() < (Application.B_HEIGHT - 1) && pile[b.getX()][b.getY() + 1] != null) {
						addToPile(currentPiece);
						createNewTetromino();
						isClear = false;
					}
					
					// check floor
					if ((b.getY() * Application.BLOCK_SIZE + Application.BLOCK_SIZE) >= Application.B_HEIGHT * Application.BLOCK_SIZE) {
						isClear = false;
					}
				}
				if (isClear) {
					currentPiece.moveDown();
				}
			}
			
			if (key == KeyEvent.VK_SPACE) {
				// check pile @TODO
				// check wall @TODO
				// check floor @TODO
				currentPiece.rotate();
			}
        }
	}
}
