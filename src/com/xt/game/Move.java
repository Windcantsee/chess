package com.xt.game;

import java.util.Map;

import com.xt.chess.Chess;

public class Move {
	Map<Point, Chess> chess;
	Chess c;

	public Move(Map<Point, Chess> chess) {
		this.chess = chess;

	}

	// 选中旗子
	public Chess orderChess(Point point) {
		for (Point p : chess.keySet()) {
			if (p.equals(point)) {
				c = chess.get(p);
				return chess.get(p);
			}
		}
		return null;
	}

	// 主程序
	public boolean run(Point point, Map<Point, Chess> chess) {
		return c.run(point, chess);
	}
}
