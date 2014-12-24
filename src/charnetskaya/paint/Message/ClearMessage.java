package charnetskaya.paint.Message;

import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {

	@Override
	public void apply(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.fillRect(0, 0, 600, 800);
	}
}
