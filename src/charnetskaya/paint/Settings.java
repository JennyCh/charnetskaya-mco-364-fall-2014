package charnetskaya.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Settings {
	private Color color;
	private Stroke stroke;
	private final Color bgColor;
	private int strokeSize;

	public Settings() {
		this.strokeSize = 3;
		this.color = Color.BLACK;
		this.stroke = new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, 0);
		this.bgColor = Color.red;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setDefaultSettings(Graphics2D g2) {
		g2.setColor(color);
		g2.setStroke(new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, 0));
		g2.setBackground(bgColor);
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Stroke getStroke() {
		return stroke;
	}

	public void setStroke(Stroke stroke) {
		this.stroke = stroke;
	}

}
