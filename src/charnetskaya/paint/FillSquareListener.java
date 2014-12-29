package charnetskaya.paint;

import java.awt.Graphics2D;

public class FillSquareListener extends DrawShapes {

	public FillSquareListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permanentDraw(Graphics2D g2) {

		super.permanentDraw(g2);
		g2.fillRect(initX, initY, w, h);

	}

}
