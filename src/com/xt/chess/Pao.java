package com.xt.chess;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Collection;
import java.util.Map;

import com.xt.game.ChessFrame;
import com.xt.game.GameUtil;
import com.xt.game.Point;

public class Pao extends Chess {

	public Pao(int camp, Point point) {
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
		boolean flag = (((n1 == n2) && (m1 != m2)) || ((m1 == m2) && (n1 != n2)));
		int num = 0;// 间隔棋子个数
		if (!flag) {
			return false;
		}
		if (m1 == m2) {

			for (int i = n1;;) {
				if (i == n2)
					break;
				i += (n2 - n1) / Math.abs(n2 - n1);
				if (this.isExist(new Point(m1, i), chess)) {
					num++;
				}
			}
		}
		
		if (n1 == n2) {
			for (int i = m1;;) {
				if (i == m2)
					break;
				i += (m2 - m1) / Math.abs(m2 - m1);
				if (this.isExist(new Point(i, n2), chess)) {
					num++;
				}
			}
		}
		// 如果间隔棋子>1返回false
		if (num > 1) {
			return false;
		}
		// 如果间隔旗子为0，判断目标有无旗子
		if (num == 0) {
			if (this.isExist(chess))
				return false;
		}
		// 如果间隔旗子为1，判断目标有无旗子

		if (num == 1) {
			boolean flag2 = (m1 >= 0 && m1 <= 9 && n1 >= 0 && n1 <= 10);// 判断是否走出格子
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
					return false;
				} else {
					eat(chess.get(thisPoint), chess.get(NextPoint), chess);
					return true;
				}
			}
			// 如果目标无棋子，返回false
			return false;
		}
		return true;
	}

	Image pao1 = GameUtil.getImage("Image\\pao1.png");
	Image pao2 = GameUtil.getImage("Image\\pao2.png");

	@Override
	public void draw(Graphics g) {
		if (camp > 0) {
			g.drawImage(pao1, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		} else {
			g.drawImage(pao2, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		}
	}

}
