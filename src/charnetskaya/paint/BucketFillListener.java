package charnetskaya.paint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class BucketFillListener implements DrawListenerInterface {

	private final Stack<Point> stack;
	private final Canvas canvas;

	public BucketFillListener(Canvas canvas, RightPanel rightPanel) {
		// TODO Auto-generated constructor stub
		this.stack = new Stack<Point>();
		this.canvas = canvas;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		final BufferedImage img = canvas.getImages().get(canvas.getActiveLayer());
		final Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setColor(canvas.getSettings().getColor());
		final int x = e.getX();
		final int y = e.getY();

		final Color initColor = new Color(img.getRGB(x, y));
		// System.out.println(initColor);
		boolean left, right;
		int tempY;
		
		// System.out.println(stack.size());
		System.out.println ("here" + img.getRGB(x, y) + " " + Color.BLACK.getRGB());
		if(img.getRGB(x, y) == 0){
			System.out.println ("here");
			//g2.drawLine(0, 0, 800, 800);
			g2.fillRect(0, 0, img.getWidth(), img.getHeight());
		}else{
			stack.push(new Point(x, y));
			
		}
		
		final int i = 1;
		while (!stack.isEmpty()) {
			final Point p = stack.pop();
			final int activeX = (int) p.getX();
			final int activeY = (int) p.getY();

			tempY = activeY;
//System.out.println ("Color " + g2.getColor().toString());
			//System.out.println("initColor " + initColor + " getRGB" + new Color(img.getRGB(activeX, tempY)));
			while (tempY >= 0 && initColor.equals((new Color(img.getRGB(activeX, tempY))))) {
				--tempY;
			
				//System.out.println (tempY);
			}
			tempY++;

			left = right = false;
			final int width = img.getWidth();
			final int height = img.getHeight();

			while (tempY < height && initColor.equals(new Color(img.getRGB(activeX, tempY)))) {
				g2.drawLine(activeX, tempY, activeX, tempY);
				canvas.repaint();

				if (!left && activeX > 0 && initColor.equals(new Color(img.getRGB(activeX - 1, tempY)))) {
					stack.add(new Point(activeX - 1, tempY));
					left = true;
				} else if (left && activeX > 0 && !initColor.equals(new Color(img.getRGB(activeX - 1, tempY)))) {
					left = false;
				}

				if (!right && activeX < width - 1 && initColor.equals(new Color(img.getRGB(activeX + 1, tempY)))) {
					stack.add(new Point(activeX + 1, tempY));
					right = true;
				} else if (right && activeX < width - 1 && !initColor.equals(new Color(img.getRGB(activeX + 1, tempY)))) {
					right = false;
				}
				tempY++;
			}
			// System.out.println(i++);
		}
		canvas.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("entered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("ex5ted");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("pressed");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("released");
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("dragged");
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("moved");
	}

	@Override
	public void permanentDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

	@Override
	public void previewDraw(Graphics2D g2) {
		// TODO Auto-generated method stub
	}

}
