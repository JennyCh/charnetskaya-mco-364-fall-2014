package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListenerInterface extends MouseListener, MouseMotionListener {
	public void permanentDraw(Graphics2D g2);

	public void previewDraw(Graphics2D g2);
}
