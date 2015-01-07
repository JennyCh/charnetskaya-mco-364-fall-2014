package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import charnetskaya.paint.Message.LineMessage;
import charnetskaya.paint.Message.ShapeMessage;
import charnetskaya.paint.Message.ShapeType;

public class PenDrawListener implements DrawListenerInterface {

	private final Canvas canvas;
	private int x1, y1, x2, y2;
	private RightPanel rightPanel;

	/*
	 * public void resetPoints() { x1 = y1 = -1; }
	 */

	public PenDrawListener(Canvas canvas, RightPanel rightPanel) {
		this.canvas = canvas;
		this.rightPanel = rightPanel;
		// x1 = y1 = -1;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent event) {
		// TODO Auto-generated method stub
		x1 = x2 = event.getX();
		y1 = y2 = event.getY();
		final Graphics2D g2 = (Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics();
		permanentDraw(g2);
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseDragged(MouseEvent event) {
		// TODO Auto-generated method stub
		this.x2 = event.getX();
		this.y2 = event.getY();
		final Graphics2D g2 = (Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics();

		permanentDraw(g2);
		final LineMessage line = new LineMessage(x1, y1, x2, y2, canvas.getSettings().getColor().getRGB(), canvas.getSettings().getStrokeSize());
		System.out.println (rightPanel == null);
		if(rightPanel != null){
		rightPanel.getNetwork().sendMessage(line);
		}
		
		x1 = x2;
		y1 = y2;
		
		//return "LINE" + " " + x1 + " " + y1 + " " + x2 + " " + y2 + " " + color + " " + strokeWidth + "\n";
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// x1 = y1 = -1;
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
		canvas.getSettings().applySettings(g2);

		g2.drawLine(x1, y1, x2, y2);

	}

	@Override
	public void previewDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
		canvas.getSettings().applySettings(g2);
		g2.drawLine(x1, y1, x2, y2);
	}

}
