package charnetskaya.paint.Message;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import charnetskaya.paint.Canvas;

public class BucketFillMessage implements PaintMessage {

	private int x, y;
	private int color;
	private final Canvas canvas;
	private final BufferedImage image;

	@Override
	public void apply(Graphics2D g2) {
		// TODO Auto-generated method stub
		fill();
	}

	public BucketFillMessage(int x, int y, int color, Canvas canvas) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.image = canvas.getImages().get(canvas.getActiveLayer());
		this.canvas = canvas;
	}

	public void fill() {

		final BufferedImage img = canvas.getImages().get(canvas.getActiveLayer());
		final Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setColor(new Color(color));
		final Stack<Point> stack = new Stack<Point>();

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
		/*
		 * final Stack<Point> stack = new Stack<Point>(); final Color initColor
		 * = new Color(image.getRGB(x, y)); boolean left, right; int tempY;
		 * 
		 * stack.push(new Point(x, y));
		 * 
		 * // final int i = 1; while (!stack.isEmpty()) { final Point p =
		 * stack.pop(); final int activeX = (int) p.getX(); final int activeY =
		 * (int) p.getY();
		 * 
		 * tempY = activeY; while (tempY >= 0 && initColor.equals((new
		 * Color(image.getRGB(activeX, tempY))))) { --tempY; } tempY++;
		 * 
		 * left = right = false; final int width = image.getWidth(); final int
		 * height = image.getHeight();
		 * 
		 * while (tempY < height && initColor.equals(new
		 * Color(image.getRGB(activeX, tempY)))) { image.setRGB(x, tempY,
		 * color); canvas.repaint();
		 * 
		 * if (!left && activeX > 0 && initColor.equals(new
		 * Color(image.getRGB(activeX - 1, tempY)))) { stack.add(new
		 * Point(activeX - 1, tempY)); left = true; } else if (left && activeX >
		 * 0 && !initColor.equals(new Color(image.getRGB(activeX - 1, tempY))))
		 * { left = false; }
		 * 
		 * if (!right && activeX < width - 1 && initColor.equals(new
		 * Color(image.getRGB(activeX + 1, tempY)))) { stack.add(new
		 * Point(activeX + 1, tempY)); right = true; } else if (right && activeX
		 * < width - 1 && !initColor.equals(new Color(image.getRGB(activeX + 1,
		 * tempY)))) { right = false; } tempY++; } } canvas.repaint();
		 */
	}

	@Override
	public String toString() {
	//	System.out.println("BUCKET_FILL" + " " + x + " " + y + " " + color + "\n");
		return "BUCKET_FILL" + " " + x + " " + y + " " + color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
