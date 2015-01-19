package paintSample;

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

	private final JButton bucketFill;

	private final JButton colorButton, clear;

	private final Canvas canvas;

	public RightPanel(Canvas canvas) {
		this.canvas = canvas;
		this.setBackground(Color.white);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.clear = new JButton("Clear");

		this.bucketFill = new JButton(new ImageIcon("src/charnetskaya/paint/BucketFill.jpg"));
		this.bucketFill.setSize(new Dimension(30, 30));
		this.bucketFill.setBorder(null);
		this.bucketFill.setBorderPainted(false);
		this.bucketFill.setMargin(new Insets(0, 0, 0, 0));
		this.bucketFill.setCursor(new Cursor(Cursor.HAND_CURSOR));

		this.colorButton = new JButton("   ");
		this.colorButton.setBackground(Color.black);
		this.add(colorButton);

		this.add(bucketFill);
		this.add(clear);

		this.colorButton.addActionListener(new ButtonListener(this));
		this.clear.addActionListener(new ButtonListener(this));
	}

	private class ButtonListener implements ActionListener {

		private final RightPanel rightPanel;

		private ButtonListener(RightPanel rightPanel) {
			this.rightPanel = rightPanel;
		}

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub

			if (event.getSource() == colorButton) {
				new ColorChooser(canvas, colorButton);
			} else if (event.getSource() == clear) {
				canvas.setClearBackground(canvas.getImage());
			}
		}
	}
}
