package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

public abstract class DrawShapes implements DrawListenerInterface {

	private final Canvas canvas;

	protected int x;
	protected int y;
	protected int x2;
	protected int y2;
	protected int w;
	protected int h;
	protected int initX;
	protected int initY;
	private final Paint frame;
	private boolean prev;

	public DrawShapes(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;
	}

	@Override
	public void preview(Graphics2D g2) throws IOException {
		if (prev) {
			draw(g2);
		}
	}

	@Override
	public void draw(Graphics2D g2) throws IOException {
		/*
		 * this method ruined 5 hours of my sleep
		 */
		w = Math.abs(x - x2);
		h = Math.abs(y - y2);
		initX = Math.min(x, x2);
		initY = Math.min(y, y2);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		prev = true;
		/*
		 * get initial points and assign them to the drag points so that when
		 * press there is only a dot drawn
		 */
		this.x = e.getX();
		this.y = e.getY();
		this.x2 = x;
		this.y2 = y;

		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		final Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		canvas.defaultSettings(g2);
		prev = false;
		try {
			draw(g2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		this.x2 = e.getX();
		this.y2 = e.getY();
		this.canvas.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
