package mainGame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UnoGameLog {
    private BufferedWriter writer;
    
    public UnoGameLog() {
    	try {
			this.writer = new BufferedWriter(new FileWriter("txts/Log.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void log(String message) { //Write the message to log
    	try {
			writer.write(message);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    public void close() { //Close the writer
    	try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
