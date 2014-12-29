package charnetskaya.paint;

import java.awt.Graphics2D;

public class FillOvalListener extends DrawShapes {

	public FillOvalListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permanentDraw(Graphics2D g2) {

		super.permanentDraw(g2);
		g2.fillOval(initX, initY, w, h);

	}

}
