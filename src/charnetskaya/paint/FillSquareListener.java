package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import charnetskaya.paint.Message.ShapeMessage;
import charnetskaya.paint.Message.ShapeType;

public class FillSquareListener extends DrawShapes {

	public FillSquareListener(Canvas canvas, RightPanel rightPanel) {
		super(canvas, rightPanel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void permanentDraw(Graphics2D g2) {

		super.permanentDraw(g2);
		g2.fillRect(initX, initY, w, h);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		prev = false;
		permanentDraw((Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics());

		final ShapeMessage shape = new ShapeMessage(ShapeType.RECT, initX, initY, w, h, super.canvas.getSettings()
				.getColor().getRGB(), super.canvas.getSettings().getStrokeSize(), true);
		if (rightPanel.getNetwork() != null) {
			rightPanel.getNetwork().sendMessage(shape);
		}
	}

}
