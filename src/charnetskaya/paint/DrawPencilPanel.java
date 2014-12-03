package charnetskaya.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DrawPencilPanel extends JPanel {

	private Canvas canvas;
	private JButton drawPencil;
	private Paint paint;
	
	public DrawPencilPanel(Canvas canvas, Paint paint){
		this.canvas = canvas;
		this.paint = paint;
		this.drawPencil = new JButton("Draw Pencil");
		this.drawPencil.addActionListener(new DrawPencilListener());
		this.add(drawPencil);
	}
	
	private class DrawPencilListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			DrawListener listener = new DrawListener(canvas, paint);
		
			
			//System.out.println ("REMOVED");
		}
		
	}
	
	
}
