package charnetskaya.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {

	private final int WIDTH = 1000;
	private final int HEIGHT = 800;

	private final Canvas canvas;

	private final LeftPanel leftPanel;

	private final TopPanel topPanel;

	private final RightPanel rightPanel;

	public Paint() {
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		this.canvas = new Canvas(this);

		this.leftPanel = new LeftPanel(canvas);
		this.topPanel = new TopPanel(canvas);
		this.rightPanel = new RightPanel(canvas);

		this.add(topPanel, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.add(leftPanel, BorderLayout.EAST);
		this.add(rightPanel, BorderLayout.WEST);

		this.setVisible(true);
	}

	public static void main(String[] args) {
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

	public LeftPanel getLeftPanel() {
		return leftPanel;
	}

	public TopPanel getTopPanel() {
		return topPanel;
	}

	public RightPanel getRightPanel() {
		return rightPanel;
	}

}
