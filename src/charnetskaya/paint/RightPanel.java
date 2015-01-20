package charnetskaya.paint;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RightPanel extends JPanel {

	private final JButton drawPencilButton;
	private final JButton bucketFill;
	private final JButton oval, fillOval, rect, fillRect;

	private final JButton colorButton;

	private final Canvas canvas;

	private NetworkModuleInterface network;

	public NetworkModuleInterface getNetwork() {
		return network;
	}

	public void setNetwork(NetworkModuleInterface network) {
		this.network = network;
	}

	public RightPanel(Canvas canvas) {
		this.canvas = canvas;
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.drawPencilButton = new JButton(new ImageIcon("src/charnetskaya/paint/Line.jpg"));
		this.drawPencilButton.setSize(new Dimension(30, 30));
		this.drawPencilButton.setBorder(null);
		this.drawPencilButton.setBorderPainted(false);
		this.drawPencilButton.setMargin(new Insets(0, 0, 0, 0));
		this.drawPencilButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.bucketFill = new JButton(new ImageIcon("src/charnetskaya/paint/BucketFill.jpg"));
		this.bucketFill.setSize(new Dimension(30, 30));
		this.bucketFill.setBorder(null);
		this.bucketFill.setBorderPainted(false);
		this.bucketFill.setMargin(new Insets(0, 0, 0, 0));
		this.bucketFill.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.oval = new JButton(new ImageIcon("src/charnetskaya/paint/OvalIcon.jpg"));
		this.oval.setSize(new Dimension(30, 30));
		this.oval.setBorder(null);
		this.oval.setBorderPainted(false);
		this.oval.setMargin(new Insets(0, 0, 0, 0));
		this.oval.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.fillOval = new JButton(new ImageIcon("src/charnetskaya/paint/FilledOvalIcon.jpg"));
		this.fillOval.setSize(new Dimension(30, 30));
		this.fillOval.setBorder(null);
		this.fillOval.setBorderPainted(false);
		this.fillOval.setMargin(new Insets(0, 0, 0, 0));
		this.fillOval.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.rect = new JButton(new ImageIcon("src/charnetskaya/paint/RectangleIcon.jpg"));
		this.rect.setSize(new Dimension(30, 30));
		this.rect.setBorder(null);
		this.rect.setBorderPainted(false);
		this.rect.setMargin(new Insets(0, 0, 0, 0));
		this.rect.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.fillRect = new JButton(new ImageIcon("src/charnetskaya/paint/FilledRectangleIcon.jpg"));
		this.fillRect.setSize(new Dimension(30, 30));
		this.fillRect.setBorder(null);
		this.fillRect.setBorderPainted(false);
		this.fillRect.setMargin(new Insets(0, 0, 0, 0));
		this.fillRect.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.colorButton = new JButton("");
		this.colorButton.setBackground(Color.black);
		this.colorButton.setSize(200, 200);
		this.colorButton.setBorderPainted(false);
		this.colorButton.setMargin(new Insets(30, 15, 30, 15));
		this.add(colorButton);

		this.add(drawPencilButton);
		this.add(bucketFill);
		this.add(oval);
		this.add(fillOval);
		this.add(rect);
		this.add(fillRect);
		this.drawPencilButton.addActionListener(new ButtonListener(this));
		this.bucketFill.addActionListener(new ButtonListener(this));
		this.oval.addActionListener(new ButtonListener(this));
		this.fillOval.addActionListener(new ButtonListener(this));
		this.rect.addActionListener(new ButtonListener(this));
		this.fillRect.addActionListener(new ButtonListener(this));
		this.colorButton.addActionListener(new ButtonListener(this));
	}

	public void setNetwordModule(NetworkModuleInterface module) {
		this.network = module;
	}

	private class ButtonListener implements ActionListener {

		private final RightPanel rightPanel;

		private ButtonListener(RightPanel rightPanel) {
			this.rightPanel = rightPanel;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			if (event.getSource() == drawPencilButton) {
				canvas.setListeners(new PenDrawListener(canvas, rightPanel));
			} else if (event.getSource() == colorButton) {
				new ColorChooser(canvas, colorButton);
			} else if (event.getSource() == bucketFill) {
				// System.out.println("filled");
				canvas.setListeners(new BucketFillListener(canvas, rightPanel));
			} else if (event.getSource() == oval) {
				canvas.setListeners(new OvalListener(canvas, rightPanel));
			} else if (event.getSource() == fillOval) {
				canvas.setListeners(new FillOvalListener(canvas, rightPanel));
			} else if (event.getSource() == rect) {
				canvas.setListeners(new SquareListener(canvas, rightPanel));
			} else if (event.getSource() == fillRect) {
				canvas.setListeners(new FillSquareListener(canvas, rightPanel));
			}
		}
	}
}
