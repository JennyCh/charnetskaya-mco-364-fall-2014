package charnetskaya.paint;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class LayerPanel extends JPanel {

	private final Canvas canvas;

	private final JButton layer1, layer2, layer3, layer0;

	public LayerPanel(Canvas canvas) {
		this.canvas = canvas;
		this.setBackground(Color.gray);
		this.layer0 = new JButton("Layer0");
		this.layer1 = new JButton("Layer1");
		this.layer2 = new JButton("Layer2");
		this.layer3 = new JButton("Layer3");

		this.setLayout(new GridLayout(13, 1));

		this.add(layer3);
		this.add(layer2);
		this.add(layer1);
		this.add(layer0);

		this.layer3.addActionListener(new ButtonListener());
		this.layer2.addActionListener(new ButtonListener());
		this.layer1.addActionListener(new ButtonListener());
		this.layer0.addActionListener(new ButtonListener());

		this.layer0.setBackground(Color.yellow);
		this.layer1.setBackground(Color.LIGHT_GRAY);
		this.layer2.setBackground(Color.LIGHT_GRAY);
		this.layer3.setBackground(Color.LIGHT_GRAY);

	}

	private class ButtonListener implements ActionListener {

		public ButtonListener() {

		}

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			layer0.setBackground(Color.LIGHT_GRAY);
			layer1.setBackground(Color.LIGHT_GRAY);
			layer2.setBackground(Color.LIGHT_GRAY);
			layer3.setBackground(Color.LIGHT_GRAY);
			if (event.getSource() == layer0) {
				canvas.setActiveLayer(0);
				layer0.setBackground(Color.yellow);
			} else if (event.getSource() == layer1) {
				canvas.setActiveLayer(1);
				layer1.setBackground(Color.yellow);
			} else if (event.getSource() == layer2) {
				canvas.setActiveLayer(2);
				layer2.setBackground(Color.yellow);
			} else if (event.getSource() == layer3) {
				canvas.setActiveLayer(3);
				layer3.setBackground(Color.yellow);
			}
		}
	}
}
