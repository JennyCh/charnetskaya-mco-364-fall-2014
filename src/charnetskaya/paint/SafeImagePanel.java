package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SafeImagePanel extends JPanel {

	private JButton saveImage;
	private Canvas canvas;

	public SafeImagePanel(Canvas canvas) {
		this.canvas = canvas;

		this.setSize(200, 200);
		saveImage = new JButton("Save Image");
		saveImage.addActionListener(new SaveImage());
		this.add(saveImage);
	}

	private class SaveImage implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			try {

				ImageIO.write(canvas.getImage(), "jpg", new File("C:/Users/Jenny/Desktop/image.jpg"));

			} catch (IOException e) {
				e.printStackTrace();

			}
		}
	}
}
