package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BucketFillPanel extends JPanel {

	private final Canvas canvas;
	private final JButton bucketFill;

	public BucketFillPanel(Canvas canvas) {
		this.canvas = canvas;

		this.bucketFill = new JButton("Fill");
		this.bucketFill.addActionListener(new ButtonListener());
		this.add(bucketFill);

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.setListeners(new BucketFillListener(canvas));

		}

	}
}
