package charnetskaya.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Canvas canvas;
	private Color color;
	private JColorChooser chooser;
	private JButton button;
	private JButton colorButton;

	public ColorChooser(Canvas canvas, JButton colorButton) {
		this.canvas = canvas;
		this.setLocationRelativeTo(null);
		this.setSize(300, 300);
		this.button = new JButton("Select");
		this.button.addActionListener(new SelectButtonListener());
		this.chooser = new JColorChooser();
		this.chooser.add(button, BorderLayout.SOUTH);
		this.colorButton = colorButton;

		this.add(chooser);

		this.setVisible(true);

	}

	private class SelectButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			color = chooser.getColor();
			canvas.setColor(color);
			colorButton.setBackground(color);
		}

	}

}
