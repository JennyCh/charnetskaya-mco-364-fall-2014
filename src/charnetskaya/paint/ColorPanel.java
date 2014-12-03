package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ColorPanel extends JPanel {

	private JButton colorButton;
	private Canvas canvas;

	public ColorPanel(Canvas canvas) {
		this.canvas = canvas;
		
		this.colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorButtonListen());
		this.add(colorButton);
	}

	private class ColorButtonListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ColorChooser(canvas, colorButton);
		}

	}


}
