package com.xt.chess;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Map;

import com.xt.game.ChessFrame;
import com.xt.game.GameUtil;
import com.xt.game.Point;

public class JiangShuai extends Chess{


	public JiangShuai(int camp, Point point) {
		super(camp, point);
	}

	@Override
	public boolean run(Point point, Map<Point, Chess> chess) {
		// 当前位置
		int m1 = this.point.m;
		int n1 = this.point.n;
		// 移动前位置
		int m2 = point.m;
		int n2 = point.n;
		// 基本走法
		boolean flag = (Math.abs(n1 - n2) == 1&&m1==m2) || (Math.abs(m1 - m2) == 1&&n1==n2);

		if (!flag) {
			return false;
		}
		boolean flag2 = (m1 >= 3 && m1 <= 5 && ((n1 >= 0 && n1 <= 2) || (n1 >= 7 && n1 <= 9)));// 判断是否走出格子
		if (!flag2) {
			return false;
		}
		// 判断目标位置是否有子
		Point thisPoint = null;
		Point NextPoint = null;
		System.out.println(point.m + " " + point.n + chess);
		if (this.isExist(chess)) {
			boolean isOneCamp = false;
			for (Point p : chess.keySet()) {
				for (Point p2 : chess.keySet()) {
					if (p.equals(p2) && p != p2) {
						thisPoint = p;
						NextPoint = p2;

						isOneCamp = chess.get(p).camp == chess.get(p2).camp;
					}
				}
			}
			if (isOneCamp) {
				System.out.println("====");
				return false;
			} else {
				eat(chess.get(thisPoint), chess.get(NextPoint), chess);
				return true;
			}
		}
		return true;

	}

	Image jiang = GameUtil.getImage("Image\\jiang.png");
	Image shuai = GameUtil.getImage("Image\\shuai.png");

	@Override
	public void draw(Graphics g) {
		if (camp > 0) {
			g.drawImage(jiang, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		} else {
			g.drawImage(shuai, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		}
	}


}
