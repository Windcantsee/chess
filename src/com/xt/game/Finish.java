package com.xt.game;

import java.util.Iterator;
import java.util.Map;

import com.xt.chess.Chess;
import com.xt.chess.JiangShuai;

public class Finish {
	
	public static void win(Map<Point ,Chess> chess){
		int num=0;
		Iterator<Chess> it = chess.values().iterator();
		while(it.hasNext()){
			if(it.next() instanceof JiangShuai  ){
				num++;
			}
		}
		if(num<2)
			System.exit(1);
				
	}
}
