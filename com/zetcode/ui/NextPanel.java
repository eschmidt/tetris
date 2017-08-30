package com.zetcode.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import com.zetcode.tetromino.Tetromino;

public class NextPanel extends BorderedPanel {
	
	private static final long serialVersionUID = 4361632840426695769L;

	private Tetromino next = null;
	
	public NextPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String text = "Next";
		
		Graphics2D g2d = (Graphics2D) g.create();

        FontRenderContext context = g2d.getFontRenderContext();
        Font font = new Font("Arial", Font.BOLD, 28);
        TextLayout txt = new TextLayout(text, font, context);

        Rectangle2D bounds = txt.getBounds();
        int x = (int) ((getWidth() - (int) bounds.getWidth()) / 2);
        int y = (int) (txt.getAscent() - txt.getDescent()) + 10;

        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        g2d.drawString(text, x, y);
        
        if (next != null) {
            next.position(0, 6);
            next.paintComponent(g2d);
        }
	}
	
	public void setNext(Tetromino t) {
		next = t;
		repaint();
	}
}
