/**
 * @author twalla20, yqin13
 * @reviewed edguzma2, allenxg2 
 */
public class RainGame {

	public static void main(String[] args) {
	
		int x=0, y=0, dx=0, dy=0, score = 0; 
		int level = 1; int lives = 10;
		int multiplier = 999;//multiplies Math.random() to return a whole integer
		String text = "";
		boolean startGame = false;//One way gate to start game
		String pressSpace = "";//Holds string " " to open startGame
		long startTime = System.currentTimeMillis();
		
		while (Zen.isRunning() && lives > 0) {
			if (!startGame) {
				Zen.flipBuffer();
				Zen.setColor(255, 255, 255);
				Zen.drawText("PRESS SPACE TO START", 20, (Zen.getZenHeight() / 2));
				pressSpace = Zen.getEditText();
				if (pressSpace.equals(" ")){
					startGame = true;
				}
				Zen.setEditText("");
			}
			if (text.length() == 0 && startGame) {
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx = 10;
				dy = 0;
				text = "" + (int) (Math.random() * multiplier);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
//				score += 3000 / elapsed;
			}
			
			if (level == 1){	//Sets colors for level one
				Zen.flipBuffer();
				Zen.setFont("Times- 48");
				Zen.setColor(0, 0, 0);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
	
				Zen.setColor(255, 255, 255);
				Zen.drawText(text, x, y);
				
				Zen.drawText("Level: " + level,10,40);
				Zen.drawText("Score: " + score,215,40);
				Zen.drawText("Lives: " + lives, 435, 40);
			}
			if (level == 2){	//Changes colors for level 2
				Zen.flipBuffer();
				Zen.setFont("Comics Sans MS-32");
				Zen.setColor(206, 48, 48);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
	
				Zen.setColor(255, 255, 255);
				Zen.drawText(text, x, y);
				
				Zen.drawText("Level: " + level,10,40);
				Zen.drawText("Score: " + score,215,40);
				Zen.drawText("Lives: " + lives, 435, 40);
			}
			if (level == 3){	//changes colors for level 3
				Zen.flipBuffer();
				Zen.setFont("Arial-24");
				Zen.setColor(0, 0, 255);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
	
				Zen.setColor(255, 0, 230);
				Zen.drawText(text, x, y);
				
				Zen.drawText("Level: " + level,10,40);
				Zen.drawText("Score: " + score,215,40);
				Zen.drawText("Lives: " + lives, 435, 40);
			}
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0)){
					text = text.substring(1,text.length());// all except first character
				}
				else
					lives--;
				
				if (text.length() == 0)
					score++;
				
				if (score == 10) {
//					Zen.setColor(206, 48, 48);
//					Zen.drawText(text, x, y);
//					
//					Zen.setColor(255, 255, 255);
//					Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
					
					level = 2;
				}
				else if (score == 15) {
//					Zen.setColor(0, 0, 255);
//					Zen.drawText(text, x, y);
//					
//					Zen.setColor(255, 0, 230);
//					Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
					
					level = 3;
					
				}

			}
			
			if (x >= Zen.getZenWidth())//Resets the number to the other side when it gets to the end of the window
				x = 0;
			
			//Conditionals for increasing difficulty with levels
			if (level > 1) {
				dx = 15;
				multiplier = 9999;
			}
			if (level > 2){ 
				dx = 25;
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds

		}
		Zen.setColor(255, 0, 0);
		Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

		Zen.setColor(0, 0, 0);
		Zen.setFont("Arial Black-64");
		Zen.drawText("GAME OVER", 25, Zen.getZenHeight()/2);
		Zen.setFont("Monotype corsiva - 24");
		Zen.drawText("PLEASE CALL THE NURSE FOR HELP",10, Zen.getZenHeight()/4);
		
	}

}
