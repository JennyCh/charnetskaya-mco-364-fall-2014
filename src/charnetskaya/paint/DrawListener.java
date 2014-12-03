package charnetskaya.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JTextField;

public class DrawListener extends DrawingListener implements MouseWheelListener {

	private Canvas canvas;
	private Paint frame;

	private int x ;
	private int y ;
	private int x2;
	private int y2;

	public DrawListener(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;
		this.removeListeners(canvas);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);

	}

	@Override
	public void mouseDragged(MouseEvent e) {
//System.out.println ("dragged");
		x2 = e.getX();
		y2 = e.getY();
		
	//	System.out.println (x + " " + y + " " + x2 + " " + y2);
		//canvas.contDrawing(x, y);
draw();
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.x = 0;
		this.y = 0;
		// System.out.println ("setting all to -1");
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotations = canvas.getStroke();
		StrokeManagerPanel panel = (StrokeManagerPanel) frame.getEditorPanel().getStrokeManagerPanel();
		JTextField field = panel.getStrokeSize();

		if (e.getWheelRotation() < 0) {
			rotations++;
		}

		else {
			if (rotations >= 2)
				rotations--;
		}

		field.setText(String.valueOf(rotations));

		canvas.setStroke(rotations);
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
		g2.setStroke(new BasicStroke(canvas.getStroke(), BasicStroke.CAP_ROUND, 0));
		g2.setColor(canvas.getColor());
		if (this.x != 0 && this.y != 0) {

			g2.drawLine(this.x, this.y, x2, y2);

			// g2.fillOval(this.x, this.y, this.x, this.y);

		}

		this.x = x2;
		this.y = y2;
	}

	@Override
	public void permanentDraw() {
		// TODO Auto-generated method stub
		
	}

}
