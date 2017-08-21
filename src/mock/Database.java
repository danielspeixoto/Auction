package mock;

import util.WriteToFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Database {

	public static final int ERROR = -1;

	// Olha todo o documento e verifica qual foi o último id inserido
	// e salva no sistema
	private static int getLastId(String path) {
		try (FileReader reader = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(reader)) {
			String last = "0", line;
			while ((line = bufferedReader.readLine()) != null) {
				last = line;
			}
			return Integer.valueOf(last.split(",")[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ERROR;
	}

	public static int insert(String path, Object object) throws IOException {
		int id = getLastId(path) + 1;
		WriteToFile.write(path, id + "," + object.toString() + "\n");
		return id;
	}

	// Recebe todos os dados de um objeto de um determinado
	// caminho que em determinado index assuma derminado valor
	public static String getData(String path, int index, String value) throws IOException {
		FileReader reader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String currentLine;
		while ((currentLine = bufferedReader.readLine()) != null) {
			if (currentLine.split(",")[index].equals(value)) {
				break;
			}
		}
		bufferedReader.close();
		reader.close();
		return currentLine;
	}

	public static void replaceLine(String path, String oldLine, String newLine) {
		try {
			FileReader reader;
			reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			StringBuffer inputBuffer = new StringBuffer();
			String currentLine;
			
			while ((currentLine = bufferedReader.readLine()) != null) {
				
				if (currentLine.equals(oldLine)) {
					inputBuffer.append(newLine);
					inputBuffer.append('\n');
				} else {
					inputBuffer.append(currentLine);
					inputBuffer.append('\n');
				}
			}

			String inputString = inputBuffer.toString();
			System.out.println(inputString);
			bufferedReader.close();	
			reader.close();
			
			FileWriter writer = new FileWriter(path, false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(inputString);
			bufferedWriter.close();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
