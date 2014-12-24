package charnetskaya.paintSample;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListenerInterface extends MouseListener, MouseMotionListener {

	public void draw(Graphics2D g2);

	public void preview(Graphics2D g2);
}
