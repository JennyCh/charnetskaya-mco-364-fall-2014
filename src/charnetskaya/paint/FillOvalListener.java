package charnetskaya.paint;

import java.awt.Graphics2D;
import java.io.IOException;

import charnetskaya.paint.Message.PaintMessage;
import charnetskaya.paint.Message.PaintMessageFactory;
import charnetskaya.paint.Message.ShapeMessage;
import charnetskaya.paint.Message.ShapeType;

import com.sun.prism.paint.Color;

public class FillOvalListener extends DrawShapes {
	private Paint frame;
	private Canvas canvas;

	public FillOvalListener(Canvas canvas, Paint frame) {
		super(canvas, frame);
		this.canvas = canvas;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics2D g2) throws IOException {

		super.draw(g2);
		g2.fillOval(initX, initY, w, h);

		PaintMessage message = canvas.getFactory().getMessage(
				new ShapeMessage(ShapeType.OVAL, initX, initY, w, h, Color.BLACK.getIntArgbPre(), 3, true).toString());

		PaintMessageFactory fact = canvas.getFactory();

		fact.getOut().write(message.toString().getBytes());

	}

}
