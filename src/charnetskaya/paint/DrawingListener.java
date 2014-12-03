package charnetskaya.paint;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class DrawingListener implements MouseListener, MouseMotionListener {

	public abstract void draw();
	
	public abstract void permanentDraw();

	public void removeListeners(Canvas canvas) {
		MouseMotionListener[] mouseMotionListeners = canvas.getMouseMotionListeners();
		MouseListener[] mouseListeners = canvas.getMouseListeners();

		for (MouseMotionListener l : mouseMotionListeners) {
			canvas.removeMouseMotionListener(l);
		}
		for (MouseListener l : mouseListeners) {
			canvas.removeMouseListener(l);
		}

	}

}
