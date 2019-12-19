package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Score implements IScore{
	public void writeScore(long result_in_sec){
		String src = "C:/PJ1/score.txt";        
        File score = new File(src);

        try {
			FileOutputStream out = new FileOutputStream(score, true);
			String res = Long.toString(result_in_sec);
			res = res.concat("Player 1 : " + res + " ms\n");
			byte[] strToBytes = res.getBytes();
			 
			 try {
				out.write(strToBytes);
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     			 
			    
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
