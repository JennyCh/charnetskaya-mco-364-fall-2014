package charnetskaya.paint;

import java.awt.Graphics2D;

public class SquareListener extends DrawShapes {

	public SquareListener(Canvas canvas) {
		super(canvas);
	}

	@Override
	public void permanentDraw(Graphics2D g2) {

		super.permanentDraw(g2);
		g2.drawRect(initX, initY, w, h);
	}

}