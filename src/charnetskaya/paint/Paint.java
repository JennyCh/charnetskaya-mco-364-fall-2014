package charnetskaya.paint;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import charnetskaya.paint.Message.PaintMessageFactory;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;

	private final Canvas canvas;
	private final EditorPanel editorPanel;
	private final LayerPanel layerPanel;

	public Paint() throws UnknownHostException, IOException {
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		canvas = new Canvas(this);
		canvas.setListeners(new DrawListener(canvas));
		this.editorPanel = new EditorPanel(canvas, this);
		this.layerPanel = new LayerPanel(canvas, this);

		this.add(editorPanel, BorderLayout.NORTH);
		this.add(canvas, BorderLayout.CENTER);
		this.add(layerPanel, BorderLayout.EAST);
		//new PaintMessageFactory();
		this.setVisible(true);

	}

	public EditorPanel getEditorPanel() {
		return editorPanel;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		new Paint();
	}
}
