package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawFillSquarePanel extends JPanel {

	private final Canvas canvas;
	private final JButton drawSquare;
	private final Paint frame;

	public DrawFillSquarePanel(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;

		this.drawSquare = new JButton(
				new ImageIcon(
						"C:\\Users\\Jenny\\Documents\\GitHub\\charnetskaya-mco-364-fall-2014\\src\\charnetskaya\\paint\\Filled Rectangle Icon.jpg"));

		/*
		 * this.drawSquare .setIcon(new ImageIcon(
		 */
		this.drawSquare.addActionListener(new DrawFillSquareListener());
		this.add(drawSquare);

	}

	private class DrawFillSquareListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.setListeners(new FillSquareListener(canvas, frame));

		}

	}

}
