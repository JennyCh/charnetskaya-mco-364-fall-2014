package paintSample;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Paint extends JFrame {
	private final int WIDTH = 200;
	private final int HEIGHT = 200;

	private final Canvas canvas;
	private final RightPanel rightPanel;

	public Paint() throws UnknownHostException, IOException {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		this.canvas = new Canvas(this);
		this.rightPanel = new RightPanel(canvas);

		this.canvas.setListeners(new BucketFillListener(canvas));
		this.add(canvas, BorderLayout.CENTER);
		this.add(rightPanel, BorderLayout.WEST);

		this.setVisible(true);
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Paint();
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

}
