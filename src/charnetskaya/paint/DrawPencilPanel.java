package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawPencilPanel extends JPanel {

	private final Canvas canvas;
	private final JButton drawPencil;
	private final Paint paint;

	public DrawPencilPanel(Canvas canvas, Paint paint) {
		this.canvas = canvas;
		this.paint = paint;
		this.drawPencil = new JButton(
				new ImageIcon(
						"C:\\Users\\Jenny\\Documents\\GitHub\\charnetskaya-mco-364-fall-2014\\src\\charnetskaya\\paint\\Line Icon.jpg"));
		this.drawPencil.addActionListener(new DrawPencilListener());
		this.add(drawPencil);

	}

	private class DrawPencilListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			canvas.setListeners(new DrawListener(canvas));

		}

	}

}
