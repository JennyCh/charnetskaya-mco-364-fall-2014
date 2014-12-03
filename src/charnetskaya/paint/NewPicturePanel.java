package charnetskaya.paint;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class NewPicturePanel extends JPanel{

	 private JButton newPicture;
	 
	 private Canvas canvas;
	 
	 public NewPicturePanel(Canvas canvas){
		 this.canvas = canvas;
		 
		 this.setSize(200, 200);
		 this.newPicture = new JButton("New");
		 this.newPicture.addActionListener(new NewCanvas());
		 this.add(newPicture);
	 }
	 
	 
	 private class NewCanvas implements ActionListener{
	 @Override
		public void actionPerformed(ActionEvent arg0) {
			Graphics2D g2 = (Graphics2D) canvas.getImage().getGraphics();
			g2.fillRect(0, 0, 800, 600);
			canvas.repaint();
		}
}}
