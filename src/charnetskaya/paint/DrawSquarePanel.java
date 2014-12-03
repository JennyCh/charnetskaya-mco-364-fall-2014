package charnetskaya.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.api.Component;

public class DrawSquarePanel extends JPanel {

	private Canvas canvas;
	private JButton drawSquare;

	public DrawSquarePanel(Canvas canvas) {
		this.canvas = canvas;

		this.drawSquare = new JButton("Draw Square");
		this.drawSquare.addActionListener(new DrawSquareListener());
		this.add(drawSquare);
	}

	private class DrawSquareListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new SquareListener();

		}

	}

	private class SquareListener extends DrawingListener {

		private int x;
		private int y;
		private int x2;
		private int y2;

		public SquareListener() {

			this.removeListeners(canvas);
			canvas.addMouseListener(this);
			canvas.addMouseMotionListener(this);

		}

		public void mouseDragged(MouseEvent e) {
			// System.out.println("dragged");
			/*
			 * getting middle points
			 */

			this.x2 = e.getX();
			this.y2 = e.getY();

			canvas.repaint();
			draw();

		}

		@Override
		public void mouseMoved(MouseEvent arg0) {

			// System.out.println("moved");

		}

		@Override
		public void mouseClicked(MouseEvent e) {

			// System.out.println("clicked");
			/*
			 * getting initial point
			 */

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {

			// System.out.println("entered");

		}

		@Override
		public void mouseExited(MouseEvent arg0) {

			// System.out.println("exited");

		}

		@Override
		public void mousePressed(MouseEvent e) {

			// System.out.println("pressed");
			this.x = e.getX();
			this.y = e.getY();
			draw();
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			/*
			 * getting last points
			 */
			
			x2 = e.getX();
			y2 = e.getY();
			permanentDraw();

		}

		@Override
		public void draw() {

			// System.out.println("draw");
			Graphics2D g2 = (Graphics2D) canvas.getGraphics();
			g2.setColor(Color.black);

			int w = ((x - x2));
			int h = ((y - y2));

			if (w < 0 && h < 0) {
				g2.drawRect(x, y, -w, -h);
			} else if (w > 0 && h > 0) {
				g2.drawRect(x - w, y - h, w, h);
			} else if (w < 0 && h > 0) {
				g2.drawRect(x, y - h, -w, h);
			} else if (w > 0 && h < 0) {
				g2.drawRect(x - w, y, w, -h);
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
				g2.drawRect(x, y, -w, -h);
			} else if (w > 0 && h > 0) {
				g2.drawRect(x - w, y - h, w, h);
			} else if (w < 0 && h > 0) {
				g2.drawRect(x, y - h, -w, h);
			} else if (w > 0 && h < 0) {
				g2.drawRect(x - w, y, w, -h);
			}
			canvas.repaint();
		}

	}

}
