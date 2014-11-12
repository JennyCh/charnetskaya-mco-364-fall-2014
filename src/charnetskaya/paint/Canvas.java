package charnetskaya.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	private BufferedImage image;
	private Color color;
	private int stroke;
private Paint frame;
	
	public Canvas(Paint frame) {
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
this.frame = frame;
		this.color = Color.black;
		this.setBackground(Color.white);
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.fillRect(0, 0, 800, 600);
		stroke = 1;

		g2.setStroke(new BasicStroke(stroke));
	}

	public Paint getFrame() {
		return frame;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void contDrawing(int x, int y) {

		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.setStroke(new BasicStroke(stroke));
		g2.setColor(color);
		if (this.x != 0 && this.y != 0) {
			g2.drawLine(this.x, this.y, x, y);
		}

		this.x = x;
		this.y = y;
	}

	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);

	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;

	}

	public BufferedImage getImage() {
		return image;
	}

	public void setPoint(int x, int y) {
		this.y = y;
		this.x = x;

	}

	public void reset() {
		Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.fillRect(0, 0, 800, 600);
		this.repaint();
	}

}
