package charnetskaya.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ColorChooser extends JFrame {

	private final Canvas canvas;
	private final JButton colorButton;

	private final JButton selectButton;

	private final JColorChooser chooser;

	private Color color;

	public ColorChooser(Canvas canvas, JButton colorButton) {
		this.canvas = canvas;
		this.colorButton = colorButton;

		this.setLocationRelativeTo(null);
		this.setSize(300, 300);

		this.selectButton = new JButton("Select");
		this.selectButton.addActionListener(new SelectButtonListener());

		this.chooser = new JColorChooser();
		this.chooser.add(selectButton, BorderLayout.SOUTH);

		this.add(chooser);
		this.setVisible(true);
	}

	private class SelectButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			color = chooser.getColor();
			canvas.getSettings().setColor(color);
			colorButton.setBackground(color);
		}
	}

}
