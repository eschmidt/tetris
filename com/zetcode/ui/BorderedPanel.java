package com.zetcode.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class BorderedPanel extends JPanel {

	private static final long serialVersionUID = 7201767198796782855L;

	public BorderedPanel() {
		initPanel();
	}
	
	private void initPanel() {
		setBackground(Color.BLACK);
		Border raised = BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.WHITE.brighter(), Color.WHITE.darker());
		Border lowered = BorderFactory.createSoftBevelBorder(BevelBorder.LOWERED, Color.WHITE.darker(), Color.WHITE.brighter());
		setBorder(BorderFactory.createCompoundBorder(raised, lowered));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	protected void paintCenteredText(Graphics g, String text) {
		Graphics2D g2d = (Graphics2D) g.create();

        FontRenderContext context = g2d.getFontRenderContext();
        Font font = new Font("Arial", Font.BOLD, 18);
        TextLayout txt = new TextLayout(text, font, context);

        Rectangle2D bounds = txt.getBounds();
        int x = (int) ((getWidth() - (int) bounds.getWidth()) / 2);
        int y = (int) ((getHeight() - (bounds.getHeight() - txt.getDescent())) / 2);
        y += txt.getAscent() - txt.getDescent();

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);

        g2d.dispose();
		
		repaint();
	}
}
