package charnetskaya.paint;

import java.awt.Graphics2D;

public class OvalListener extends DrawShapes {

	private Paint frame;

	public OvalListener(Canvas canvas, Paint frame) {
		super(canvas, frame);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.draw(g2);
		g2.drawOval(initX, initY, w, h);

	}

}
