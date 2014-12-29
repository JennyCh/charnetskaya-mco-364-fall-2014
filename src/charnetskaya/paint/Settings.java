package charnetskaya.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Settings {
	private Color color;
	private Stroke stroke;
	private int strokeSize;

	public Settings() {
		this.strokeSize = 3;
		this.color = Color.BLACK;
		this.stroke = new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, 0);
	}

	public void applySettings(Graphics2D g) {

		g.setColor(color);
		g.setStroke(stroke);
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

	public int getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(int strokeSize) {
		this.strokeSize = strokeSize;
		this.stroke = new BasicStroke(strokeSize, BasicStroke.CAP_ROUND, 0);
	}

}
