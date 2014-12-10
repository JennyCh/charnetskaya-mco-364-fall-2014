package charnetskaya.paint;

import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage {

	private ShapeType shape;
	private int x, y, width, height;
	private int color;
	private int strokeWidth;
	private boolean fill;

	@Override
	public void apply(Graphics2D g2) {
		// TODO Auto-generated method stub

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
		this.fill = fill;
	}

	@Override
	public String toString() {
		return shape + " " + x + " " + y + " " + width + " " + height + " " + color + " " + strokeWidth + " " + fill;
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

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

}
