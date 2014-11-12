package charnetskaya.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.w3c.dom.events.MouseEvent;

public class Paint extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel menuPanel;
	private Canvas canvas;
	private JButton colorButton;
	private JButton saveImage;
	private JPanel colorPanel;
	private JButton newPicture;
	
	private JTextField strokeSize;

	public Paint() {
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);

		this.newPicture = new JButton("New");
		this.newPicture.addActionListener(new NewCanvasActionListener());

		GridBagLayout bag = new GridBagLayout();
		saveImage = new JButton("Save Image");

		saveImage.addActionListener(new SaveActionListener());

		GridLayout grid = new GridLayout(3, 2, 10, 10);
		Container container = new Container();
		container.setPreferredSize(new Dimension(100, 100));
		grid.preferredLayoutSize(container);
		this.colorPanel = new JPanel(bag);
		menuPanel = new JPanel();
		this.menuPanel.setBackground(Color.GRAY);
		/*
		 * colorPanel.add(red); colorPanel.add(yellow);
		 */
		this.menuPanel.add(colorPanel, BorderLayout.EAST);
		// this.menuPanel.add(colorChooser);
		colorButton = new JButton("Change Color");
		colorButton.addActionListener(new ColorButtonListen());
		menuPanel.add(colorButton, BorderLayout.EAST);
		menuPanel.add(saveImage, BorderLayout.SOUTH);
		this.menuPanel.add(newPicture, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);

		this.strokeSize = new JTextField("1");
		this.strokeSize.setPreferredSize(new Dimension(30,30));
		//this.strokeSize.addFocusListener(new StrokeSizeFieldChange());
		this.strokeSize.addMouseListener(new StrokeSizeFieldChange());
		menuPanel.add(strokeSize, BorderLayout.WEST);
		canvas = new Canvas(this);
		this.add(canvas, BorderLayout.CENTER);
		DrawListener listener = new DrawListener(canvas);
		canvas.addMouseMotionListener(listener);
		canvas.addMouseWheelListener(listener);

		this.setVisible(true);

	}

	public JTextField getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(JTextField strokeSize) {
		this.strokeSize = strokeSize;
	}

	private class StrokeSizeFieldChange implements MouseListener{

		@Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			String value = strokeSize.getText();
			canvas.setStroke(Integer.parseInt(value));
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		
	}
	private class NewCanvasActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			canvas.reset();
		}

	}

	private class SaveActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {

				ImageIO.write(canvas.getImage(), "jpg", new File("C:/Users/Jenny/Desktop/image.jpg"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private class ColorButtonListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			new ColorChooser(canvas, colorButton);
		}

	}

	public static void main(String[] args) {
		new Paint();

	}

}
