package charnetskaya.paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel {
	private final Canvas canvas;
	private final JButton clearLayer;
	private final JTextField strokeSize;

	// private final JButton saveImage;

	public TopPanel(Canvas canvas) {
		this.canvas = canvas;
		this.setBackground(Color.gray);
		this.clearLayer = new JButton("Clear");
		this.strokeSize = new JTextField(String.valueOf(canvas.getSettings().getStrokeSize()));
		this.strokeSize.setSize(10, 20);

		this.add(clearLayer);
		this.add(strokeSize);
		this.clearLayer.addActionListener(new ButtonListener());
		// saveImage = new JButton("Save Image");
		// saveImage.addActionListener(new ButtonListener());
		// this.add(saveImage);
	}

	private class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if (event.getSource() == clearLayer) {
				canvas.setClearBackground(canvas.getActiveLayer());
			} /*
			 * else if (event.getSource() == saveImage) { try {
			 * 
			 * ImageIO.write(canvas.getImages().get(canvas.getActiveLayer()),
			 * "jpg", new File( "C:/Users/Jenny/Desktop/image.jpg"));
			 * 
			 * } catch (final IOException e) { e.printStackTrace();
			 * 
			 * } }
			 */
		}
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JButton getClearLayer() {
		return clearLayer;
	}

	public JTextField getStrokeSize() {
		return strokeSize;
	}

}
