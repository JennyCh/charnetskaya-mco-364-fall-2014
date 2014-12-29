package charnetskaya.paint;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class Canvas extends JComponent implements MouseWheelListener {

	private final List<BufferedImage> images;
	private DrawListenerInterface listener;
	private int activeLayer;

	private final int MAX_LAYERS = 4;

	private final int imageWidth = 800;
	private final int imageHeight = 800;

	private final Settings settings;
	private final Paint paint;

	public void setActiveLayer(int activeLayer) {
		this.activeLayer = activeLayer;
	}

	public Canvas(Paint paint) {
		this.paint = paint;
		this.images = new ArrayList<BufferedImage>();
		this.activeLayer = 0;
		// this.settings = new Settings();
		this.settings = new Settings();

		this.listener = new PenDrawListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		for (int layer = 0; layer < MAX_LAYERS; layer++) {
			images.add(new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB_PRE));

			// settings.applySettings((Graphics2D)
			// images.get(layer).getGraphics());
			// System.out.println("CONSTRUCTOR " +
			// images.get(layer).getGraphics());
			setClearBackground(layer);
		}
		this.setSize(imageWidth, imageHeight);
		this.addMouseWheelListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int layer = 0; layer < MAX_LAYERS; layer++) {
			if (layer == activeLayer) {
				listener.previewDraw((Graphics2D) g);
			}
			g.drawImage(images.get(layer), 0, 0, null);
			// System.out.println(settings.getColor());

		}
		this.repaint();
	}

	public void setClearBackground(int layerNumber) {
		final BufferedImage img = images.get(layerNumber);
		final Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void setListeners(DrawListenerInterface listener) {
		if (this.listener != null) {
			this.removeMouseListener(this.listener);
			this.removeMouseMotionListener(this.listener);
		}

		this.listener = listener;
		this.addMouseMotionListener(this.listener);
		this.addMouseListener(this.listener);
	}

	public List<BufferedImage> getImages() {
		return images;
	}

	public int getActiveLayer() {
		return activeLayer;
	}

	public int getMAX_LAYERS() {
		return MAX_LAYERS;
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public DrawListenerInterface getListener() {
		return listener;
	}

	public Settings getSettings() {
		return settings;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int rotations = this.getSettings().getStrokeSize();
		final JTextField strokeSize = paint.getTopPanel().getStrokeSize();
		// final JTextField field = panel.getStrokeSize();

		if (e.getWheelRotation() < 0) {
			rotations++;
		}

		else {
			if (rotations >= 2)
				rotations--;
		}

		strokeSize.setText(String.valueOf(rotations));

		this.getSettings().setStrokeSize(rotations);

		// defaultSettings((Graphics2D) this.getGraphics());

	}

}
