package wordbook;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Word_Book {
	/**
     * Method validates if file exists throws IOException
     * Commented- No file present- should throw File Not found exception
     * Reads file and display as expected output from file path :File/wordbook.txt
     */
	public void doesFileExists() throws IOException{
		BufferedReader reader = null;
		String input_line = null;
		//reader = new BufferedReader(new FileReader(new File("/File/")));
		reader = new BufferedReader(new FileReader(new File("File/wordbook.txt")));
		while((input_line = reader.readLine()) != null) {
			input_line = input_line.replaceAll("[–,]", "\n");
			System.out.println(input_line);
		}
	}
	/**
     * Main method
     */
	public static void main(String[] args) throws IOException {
		Word_Book wordbook = new Word_Book();
		wordbook.doesFileExists();
	}	

}