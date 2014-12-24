package charnetskaya.paint;

import charnetskaya.paint.Message.PaintMessage;

public interface NetworkModuleInterface {
	public void sendMessage(PaintMessage message);
}
