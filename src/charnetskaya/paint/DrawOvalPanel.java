package charnetskaya.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawOvalPanel extends JPanel {

	private Canvas canvas;
	private JButton drawOval;

	public DrawOvalPanel(Canvas canvas) {
		this.canvas = canvas;

		this.drawOval = new JButton("Draw Oval");
		this.drawOval.addActionListener(new DrawOvalListener());
		this.add(drawOval);
	}

	private class DrawOvalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			OvalListener listener = new OvalListener();
			canvas.addMouseMotionListener(listener);
			canvas.addMouseListener(listener);

		}

	}

	private class OvalListener extends DrawingListener {
		private int x;
		private int y;
		private int x2;
		private int y2;

		public OvalListener() {
			this.removeListeners(canvas);
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX();
			y = e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			x2 = e.getX();
			y2 = e.getY();
			// canvas.DrawSquare(x, y, x2, y2);
			permanentDraw();
			// canvas.repaint();
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			this.x2 = e.getX();
			this.y2 = e.getY();
			//canvas.repaint();
			draw();

		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void draw(Graphics2D g2) {
			// TODO Auto-generated method stub
			g2.setColor(Color.black);
		
			int w = ((x - x2));
			int h = ((y - y2));

			if (w < 0 && h < 0) {
				g2.drawOval(x, y, -w, -h);
			} else if (w > 0 && h > 0) {
				g2.drawOval(x - w, y - h, w, h);
			} else if (w < 0 && h > 0) {
				g2.drawOval(x, y - h, -w, h);
			} else if (w > 0 && h < 0) {
				g2.drawOval(x - w, y, w, -h);
			}
			
			
		}

		@Override
		public void permanentDraw() {
			// TODO Auto-generated method stub
			Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
			g2.setColor(Color.black);
			int w = ((x - x2));
			int h = ((y - y2));

			if (w < 0 && h < 0) {
				g2.drawOval(x, y, -w, -h);
			} else if (w > 0 && h > 0) {
				g2.drawOval(x - w, y - h, w, h);
			} else if (w < 0 && h > 0) {
				g2.drawOval(x, y - h, -w, h);
			} else if (w > 0 && h < 0) {
				g2.drawOval(x - w, y, w, -h);
			}
			canvas.repaint();
		}

	}
}
