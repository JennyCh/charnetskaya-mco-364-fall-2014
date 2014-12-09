package charnetskaya.paint;

import java.awt.Graphics2D;

public class FillOvalListener extends DrawShapes {
	private Paint frame;

	public FillOvalListener(Canvas canvas, Paint frame) {
		super(canvas, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {

		super.draw(g2);
		g2.fillOval(initX, initY, w, h);

	}

}
