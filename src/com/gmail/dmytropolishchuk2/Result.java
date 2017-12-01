package com.gmail.dmytropolishchuk2;

import java.io.*;

public class Result {

	private int count = 0;
	private File result = new File("result.txt");

	public Result(File first, File second) {
		createFile(first, second);
	}

	private void createFile(File first, File second) {
		if (!first.exists() || !second.exists()) {// если не существует файл
			System.out.println("Error! No files.");
			return;
		} else {
			StringBuilder sb = new StringBuilder();// для изменения последовательности символов
			for (int i = 0; i < getText(second).length; i++) {// цикл по тексту второго файла
				System.out.println();
				System.out.println("Значение i: " + i);
				for (int j = 0; j < getText(first).length; j++) {// цикл по тексту первого файла
					System.out.println("Значение j: " + j);
					if (getText(first)[j].equalsIgnoreCase(getText(second)[i])) {// если текст первого такой же как и
																					// второго
						sb.append(getText(first)[j]);// вывести измененную последовательность символов
						sb.append(" ");
						count++;
					}
				}
			}
			try (PrintWriter pw = new PrintWriter(result)) {
				result.createNewFile();
				pw.println(sb.toString());
				System.out.println(count + " words were copied!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private String[] getText(File file) {
		String[] array = null;
		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
			array = bf.readLine().split("[.!?, ]");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return array;
	}
}
