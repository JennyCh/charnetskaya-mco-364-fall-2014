package charnetskaya.paint;

import java.awt.Graphics2D;

public class FillSquareListener extends DrawShapes {

	private Paint frame;

	public FillSquareListener(Canvas canvas, Paint frame) {
		super(canvas, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {

		super.draw(g2);
		g2.fillRect(initX, initY, w, h);

	}

}
