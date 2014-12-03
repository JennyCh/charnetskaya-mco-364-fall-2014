package charnetskaya.paint;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class StrokeManagerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField strokeSize;
	private Canvas canvas;

	public StrokeManagerPanel(Canvas canvas) {
		this.canvas = canvas;
		this.strokeSize = new JTextField("1");
		this.strokeSize.setPreferredSize(new Dimension(30, 30));
		this.strokeSize.addMouseListener(new StrokeSizeFieldChange());

		this.add(strokeSize);
	}

	private class StrokeSizeFieldChange implements MouseListener {

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

	public JTextField getStrokeSize() {
		return strokeSize;
	}

	public void setStrokeSize(JTextField strokeSize) {
		this.strokeSize = strokeSize;
	}

}
