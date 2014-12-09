package charnetskaya.paint;

import java.awt.Graphics2D;

public class SquareListener extends DrawShapes {

	public SquareListener(Canvas canvas, Paint frame) {
		super(canvas, frame);
	}

	@Override
	public void draw(Graphics2D g2) {

		super.draw(g2);
		g2.drawRect(initX, initY, w, h);
	}

}