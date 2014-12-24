package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;

public interface DrawListenerInterface extends MouseListener, MouseMotionListener {

	public void draw(Graphics2D g2) throws IOException;

	public void preview(Graphics2D g2) throws IOException;
}
