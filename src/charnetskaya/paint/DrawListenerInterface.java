package charnetskaya.paint;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListenerInterface extends MouseListener, MouseMotionListener {

	public void draw();
}
