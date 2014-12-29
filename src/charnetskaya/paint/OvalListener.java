package charnetskaya.paint;

import java.awt.Graphics2D;

public class OvalListener extends DrawShapes {

	private Paint frame;

	public OvalListener(Canvas canvas) {
		super(canvas);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.permanentDraw(g2);
		g2.drawOval(initX, initY, w, h);

	}

}
