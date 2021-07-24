package com.xt.game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.xt.chess.Chess;

@SuppressWarnings("serial")
public class ChessFrame extends Frame {
	public final static int lineSize = 50;// 离边际的距离
	public final static int size = 60;// 格子间距
	public final static int height = 9 * size + 2 * lineSize;
	public final static int width = 8 * size + 2 * lineSize;
	private Map<Point, Chess> chess = new HashMap<>();// 棋子集合

	public void launchFrame() {

		setSize(width, height);
		setLocation(30, 30);
		setVisible(true);

		addMouseListener(new mousec());
		addMouseMotionListener(new mousec());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	private Image Ibuffered;
	private Graphics Gbuffered;
	private SetChess setChess;
	{
		setChess = new SetChess(chess);// 初始化旗子
	}

	public void paint(Graphics g) {
		if (Ibuffered == null) {
			Ibuffered = createImage(width, height);
			Gbuffered = Ibuffered.getGraphics();
		}
		Gbuffered.setColor(Color.gray);
		Gbuffered.fillRect(0, 0, width, height);
		Gbuffered.setColor(Color.black);

		setChess.draw(Gbuffered, chess);

		g.drawImage(Ibuffered, 0, 0, null);
	}

	public void update(Graphics g) {
		paint(g);
	}

	// 参数，参与鼠标按键的逻辑语句
	Chess c;
	Point p;
	Move move;

	class mousec implements MouseMotionListener, MouseListener {
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		int turn = 1;

		@Override
		public void mousePressed(MouseEvent e) {
			double x = e.getX();
			double y = e.getY();
			move = new Move(chess);
			c = move.orderChess(new Point(x, y));// 判断该位置是否有子，返回旗子（若无返回null）
			if (c != null && c.camp == turn) {

				p = c.point;
			} else {
				c = null;
				move = null;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			double x = e.getX();
			double y = e.getY();

			if (c != null) {
				// 判断下子是否有效
				if (move != null && p != null) {
					if (!move.run(p, chess)) {
						// 移回原始位置
						chess.remove(p);
						chess.remove(c.point);
						c.point = p;

						chess.put(p, c);
					} else {
						turn *= -1;
					}
				}
				// 归零棋子hash值
				chess.remove(c.point);
				c.point.hash = 0;
				chess.put(c.point, c);
				Iterator<Point> it = chess.keySet().iterator();
				while (it.hasNext()) {

					if (it.next().hash == 1)
						it.remove();
				}

				// 校正旗子位置（格线中心）
				c.point = new Point(c.point.m, c.point.n);
				chess.remove(c.point);
				chess.put(c.point, c);
				repaint();
			}
			c = null;
			Finish.win(chess);
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (c != null) {
				chess.remove(c.point);
				double x = e.getX();
				double y = e.getY();
				c.point = new Point(x, y);
				c.point.hash = 1;
				chess.put(c.point, c);
				repaint();
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}
	}

}
