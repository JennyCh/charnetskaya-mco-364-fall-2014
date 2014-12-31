package charnetskaya.paint.Message;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {

	private ShapeType shape;
	private int x, y, width, height;
	private int color;
	private int strokeWidth;

	@Override
	public void apply(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.setColor(new Color(color));
		g2.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

		switch (shape) {

		case OVAL:
			g2.drawOval(x, y, width, height);
			break;
		case FILL_OVAL:
			g2.fillOval(x, y, width, height);
			break;
		case RECT:
			g2.drawRect(x, y, width, height);
			break;
		case FILL_RECT:
			g2.fillRect(x, y, width, height);
			break;

		}
	}

	public ShapeMessage(ShapeType shape, int x, int y, int width, int height, int color, int strokeWidth, boolean fill) {
		super();
		this.shape = shape;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.strokeWidth = strokeWidth;
	}

	@Override
	public String toString() {
		return shape + " " + x + " " + y + " " + width + " " + height + " " + color + " " + strokeWidth;
	}

	public ShapeType getShape() {
		return shape;
	}

	public void setShape(ShapeType shape) {
		this.shape = shape;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getStrokeWidth() {
		return strokeWidth;
	}

	public void setStrokeWidth(int strokeWidth) {
		this.strokeWidth = strokeWidth;
	}

}
