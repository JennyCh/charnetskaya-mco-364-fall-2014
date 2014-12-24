package charnetskaya.paintSample;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;

public class Canvas extends JComponent implements MouseWheelListener {

	private static final long serialVersionUID = 1L;

	private final List<BufferedImage> images;
	private DrawListenerInterface listenerInterface;
	private int activeLayer;
	private final Color color;

	private final Paint frame;

	public Canvas(Paint frame) {
		this.frame = frame;
		this.images = new ArrayList<BufferedImage>();
		this.activeLayer = 0;
		this.color = Color.red;
		for (int i = 0; i < 4; i++) {
			images.add(new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE));

			setLayers(i);
		}

		this.addMouseWheelListener(this);

	}

	public void setListeners(DrawListenerInterface listener) {

		if (listenerInterface != null) {
			this.removeMouseListener(listenerInterface);
			this.removeMouseMotionListener(listenerInterface);

		}
		this.listenerInterface = listener;
		this.addMouseMotionListener(listenerInterface);
		this.addMouseListener(listenerInterface);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g);
		// defaultSettings((Graphics2D) g);

		final Iterator<BufferedImage> iter = images.iterator();
		while (iter.hasNext()) {

			// g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.drawImage(iter.next(), 0, 0, null);
			this.repaint();

		}
		listenerInterface.preview((Graphics2D) g);
		this.repaint();
		// g2.drawImage(images.get(activeLayer), 0, 0, null);

		// }
		// g2.setColor(color);

	}

	public BufferedImage getImage() {
		return images.get(activeLayer);
	}

	public int getActiveLayer() {
		return activeLayer;
	}

	public void setActiveLayer(int activeLayer) {
		this.activeLayer = activeLayer;
	}

	/*
	 * public void update(Graphics g, JComponent c){ if(c.isOpaque()){
	 * g.setColor(c.getBackground()); g.fillRect(0, 0, c.getWidth(),
	 * c.getHeight()); } paint(g,c); }
	 */

	public void setLayers(int layerNumber) {
		// System.out.println(layer);
		if (layerNumber == 0) {
			final Graphics2D g = (Graphics2D) images.get(0).getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);
		} else {
			final BufferedImage img = images.get(layerNumber);
			final Graphics2D graphics = (Graphics2D) img.getGraphics();
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			graphics.fillRect(0, 0, 800, 600);
			// reset composite
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		}

		repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		// TODO Auto-generated method stub

	}
}
