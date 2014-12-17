package charnetskaya.paint;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class EditorPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private final JPanel colorPanel;
	private final JPanel newPicturePanel;
	private final JPanel safeImagePanel;

	private final JPanel shapesPanel;
	private final StrokeManagerPanel strokeManagerPanel;
	private final DrawSquarePanel drawSquarePanel;
	private final DrawOvalPanel drawOvalPanel;
	private final DrawPencilPanel drawPencilPanel;
	private final DrawFillSquarePanel drawFillSquarePanel;
	private final DrawFillOvalPanel drawFillOvalPanel;
	private final BucketFillPanel bucketFillPanel;

	private final Canvas canvas;

	public EditorPanel(Canvas canvas, Paint paint) {
		this.canvas = canvas;
		this.setSize(800, 200);
		this.setLayout(new FlowLayout());
		this.setBackground(Color.GRAY);
		this.shapesPanel = new JPanel(new GridLayout(2, 3));

		this.colorPanel = new ColorPanel(canvas);
		this.newPicturePanel = new NewPicturePanel(canvas);
		this.safeImagePanel = new SafeImagePanel(canvas);
		this.strokeManagerPanel = new StrokeManagerPanel(canvas);
		this.drawSquarePanel = new DrawSquarePanel(canvas, paint);
		this.drawOvalPanel = new DrawOvalPanel(canvas, paint);
		this.drawPencilPanel = new DrawPencilPanel(canvas, paint);
		this.drawFillSquarePanel = new DrawFillSquarePanel(canvas, paint);
		this.drawFillOvalPanel = new DrawFillOvalPanel(canvas, paint);
		this.bucketFillPanel = new BucketFillPanel(canvas);
		this.shapesPanel.add(bucketFillPanel);
		this.shapesPanel.add(drawPencilPanel);
		this.shapesPanel.add(drawSquarePanel);
		this.shapesPanel.add(drawOvalPanel);
		this.shapesPanel.add(drawFillSquarePanel);
		this.shapesPanel.add(drawFillOvalPanel);

		this.add(newPicturePanel);
		this.add(safeImagePanel);
		this.add(colorPanel);
		this.add(strokeManagerPanel);
		/*
		 * this.add(drawPencilPanel); this.add(drawSquarePanel);
		 * this.add(drawOvalPanel); this.add(drawFillSquarePanel);
		 * this.add(drawFillOvalPanel);
		 */
		this.add(shapesPanel);
		System.out.println("editor panel");
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
