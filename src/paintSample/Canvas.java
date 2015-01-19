package paintSample;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	private final BufferedImage image;
	private BucketFillListener listener;

	private final Settings settings;

	private final int imageWidth = 800;
	private final int imageHeight = 800;
	private final Paint paint;

	public Canvas(Paint paint) {
		this.paint = paint;

		image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB_PRE);

		setClearBackground(image);

		this.setSize(imageWidth, imageHeight);
		this.settings = new Settings();

	}

	public BucketFillListener getListener() {
		return listener;
	}

	public Settings getSettings() {
		return settings;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(image, 0, 0, null);

		paint.repaint();
	}

	public void setClearBackground(BufferedImage image) {
		final BufferedImage img = image;
		final Graphics2D g2 = (Graphics2D) img.getGraphics();
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR));
		// g2.setColor(Color.white); // sets white background
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
	}

	public void setListeners(BucketFillListener listener) {
		if (this.listener != null) {
			this.removeMouseListener(this.listener);
			this.removeMouseMotionListener(this.listener);
		}

		this.listener = listener;
		this.addMouseMotionListener(this.listener);
		this.addMouseListener(this.listener);
	}

	public int getImageWidth() {
		return imageWidth;
	}

	public int getImageHeight() {
		return imageHeight;
	}

	public Paint getPaint() {
		return paint;
	}

	public BufferedImage getImage() {
		// TODO Auto-generated method stub
		return image;
	}
}
