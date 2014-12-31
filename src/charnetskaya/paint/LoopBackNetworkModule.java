package charnetskaya.paint;

import java.awt.Graphics2D;
import java.io.IOException;
import java.net.UnknownHostException;

import charnetskaya.paint.Message.PaintMessage;
import charnetskaya.paint.Message.PaintMessageFactory;

public class LoopBackNetworkModule implements NetworkModuleInterface {

	private final Canvas canvas;
	private final PaintMessageFactory factory;

	public LoopBackNetworkModule(Canvas canvas) throws UnknownHostException, IOException {
		this.canvas = canvas;
		this.factory = new PaintMessageFactory(canvas);
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub

		final PaintMessage paintMessage = factory.getMessage(message.toString());

		paintMessage.apply((Graphics2D) canvas.getImages().get(canvas.getActiveLayer()).getGraphics());
		canvas.repaint();

	}

}
