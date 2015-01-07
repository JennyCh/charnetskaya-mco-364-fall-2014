package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import charnetskaya.paint.Message.ShapeMessage;
import charnetskaya.paint.Message.ShapeType;

public class OvalListener extends DrawShapes {

	private Paint frame;

	public OvalListener(Canvas canvas, RightPanel rightPanel) {
		super(canvas, rightPanel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
		super.permanentDraw(g2);
		g2.drawOval(initX, initY, w, h);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		prev = false;
		// permanentDraw((Graphics2D)
		// canvas.getImages().get(canvas.getActiveLayer()).getGraphics());
		permanentDraw((Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics());
		final ShapeMessage shape = new ShapeMessage(ShapeType.OVAL, initX, initY, w, h, super.canvas.getSettings()
				.getColor().getRGB(), super.canvas.getSettings().getStrokeSize(), false);
		if(rightPanel.getNetwork() != null){
		rightPanel.getNetwork().sendMessage(shape);
		}
	}
}
