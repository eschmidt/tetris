package com.zetcode.ui;

import java.awt.Graphics;

public class TopScorePanel extends BorderedPanel {
	private static final long serialVersionUID = 366419071242792270L;

	private int topScore = 0;
	
	public TopScorePanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		paintTopScore(g);
	}
	
	private void paintTopScore(Graphics g) {
		paintCenteredText(g, "Top Score: " + topScore);
	}
}
