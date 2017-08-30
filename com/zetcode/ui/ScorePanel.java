package com.zetcode.ui;

import java.awt.Graphics;

public class ScorePanel extends BorderedPanel {
	
	private static final long serialVersionUID = 3045980913216510833L;
	
	private int score = 0;
	
	public ScorePanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		paintScore(g);
	}
	
	private void paintScore(Graphics g) {
		paintCenteredText(g, "Score: " + score);
	}
}
