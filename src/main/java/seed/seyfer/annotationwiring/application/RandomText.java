package seed.seyfer.annotationwiring.application;

import java.util.Random;

public class RandomText {
	private static String[] texts = {
		"I'll be back",
		"second",
		"third"
	};
	
	public String getText() {
		Random random = new Random();
		
		return texts[random.nextInt(texts.length)];
	}
}
