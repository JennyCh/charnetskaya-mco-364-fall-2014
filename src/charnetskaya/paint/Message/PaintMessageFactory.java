package charnetskaya.paint.Message;

import java.util.Scanner;

public class PaintMessageFactory {

	public PaintMessage getMessage(String paintMessage) {

		final Scanner s = new Scanner(paintMessage);
		PaintMessage message = null;
		switch (MessageType.valueOf(s.next())) {
		case LINE:
			message = new LineMessage(s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt());
			break;
		case SHAPE:
			message = new ShapeMessage(ShapeType.valueOf(s.next()), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(),
					s.nextInt(), s.nextInt(), Boolean.valueOf(s.next()));
			break;
		case CLEAR:
			message = new ClearMessage();
			break;
		case BUCKET_FILL:
			message = new BucketFillMessage(s.nextInt(), s.nextInt(), s.nextInt());
			break;
		}
		return message;
	}
}
