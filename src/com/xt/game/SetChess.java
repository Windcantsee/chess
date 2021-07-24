package com.xt.game;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Map;

import com.xt.chess.Bing;
import com.xt.chess.Chess;
import com.xt.chess.JiangShuai;
import com.xt.chess.Ju;
import com.xt.chess.Ma;
import com.xt.chess.Pao;
import com.xt.chess.Shi;
import com.xt.chess.Xiang;

public class SetChess {

	public SetChess(Map<Point, Chess> chess) {

		/**
		 * ***********************旗子初始化**************************
		 */
		/*
		 * 敌方
		 */
		// 士
		chess.put(new Point(3, 0), new Shi(-1, new Point(3, 0)));
		chess.put(new Point(5, 0), new Shi(-1, new Point(5, 0)));
		// 象
		chess.put(new Point(2, 0), new Xiang(-1, new Point(2, 0)));
		chess.put(new Point(6, 0), new Xiang(-1, new Point(6, 0)));
		// 马
		chess.put(new Point(1, 0), new Ma(-1, new Point(1, 0)));
		chess.put(new Point(7, 0), new Ma(-1, new Point(7, 0)));
		// 车
		chess.put(new Point(0, 0), new Ju(-1, new Point(0, 0)));
		chess.put(new Point(8, 0), new Ju(-1, new Point(8, 0)));
		// 兵
		chess.put(new Point(0, 3), new Bing(-1, new Point(0, 3)));
		chess.put(new Point(2, 3), new Bing(-1, new Point(2, 3)));
		chess.put(new Point(4, 3), new Bing(-1, new Point(4, 3)));
		chess.put(new Point(6, 3), new Bing(-1, new Point(6, 3)));
		chess.put(new Point(8, 3), new Bing(-1, new Point(8, 3)));
		// 炮
		chess.put(new Point(1, 2), new Pao(-1, new Point(1, 2)));
		chess.put(new Point(7, 2), new Pao(-1, new Point(7, 2)));
		// 帅
		chess.put(new Point(4, 0), new JiangShuai(-1, new Point(4, 0)));
		/*
		 * 我方
		 */
		// 将
		chess.put(new Point(4, 9), new JiangShuai(1, new Point(4, 9)));
		// 士
		chess.put(new Point(3, 9), new Shi(1, new Point(3, 9)));
		chess.put(new Point(5, 9), new Shi(1, new Point(5, 9)));
		// 象
		chess.put(new Point(2, 9), new Xiang(1, new Point(2, 9)));
		chess.put(new Point(6, 9), new Xiang(1, new Point(6, 9)));
		// 马
		chess.put(new Point(1, 9), new Ma(1, new Point(1, 9)));
		chess.put(new Point(7, 9), new Ma(1, new Point(7, 9)));
		// 车
		chess.put(new Point(0, 9), new Ju(1, new Point(0, 9)));
		chess.put(new Point(8, 9), new Ju(1, new Point(8, 9)));
		// 兵
		chess.put(new Point(0, 6), new Bing(1, new Point(0, 6)));
		chess.put(new Point(2, 6), new Bing(1, new Point(2, 6)));
		chess.put(new Point(4, 6), new Bing(1, new Point(4, 6)));
		chess.put(new Point(6, 6), new Bing(1, new Point(6, 6)));
		chess.put(new Point(8, 6), new Bing(1, new Point(8, 6)));
		// 炮
				chess.put(new Point(1, 7), new Pao(1, new Point(1, 7)));
				chess.put(new Point(7, 7), new Pao(1, new Point(7, 7)));

	}

	public void draw(Graphics g, Map<Point, Chess> chess) {

		/**
		 * 边际线
		 */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 9; j++) {

				g.drawLine(i * ChessFrame.size + ChessFrame.lineSize, j
						* ChessFrame.size + ChessFrame.lineSize, (i + 1)
						* ChessFrame.size + ChessFrame.lineSize, j
						* ChessFrame.size + ChessFrame.lineSize);
				if (j == 4 && i > 0)
					continue;
				g.drawLine(i * ChessFrame.size + ChessFrame.lineSize, j
						* ChessFrame.size + ChessFrame.lineSize, i
						* ChessFrame.size + ChessFrame.lineSize, (j + 1)
						* ChessFrame.size + ChessFrame.lineSize);

			}
		}
		g.drawLine(ChessFrame.width - ChessFrame.lineSize, ChessFrame.lineSize,
				ChessFrame.width - ChessFrame.lineSize, ChessFrame.height
						- ChessFrame.lineSize);
		g.drawLine(ChessFrame.lineSize,
				ChessFrame.height - ChessFrame.lineSize, ChessFrame.width
						- ChessFrame.lineSize, ChessFrame.height
						- ChessFrame.lineSize);
		// 楚河 汉界
		Graphics g2 = g;
		g2.setFont(new Font("s", 2, ChessFrame.size));
		g2.drawString("楚河", ChessFrame.lineSize * 2, ChessFrame.size * 9 / 2
				+ ChessFrame.lineSize * 3 / 2);
		g2.drawString("汉界", ChessFrame.width * 7 / 9 - ChessFrame.lineSize * 2,
				ChessFrame.size * 9 / 2 + ChessFrame.lineSize * 3 / 2);
		g2 = g;

		/**
		 * 九宫格
		 */
		g.drawLine(ChessFrame.width / 2 - ChessFrame.size, ChessFrame.lineSize,
				ChessFrame.width / 2 + ChessFrame.size, ChessFrame.size * 2
						+ ChessFrame.lineSize);
		g.drawLine(ChessFrame.width / 2 - ChessFrame.size, ChessFrame.size * 2
				+ ChessFrame.lineSize, ChessFrame.width / 2 + ChessFrame.size,
				ChessFrame.lineSize);
		g.drawLine(ChessFrame.width / 2 - ChessFrame.size, ChessFrame.height
				- ChessFrame.lineSize, ChessFrame.width / 2 + ChessFrame.size,
				ChessFrame.height - ChessFrame.size * 2 - ChessFrame.lineSize);
		g.drawLine(ChessFrame.width / 2 - ChessFrame.size, ChessFrame.height
				- ChessFrame.size * 2 - ChessFrame.lineSize, ChessFrame.width
				/ 2 + ChessFrame.size, ChessFrame.height - ChessFrame.lineSize);

		int space = ChessFrame.size / 12;
		// *********************************BING*********************************
		// upright corner
		for (int j = 3; j < 7; j += 3) {
			for (int i = 0; i < 8; i += 2) {
				g.drawPolyline(new int[] {
						ChessFrame.lineSize + i * ChessFrame.size + space,
						ChessFrame.lineSize + i * ChessFrame.size + space,
						(int) (ChessFrame.lineSize + (i + 0.5)
								* ChessFrame.size - space) }, new int[] {
						(int) (ChessFrame.lineSize + (j - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + j * ChessFrame.size - space,
						ChessFrame.lineSize + j * ChessFrame.size - space }, 3);
			}
		}
		// downright corner
		for (int j = 3; j < 7; j += 3) {
			for (int i = 0; i < 8; i += 2) {
				g.drawPolyline(new int[] {
						ChessFrame.lineSize + i * ChessFrame.size + space,
						ChessFrame.lineSize + i * ChessFrame.size + space,
						(int) (ChessFrame.lineSize + (i + 0.5)
								* ChessFrame.size - space) }, new int[] {
						(int) (ChessFrame.lineSize + (j + 0.5)
								* ChessFrame.size - space),
						ChessFrame.lineSize + j * ChessFrame.size + space,
						ChessFrame.lineSize + j * ChessFrame.size + space }, 3);
			}
		}
		// upleft corner
		for (int j = 3; j < 7; j += 3) {
			for (int i = 2; i < 9; i += 2) {
				g.drawPolyline(new int[] {
						(int) (ChessFrame.lineSize + (i - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + i * ChessFrame.size - space,
						ChessFrame.lineSize + i * ChessFrame.size - space },
						new int[] {
								ChessFrame.lineSize + j * ChessFrame.size
										- space,
								ChessFrame.lineSize + j * ChessFrame.size
										- space,
								(int) (ChessFrame.lineSize + (j - 0.5)
										* ChessFrame.size + space) }, 3);
			}
		}
		// downleft corner
		for (int j = 3; j < 7; j += 3) {
			for (int i = 2; i < 9; i += 2) {
				g.drawPolyline(new int[] {
						(int) (ChessFrame.lineSize + (i - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + i * ChessFrame.size - space,
						ChessFrame.lineSize + i * ChessFrame.size - space },
						new int[] {
								ChessFrame.lineSize + j * ChessFrame.size
										+ space,
								ChessFrame.lineSize + j * ChessFrame.size
										+ space,
								(int) (ChessFrame.lineSize + (j + 0.5)
										* ChessFrame.size - space) }, 3);
			}
		}
		// ***********************************PAO********************************
		// upright
		for (int j = 2; j < 9; j += 5) {
			for (int i = 1; i < 8; i += 6) {
				g.drawPolyline(new int[] {
						ChessFrame.lineSize + i * ChessFrame.size + space,
						ChessFrame.lineSize + i * ChessFrame.size + space,
						(int) (ChessFrame.lineSize + (i + 0.5)
								* ChessFrame.size - space) }, new int[] {
						(int) (ChessFrame.lineSize + (j - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + j * ChessFrame.size - space,
						ChessFrame.lineSize + j * ChessFrame.size - space }, 3);
			}
		}
		// downright
		for (int j = 2; j < 9; j += 5) {
			for (int i = 1; i < 8; i += 6) {
				g.drawPolyline(new int[] {
						ChessFrame.lineSize + i * ChessFrame.size + space,
						ChessFrame.lineSize + i * ChessFrame.size + space,
						(int) (ChessFrame.lineSize + (i + 0.5)
								* ChessFrame.size - space) }, new int[] {
						(int) (ChessFrame.lineSize + (j + 0.5)
								* ChessFrame.size - space),
						ChessFrame.lineSize + j * ChessFrame.size + space,
						ChessFrame.lineSize + j * ChessFrame.size + space }, 3);
			}
		}
		// upleft
		for (int j = 2; j < 9; j += 5) {
			for (int i = 1; i < 8; i += 6) {
				g.drawPolyline(new int[] {
						(int) (ChessFrame.lineSize + (i - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + i * ChessFrame.size - space,
						ChessFrame.lineSize + i * ChessFrame.size - space },
						new int[] {
								ChessFrame.lineSize + j * ChessFrame.size
										- space,
								ChessFrame.lineSize + j * ChessFrame.size
										- space,
								(int) (ChessFrame.lineSize + (j - 0.5)
										* ChessFrame.size + space) }, 3);
			}
		}
		// downleft
		for (int j = 2; j < 9; j += 5) {
			for (int i = 1; i < 8; i += 6) {
				g.drawPolyline(new int[] {
						(int) (ChessFrame.lineSize + (i - 0.5)
								* ChessFrame.size + space),
						ChessFrame.lineSize + i * ChessFrame.size - space,
						ChessFrame.lineSize + i * ChessFrame.size - space },
						new int[] {
								ChessFrame.lineSize + j * ChessFrame.size
										+ space,
								ChessFrame.lineSize + j * ChessFrame.size
										+ space,
								(int) (ChessFrame.lineSize + (j + 0.5)
										* ChessFrame.size - space) }, 3);
			}
		}

		for (Chess c : chess.values()) {

			c.draw(g);
		}

	}
}
