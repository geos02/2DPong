package coffeeandjava.pong.ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreManager {
	
	private static File file = new File("./score.txt");
	
	public static void saveScore(int score) {
		if(!(score > loadScore())) return;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(score);
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int loadScore() {
		if(!file.exists())
			return 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			int score = br.read();
			br.close();
			return score;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
		} catch(IOException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
