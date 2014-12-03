package charnetskaya.paint;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;

	private Canvas canvas;
	private EditorPanel editorPanel;

	public Paint() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		canvas = new Canvas(this);

		DrawListener listener = new DrawListener(canvas, this);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseWheelListener(listener);

		this.editorPanel = new EditorPanel(canvas, this);

		this.add(editorPanel, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public EditorPanel getEditorPanel() {
		return editorPanel;
	}

	public static void main(String[] args) {
		new Paint();
	}
}
