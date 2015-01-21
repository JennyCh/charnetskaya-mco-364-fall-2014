package charnetskaya.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

import charnetskaya.paint.Message.BucketFillMessage;

public class BucketFillListener implements DrawListenerInterface {

	private final Stack<Point> stack;
	private final Canvas canvas;
	private int x, y;

	public BucketFillListener(Canvas canvas, ToolPanel rightPanel) {
		// TODO Auto-generated constructor stub
		this.stack = new Stack<Point>();
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		final BufferedImage img = canvas.getImages().get(canvas.getActiveLayer());
		final Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setColor(canvas.getSettings().getColor());
		x = e.getX();
		y = e.getY();

		final Color initColor = new Color(img.getRGB(x, y), true);
		System.out.println(initColor.toString() + " " + initColor.getAlpha());

		/*
		 * same color was hit
		 */
		if (new Color(initColor.getRGB(), true).equals(new Color(g2.getColor().getRGB(), true))) {

		} else {
			boolean left, right;
			int tempY;

			stack.push(new Point(x, y));
			while (!stack.isEmpty()) {
				final Point p = stack.pop();
				final int activeX = (int) p.getX();
				final int activeY = (int) p.getY();

				tempY = activeY;

				while (tempY >= 0
						&& (new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX, tempY), true)))) {
					--tempY;

				}
				tempY++;

				left = right = false;
				final int width = img.getWidth();
				final int height = img.getHeight();

				while (tempY < height
						&& (new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX, tempY), true)))) {
					g2.drawLine(activeX, tempY, activeX, tempY);

					if (!left
							&& activeX > 0
							&& new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX - 1, tempY),
									true))) {
						stack.add(new Point(activeX - 1, tempY));
						left = true;
						// System.out.println("LEFT " + initColor + "==" + new
						// Color(img.getRGB(activeX - 1, tempY)));
					} else if (left
							&& activeX > 0
							&& !(new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX - 1, tempY),
									true)))) {
						left = false;
					}

					if (!right
							&& activeX < width - 1
							&& (new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX + 1, tempY),
									true)))) {

						stack.add(new Point(activeX + 1, tempY));
						right = true;
						// System.out.println("RIGHT " + initColor + "==" + new
						// Color(img.getRGB(activeX + 1, tempY)));
					} else if (right
							&& activeX < width - 1
							&& !(new Color(initColor.getRGB(), true).equals(new Color(img.getRGB(activeX + 1, tempY),
									true)))) {
						right = false;
					}
					tempY++;
				}
				// System.out.println(i++);
			}
		}
		canvas.repaint();
		if (canvas.getPaint().getRightPanel().getNetwork() != null) {
			canvas.getPaint().getRightPanel().getNetwork()
			.sendMessage(new BucketFillMessage(x, y, canvas.getSettings().getColor().getRGB(), canvas));

			//System.out.println("PASSING COLOR TO MESSAGE " + canvas.getSettings().getColor().getRGB());
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("ex5ted");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("released");

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("dragged");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("moved");
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void previewDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

}
