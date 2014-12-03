package charnetskaya.paint;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class EditorPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel colorPanel;
	private JPanel newPicturePanel;
	private JPanel safeImagePanel;
	private StrokeManagerPanel strokeManagerPanel;
	private DrawSquarePanel drawSquarePanel;
	private DrawOvalPanel drawOvalPanel;
	private DrawPencilPanel drawPencilPanel;
	
	private Canvas canvas;
	private Paint paint;

	public EditorPanel(Canvas canvas, Paint paint){
		this.canvas = canvas;
		this.setSize(800, 200);
		this.setLayout(new GridLayout(1, 4));
		this.setBackground(Color.GRAY);
		this.paint = paint;
		
		this.colorPanel = new ColorPanel(canvas);
		this.newPicturePanel = new NewPicturePanel(canvas);
		this.safeImagePanel = new SafeImagePanel(canvas);
		this.strokeManagerPanel = new StrokeManagerPanel(canvas);
		this.drawSquarePanel = new DrawSquarePanel(canvas);
		this.drawOvalPanel = new DrawOvalPanel(canvas);
		this.drawPencilPanel = new DrawPencilPanel(canvas, paint);
		
		this.add(newPicturePanel);
		this.add(safeImagePanel);
		this.add(colorPanel);
		this.add(strokeManagerPanel);
		this.add(drawPencilPanel);
		this.add(drawSquarePanel);
		this.add(drawOvalPanel);
	}


	public JPanel getColorPanel() {
		return colorPanel;
	}


	public JPanel getNewPicturePanel() {
		return newPicturePanel;
	}


	public JPanel getSafeImagePanel() {
		return safeImagePanel;
	}


	public StrokeManagerPanel getStrokeManagerPanel() {
		return strokeManagerPanel;
	}


	public Canvas getCanvas() {
		return canvas;
	}
	
	
}
