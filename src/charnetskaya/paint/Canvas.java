package charnetskaya.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class Canvas extends JComponent implements MouseWheelListener {

	private static final long serialVersionUID = 1L;

	private final BufferedImage image;
	private DrawListenerInterface listenerInterface;
	private final Settings settings;

	private final Paint frame;

	public Canvas(Paint frame) {
		this.frame = frame;
		this.settings = new Settings();
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		this.addMouseWheelListener(this);

		final Graphics2D g2 = (Graphics2D) image.getGraphics();
		g2.fillRect(0, 0, 800, 600);

	}

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

		g.drawImage(image, 0, 0, null);
		defaultSettings((Graphics2D) g);
		listenerInterface.preview((Graphics2D) g);

	}

	public BufferedImage getImage() {
		return image;
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

}
