package charnetskaya.paintSample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPanel extends JPanel {

	private final JButton layer0, layer1, layer2, layer3;
	private final Canvas canvas;

	public LayerPanel(Canvas canvas, Paint paint) {
		this.canvas = canvas;

		this.setSize(new Dimension(200, 400));
		this.layer0 = new JButton("Layer 0");
		this.layer1 = new JButton("Layer 1");
		this.layer2 = new JButton("Layer 2");
		this.layer3 = new JButton("Layer 3");

		this.layer0.addActionListener(new ButtonListener());
		this.layer1.addActionListener(new ButtonListener());
		this.layer2.addActionListener(new ButtonListener());
		this.layer3.addActionListener(new ButtonListener());

		this.setLayout(new GridLayout(4, 1));

		this.add(layer3);
		this.add(layer2);
		this.add(layer1);
		this.add(layer0);

	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			layer0.setBackground(Color.gray);
			layer1.setBackground(Color.gray);
			layer2.setBackground(Color.gray);
			layer3.setBackground(Color.gray);
			if (e.getSource().equals(layer0)) {
				canvas.setActiveLayer(0);
				final JButton b = (JButton) e.getSource();
				b.setBackground(Color.yellow);
			} else if (e.getSource().equals(layer1)) {
				canvas.setActiveLayer(1);
				final JButton b = (JButton) e.getSource();
				b.setBackground(Color.yellow);
			} else if (e.getSource().equals(layer2)) {
				canvas.setActiveLayer(2);
				final JButton b = (JButton) e.getSource();
				b.setBackground(Color.yellow);
			} else if (e.getSource().equals(layer3)) {
				canvas.setActiveLayer(3);
				final JButton b = (JButton) e.getSource();
				b.setBackground(Color.yellow);
			}

		}

	}
}
