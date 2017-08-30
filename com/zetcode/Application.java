package com.zetcode;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.zetcode.ui.GameBoardPanel;
import com.zetcode.ui.LevelPanel;
import com.zetcode.ui.LineCountPanel;
import com.zetcode.ui.NextPanel;
import com.zetcode.ui.ScorePanel;
import com.zetcode.ui.StatisticsPanel;
import com.zetcode.ui.TopScorePanel;

public class Application extends JFrame {
	private static final long serialVersionUID = -5887797890828836114L;

	public static final int B_WIDTH = 10;
	public static final int B_HEIGHT = 20;
	public static final int BLOCK_SIZE = 30;
	
	public Application() {
		initUI();
	}
	
	private void initUI() {
		setLayout(new GridBagLayout());
		JPanel panel;
		GridBagConstraints c = new GridBagConstraints();
		
		
		panel = new TopScorePanel();
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		add(panel, c);
		
		panel = new LineCountPanel();
		c.weightx = 0;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		add(panel, c);
		
		panel = new ScorePanel();
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 0;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		add(panel, c);
		
		StatisticsPanel statisticsPanel = new StatisticsPanel();
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		add(statisticsPanel, c);
		
		NextPanel nextPanel = new NextPanel();
		
		panel = new GameBoardPanel(statisticsPanel, nextPanel);
		c.weightx = 0;
		c.weighty = 0;
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		add(panel, c);
		
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 2;
		c.gridy = 1;
		c.gridheight = 2;
		c.fill = GridBagConstraints.BOTH;
		add(nextPanel, c);
		
		panel = new LevelPanel();
		c.weightx = 0;
		c.weighty = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.NONE;
		add(panel, c);
		
		setSize(B_WIDTH * BLOCK_SIZE * 3, B_HEIGHT * BLOCK_SIZE + BLOCK_SIZE * 2 + BLOCK_SIZE / 2);
		setMinimumSize(new Dimension(B_WIDTH * BLOCK_SIZE + 44, B_HEIGHT * BLOCK_SIZE + 82));
		setResizable(false);
		
		setTitle("Tetris");
		setLocationRelativeTo(null); // center on screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Application app = new Application();
				app.setVisible(true);
			}
		});
	}
}
