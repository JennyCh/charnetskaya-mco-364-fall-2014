package charnetskaya.paint;

import java.io.PrintWriter;

import charnetskaya.paint.Message.PaintMessage;

public class OnlineNetworkModule implements NetworkModuleInterface {

	private final PrintWriter write;

	public OnlineNetworkModule(PrintWriter write) {
		this.write = write;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		// TODO Auto-generated method stub
		write.print(message.toString() + "\n");
		// System.out.println(write.toString());
		System.out.println("writing " + message.toString());
		write.flush();
	}

}
