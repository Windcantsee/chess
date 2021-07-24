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
		// ��ǰλ��
		int m1 = this.point.m;
		int n1 = this.point.n;
		// �ƶ�ǰλ��
		int m2 = point.m;
		int n2 = point.n;
		// �����߷�
		boolean flag = (((n1 == n2) && (m1 != m2)) || ((m1 == m2) && (n1 != n2)));
		int num = 0;// ������Ӹ���
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
		// ����������>1����false
		if (num > 1) {
			return false;
		}
		// ����������Ϊ0���ж�Ŀ����������
		if (num == 0) {
			if (this.isExist(chess))
				return false;
		}
		// ����������Ϊ1���ж�Ŀ����������

		if (num == 1) {
			boolean flag2 = (m1 >= 0 && m1 <= 9 && n1 >= 0 && n1 <= 10);// �ж��Ƿ��߳�����
			if (!flag2) {
				return false;
			}

			// �ж�Ŀ��λ���Ƿ�����
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
			// ���Ŀ�������ӣ�����false
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
