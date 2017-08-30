package com.zetcode.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import com.zetcode.Application;
import com.zetcode.tetromino.I;
import com.zetcode.tetromino.J;
import com.zetcode.tetromino.L;
import com.zetcode.tetromino.O;
import com.zetcode.tetromino.S;
import com.zetcode.tetromino.T;
import com.zetcode.tetromino.Tetromino;
import com.zetcode.tetromino.Z;

public class StatisticsPanel extends BorderedPanel {

	private static final long serialVersionUID = 9071804654717083057L;
	
	private int iCount = 0;
	private int jCount = 0;
	private int lCount = 0;
	private int oCount = 0;
	private int sCount = 0;
	private int tCount = 0;
	private int zCount = 0;
	
	public StatisticsPanel() {
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		String text = "Statistics";
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
        
        // change the font size for the tetromino counts
        font = new Font("Arial", Font.BOLD, 48);
        g2d.setFont(font);
        g2d.setColor(Color.RED);
        
        Tetromino t = new T();
        t.position(-3, 3);
        t.paintComponent(g2d);
        g2d.setColor(Color.RED);
        x += (Application.BLOCK_SIZE * 3);
        y += (Application.BLOCK_SIZE / 2 + Application.BLOCK_SIZE);
        g2d.drawString(String.format("%03d", tCount), x, y);
        
        Tetromino j = new J();
        j.position(-3, 6);
        j.rotate(3);
        j.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", jCount), x, y);
        
        Tetromino z = new Z();
        z.position(-3, 9);
        z.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", zCount), x, y);

        Tetromino o = new O();
        o.position(-2, 12);
        o.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", oCount), x, y);
        
        Tetromino s = new S();
        s.position(-3, 15);
        s.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", sCount), x, y);
        
        Tetromino l = new L();
        l.position(-2, 18);
        l.rotate();
        l.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", lCount), x, y);
        
        Tetromino i = new I();
        i.rotate();
        i.position(-2, 21);
        i.paintComponent(g2d);
        g2d.setColor(Color.RED);
        y += (Application.BLOCK_SIZE * 3);
        g2d.drawString(String.format("%03d", iCount), x, y);
	}
	
	public void updateCount(Tetromino t) {
		if (t instanceof I) {
			iCount++;
		} else if (t instanceof J) {
			jCount++;
		} else if (t instanceof L) {
			lCount++;
		} else if (t instanceof O) {
			oCount++;
		} else if (t instanceof S) {
			sCount++;
		} else if (t instanceof T) {
			tCount++;
		} else if (t instanceof Z) {
			zCount++;
		}
		
		repaint();
	}
}
