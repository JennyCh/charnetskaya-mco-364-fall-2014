package charnetskaya.paint.Message;

import java.awt.Graphics2D;

import charnetskaya.paint.Canvas;

public class ClearMessage implements PaintMessage {

	private final int width;
	private final int height;

	public ClearMessage(Canvas canvas) {
		width = canvas.getWidth();
		height = canvas.getHeight();
	}

	@Override
	public void apply(Graphics2D g2) {
		// TODO Auto-generated method stub
		g2.fillRect(0, 0, width, height);
	}

	@Override
	public String toString() {

		return "CLEAR\n";
	}

}
