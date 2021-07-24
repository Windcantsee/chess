package com.xt.chess;

import java.awt.Graphics;
import java.util.Map;

import com.xt.game.Point;

public abstract class Chess {
	public Point point;
	public final int camp;

	public Chess(int camp, Point point) {
		this.camp = camp;
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}
	
	public abstract boolean run(Point point,Map<Point,Chess> chess);
	public abstract void draw(Graphics g);
	//�ж�Ŀ���λ�Ƿ��������
	public boolean isExist(Point point,Map<Point,Chess> chess){
		for(Point p :chess.keySet()){
			if(p.equals(point))
				return true;
		}
		return false;
	}
	public boolean isExist(Map<Point,Chess> chess){
		for(Point p :chess.keySet()){
			for(Point p2:chess.keySet()){
				if(p.equals(p2)&&p.hash!=p2.hash)
					return true;
			}
		}
		return false;
	}
	public void eat(Chess doEat, Chess beEat, Map<Point, Chess> chess) {
		beEat.point.hash=0;
		chess.put(beEat.point, doEat);
		doEat.point = beEat.point;
		chess.remove(doEat);
	}

	@Override
	public String toString() {
		return "Chess [point=" + point.m+","+point.n + ","+point.hash+"]";
	}
}
