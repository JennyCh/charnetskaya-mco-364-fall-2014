package charnetskaya.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFillListener implements DrawListenerInterface {

	private final Point initialPoint;
	private final Queue<Point> stack;
	private final Canvas canvas;

	public BucketFillListener(Canvas canvas) {
		// TODO Auto-generated constructor stub
		this.stack = new LinkedList<Point>();
		this.initialPoint = new Point();
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.initialPoint.x = e.getX();
		this.initialPoint.y = e.getY();

		final BufferedImage img = canvas.getImage();
		final Color color = new Color(img.getRGB(initialPoint.x, initialPoint.y));
		final Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setColor(Color.red);

		stack.add(initialPoint);
		while (!stack.isEmpty()) {

			// System.out.println("size " + stack.size());
			/*
			 * final Iterator<Point> iter = stack.iterator(); while
			 * (iter.hasNext()) { System.out.println(iter.next().toString()); }
			 */
			final Point initialPoint = stack.poll();
			// System.out.println("\ncurrent point" + initialPoint);
			final Point leftPoint = new Point(initialPoint.x - 1, initialPoint.y);
			final Point rightPoint = new Point(initialPoint.x + 1, initialPoint.y);
			final Point topPoint = new Point(initialPoint.x, initialPoint.y - 1);
			final Point bottomPoint = new Point(initialPoint.x, initialPoint.y + 1);

			final Color bottomPointColor = new Color(img.getRGB(initialPoint.x, initialPoint.y + 1));
			final Color topPointColor = new Color(img.getRGB(initialPoint.x, initialPoint.y - 1));
			final Color leftPointColor = new Color(img.getRGB(initialPoint.x - 1, initialPoint.y));
			final Color rightPointColor = new Color(img.getRGB(initialPoint.x + 1, initialPoint.y));
			// System.out.println(bottomPointColor + " " + topPointColor + " " +
			// leftPointColor + " " + rightPointColor);

			if (Color.white.equals(bottomPointColor)) {
				// System.out.println("b pass");
				stack.add(bottomPoint);
			}
			if (Color.white.equals(topPointColor)) {
				// System.out.println("t pass");
				stack.add(topPoint);
			}

			if (Color.white.equals(leftPointColor)) {
				// System.out.println("l pass");
				stack.add(leftPoint);
			}

			if (Color.white.equals(rightPointColor)) {
				// System.out.println("r pass");
				stack.add(rightPoint);
			}

			g2.drawLine(initialPoint.x, initialPoint.y, initialPoint.x, initialPoint.y);
			canvas.repaint();
		}

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preview(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

}
