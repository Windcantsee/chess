package com.xt.chess;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Map;

import com.xt.game.ChessFrame;
import com.xt.game.GameUtil;
import com.xt.game.Point;

public class Xiang extends Chess{


	public Xiang(int camp, Point point) {
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
		boolean flag = (Math.abs(n1 - n2) == 2) && (Math.abs(m1 - m2) == 2);
		
		if (!flag) {
			return false;
		}
		boolean flag2 = (m1 >= 0 && m1 < 9 && (n1>=this.camp*2.5+2.5)&&(n1<=this.camp*2.5+6.5));// 判断是否走出格子
		if (!flag2) {
			return false;
		}
		if(isExist(new Point((m1+m2)/2,(n1+n2)/2), chess)){
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
		return true;

	}

	Image xiang1 = GameUtil.getImage("Image\\xiang1.png");
	Image xiang2 = GameUtil.getImage("Image\\xiang2.png");

	@Override
	public void draw(Graphics g) {
		if (camp > 0) {
			g.drawImage(xiang1, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		} else {
			g.drawImage(xiang2, (int) (point.x - ChessFrame.size / 2),
					(int) (point.y - ChessFrame.size / 2), ChessFrame.size,
					ChessFrame.size, null);
		}
	}


}
