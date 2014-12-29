package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

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
	private boolean prev;

	public DrawShapes(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void previewDraw(Graphics2D g2) {

		if (prev) {
			// System.out.println(g2);
			canvas.getSettings().applySettings(g2);
			// System.out.println(g2);
			permanentDraw(g2);
		}
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		/*
		 * this method ruined 5 hours of my sleep
		 */
		canvas.getSettings().applySettings(g2);
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
		previewDraw((Graphics2D) canvas.getGraphics());
		// System.out.println("pressed");
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		prev = false;
		permanentDraw((Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics());

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		this.x2 = e.getX();
		this.y2 = e.getY();
		previewDraw((Graphics2D) canvas.getGraphics());
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
