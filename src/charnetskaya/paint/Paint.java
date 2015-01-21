package charnetskaya.paint;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Paint extends JFrame {

	private final int WIDTH = 1000;
	private final int HEIGHT = 800;

	private final Canvas canvas;

	private final LayerPanel leftPanel;

	private final TopPanel topPanel;

	private final ToolPanel rightPanel;

	public Paint() throws UnknownHostException, IOException {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		this.canvas = new Canvas(this);
		this.rightPanel = new ToolPanel(canvas);
		this.leftPanel = new LayerPanel(canvas);
		this.topPanel = new TopPanel(canvas, this);

		this.canvas.setListeners(new PenDrawListener(canvas, rightPanel));

		this.add(topPanel, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.add(leftPanel, BorderLayout.EAST);
		this.add(rightPanel, BorderLayout.WEST);

		this.setVisible(true);
		// new PaintMessageFactory(canvas);
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

	public LayerPanel getLeftPanel() {
		return leftPanel;
	}

	public TopPanel getTopPanel() {
		return topPanel;
	}

	public ToolPanel getRightPanel() {
		return rightPanel;
	}

}
