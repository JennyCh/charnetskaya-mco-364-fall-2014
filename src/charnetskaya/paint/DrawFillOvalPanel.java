package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawFillOvalPanel extends JPanel {

	private final Canvas canvas;
	private final JButton drawSquare;
	private final Paint frame;

	public DrawFillOvalPanel(Canvas canvas, Paint frame) {
		this.canvas = canvas;
		this.frame = frame;

		this.drawSquare = new JButton(
				new ImageIcon(
						"C:\\Users\\Jenny\\Documents\\GitHub\\charnetskaya-mco-364-fall-2014\\src\\charnetskaya\\paint\\Filled Oval Icon.jpg"));
		this.drawSquare.addActionListener(new DrawFillOvalListener());
		this.add(drawSquare);

	}

	private class DrawFillOvalListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.setListeners(new FillOvalListener(canvas, frame));

		}

	}

}
