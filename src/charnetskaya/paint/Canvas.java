package charnetskaya.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;

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

		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, 0));

	}

	public Paint getFrame() {
		return frame;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		//System.out.println ("repainting");

		listener.draw(g);
	}
	
	

	public Color getColor() {
		return color;
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

}
