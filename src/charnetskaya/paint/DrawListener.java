package charnetskaya.paint;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JTextField;

public class DrawListener implements MouseMotionListener, MouseWheelListener {

	private Canvas canvas;

	public DrawListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		canvas.contDrawing(x, y);

		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		canvas.setPoint(0, 0);
		// System.out.println ("setting all to -1");
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int rotations = canvas.getStroke();
		JTextField field = canvas.getFrame().getStrokeSize();

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

}
