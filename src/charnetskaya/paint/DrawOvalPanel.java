package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawOvalPanel extends JPanel {

	private final Canvas canvas;
	private final JButton drawOval;
	private final Paint frame;

	public DrawOvalPanel(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;
		this.drawOval = new JButton(
				new ImageIcon(
						"C:\\Users\\Jenny\\Documents\\GitHub\\charnetskaya-mco-364-fall-2014\\src\\charnetskaya\\paint\\Oval Icon.jpg"));
		this.drawOval.addActionListener(new DrawOvalListener());
		this.add(drawOval);

	}

	private class DrawOvalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			canvas.setListeners(new OvalListener(canvas, frame));
		}

	}

}
