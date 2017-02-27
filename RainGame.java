/**
 * @author replace-this-with-your-netids-on-this-line-here-with-a-comma-between-them
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, points = 0, level = 1, fail = 0, lives = 3, difficulty = 0;
		boolean major = true, minor = true;
		String text = "";
		long startTime =System.currentTimeMillis();
		int fontsize = 64;
		
		while (Zen.isRunning()) {
			while (major){
				Zen.flipBuffer();
				Zen.setColor(255,255,255);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				
				Zen.setFont("Times-32");
				Zen.setColor(0,0,0);
				Zen.drawText("text", x, y);
				Zen.drawText("Press Space to Start the Game",120,360);
				
				String  mode = Zen.getEditText();
				if (mode.equals(" ")){
						major = false;
				}
				Zen.setEditText("");
			}
			while (minor){
				Zen.flipBuffer();
				Zen.setColor(20,20,25);
				Zen.fillRect(0,0,Zen.getZenWidth(),Zen.getZenHeight());
				Zen.setColor(0,0,0);
				
				Zen.setFont("Times-32");
				Zen.drawText("Choose Difficulty:", 120 , 120);
				Zen.drawText("1:Easy", 120, 180);
				Zen.drawText("2:Medium", 120, 240);
				Zen.drawText("3:Difficult", 120, 300);
				
				String mode = Zen.getEditText();
				if (mode.equals("1"))
					minor = false;
				
				if (mode.equals("2"))
					difficulty = 1;
					dy = 60;
					fontsize = 24;
					minor = false;
				
				if (mode.equals("3"))
					difficulty = 2;
					dy = 120;
					fontsize = 12;
					minor = false;
				Zen.setEditText("");
			}
			while (fail<lives){
				Zen.setFont("Times-64");
				Zen.flipBuffer();
				Zen.setColor(255,255,255);
				Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
				
				Zen.setColor(0,0,0);
				Zen.drawText("Level:" + level,10, 60);
				Zen.drawText("Points" + points, 10,120);
				Zen.drawText("Lives:" + lives, 10, 470);
				
				Zen.setFont("Times-"+64);
				
				Zen.drawText(text , x, y);

			if (text.length() == 0) 
				
				x = 0;
				y = Zen.getZenHeight() / 2;
				dx = 2;
				dy = 0;
				text = "" + (int) (Math.random() * 999);
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				//points += 3000 / elapsed;
			//Zen.setColor(255, 255, 255);
			//Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());

			//Zen.setColor(0, 255, 0);
			//Zen.drawText(text, x, y);
			//Zen.drawText("Score: 0",10,80);
			
			x += dx;
			y += dy;
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length());
					points ++;
					// all except first character
					if (points !=0 && (points%10 == 0))
						level ++;
						dy += 2;
						fontsize = (int)(fontsize * 0.8);
					if (points%100 ==0)
						lives +=3; // try more complicated colors as level increases
					else{
						if (difficulty ==1)
							Zen.setFont("Times-20");
						else{
							Zen.setFont("Times-64");
						Zen.drawText("Are you crazy? Try again!", 120, 240);
						lives --;
						}
					}
						
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds
			}
			Zen.flipBuffer();
			Zen.setColor(255,255,255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			
			Zen.setColor(0,0,0);
			Zen.setFont("Times-24");
			Zen.drawText("OK I see. You are definitely stupid.", 120, 240);
			Zen.drawText("Go to the psycho hospotial as soon as possible.", 120, 260);
		}
	}
}
