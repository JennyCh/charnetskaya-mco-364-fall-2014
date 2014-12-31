package charnetskaya.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setBackground(Color.gray);
		this.setLayout(new GridLayout(10, 1));
		this.drawPencilButton = new JButton(new ImageIcon("/Line.jpg"));

		this.bucketFill = new JButton("Fill");
		this.oval = new JButton("Oval");
		this.fillOval = new JButton("FillOval");
		this.rect = new JButton("Square");
		this.fillRect = new JButton("Fill Square");
		this.colorButton = new JButton("   ");
		this.colorButton.setBackground(Color.black);
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
				canvas.setListeners(new PenDrawListener(canvas));
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
