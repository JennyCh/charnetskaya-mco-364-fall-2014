package charnetskaya.paint;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

import charnetskaya.paint.Message.PaintMessageFactory;

public class Canvas extends JComponent implements MouseWheelListener {

	private static final long serialVersionUID = 1L;

	private final List<BufferedImage> images;
	private DrawListenerInterface listenerInterface;
	private final Settings settings;
	private int activeLayer;
	private final Color color;

	private final PaintMessageFactory factory;

	private final Paint frame;

	public Canvas(Paint frame) throws UnknownHostException, IOException {

		this.factory = new PaintMessageFactory();
		this.frame = frame;
		this.settings = new Settings();
		this.images = new ArrayList<BufferedImage>();
		this.activeLayer = 0;
		this.color = Color.red;
		for (int i = 0; i < 4; i++) {
			images.add(new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB_PRE));

			clear(i);
		}

		this.addMouseWheelListener(this);

	}

	/*
	 * final Graphics2D g2 = (Graphics2D) images.get(i).getGraphics(); g2
	 * .setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
	 * g2.setBackground(new Color(255, 255, 255, 128)); g2.fillRect(0, 0, 800,
	 * 600);
	 */
	public void defaultSettings(Graphics2D g2) {
		settings.setDefaultSettings(g2);
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
		super.paintComponent(g);
		// defaultSettings((Graphics2D) g);

		final Iterator<BufferedImage> iter = images.iterator();
		while (iter.hasNext()) {

			// g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.drawImage(iter.next(), 0, 0, null);
			// this.repaint();

		}
		try {
			listenerInterface.preview((Graphics2D) g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.repaint();
		// g2.drawImage(images.get(activeLayer), 0, 0, null);

		// }
		// g2.setColor(color);

	}

	public BufferedImage getImage() {
		return images.get(activeLayer);
	}

	public Settings getSettings() {
		return settings;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub

		int rotations = this.getSettings().getStrokeSize();
		final StrokeManagerPanel panel = frame.getEditorPanel().getStrokeManagerPanel();
		final JTextField field = panel.getStrokeSize();

		if (e.getWheelRotation() < 0) {
			rotations++;
		}

		else {
			if (rotations >= 2)
				rotations--;
		}

		field.setText(String.valueOf(rotations));

		this.getSettings().setStrokeSize(rotations);

		defaultSettings((Graphics2D) this.getGraphics());

	}

	public int getActiveLayer() {
		return activeLayer;
	}

	public void setActiveLayer(int activeLayer) {
		this.activeLayer = activeLayer;
	}

	public void clear(int layer) {
		// System.out.println(layer);
		if (layer == 0) {
			final Graphics2D g = (Graphics2D) images.get(0).getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);
		} else {
			BufferedImage img = images.get(layer);
			img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
			final Graphics2D graphics = (Graphics2D) img.getGraphics();
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
			graphics.fillRect(0, 0, 800, 600);
			// reset composite
			graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

		}

		repaint();
	}

	public PaintMessageFactory getFactory() {
		return factory;
	}

}
