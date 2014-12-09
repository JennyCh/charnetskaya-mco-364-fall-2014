package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class DrawListener implements DrawListenerInterface {

	private final Canvas canvas;
	private int x, y;
	private int x2;
	private int y2;
	private final Paint frame;

	public DrawListener(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		this.x2 = e.getX();
		this.y2 = e.getY();
		final Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.defaultSettings(g2);
		draw(g2);
		canvas.repaint();
		x = x2;
		y = y2;
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub

		g2.drawLine(x, y, x2, y2);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		x2 = e.getX();
		y = e.getY();
		y2 = e.getY();
		final Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.defaultSettings(g2);
		draw(g2);
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preview(Graphics2D g2) {
		// TODO Auto-generated method stub

	}
}
