package com.zetcode.ui;

import java.awt.Dimension;
import java.awt.Graphics;

import com.zetcode.Application;

public class LineCountPanel extends BorderedPanel {

	private static final long serialVersionUID = -1130835165910965492L;

	private int lines = 0;
	
	public LineCountPanel() {
		setPreferredSize(new Dimension(Application.B_WIDTH * Application.BLOCK_SIZE, Application.BLOCK_SIZE));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		paintLineCount(g);
	}
	
	private void paintLineCount(Graphics g) {
		paintCenteredText(g, "Lines: " + lines);
	}
}
