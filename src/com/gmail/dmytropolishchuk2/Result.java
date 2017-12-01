package com.gmail.dmytropolishchuk2;

import java.io.*;

public class Result {

	private int count = 0;
	private File result = new File("result.txt");

	public Result(File first, File second) {
		createFile(first, second);
	}

	private void createFile(File first, File second) {
		if (!first.exists() || !second.exists()) {// ���� �� ���������� ����
			System.out.println("Error! No files.");
			return;
		} else {
			StringBuilder sb = new StringBuilder();// ��� ��������� ������������������ ��������
			for (int i = 0; i < getText(second).length; i++) {// ���� �� ������ ������� �����
				System.out.println();
				System.out.println("�������� i: " + i);
				for (int j = 0; j < getText(first).length; j++) {// ���� �� ������ ������� �����
					System.out.println("�������� j: " + j);
					if (getText(first)[j].equalsIgnoreCase(getText(second)[i])) {// ���� ����� ������� ����� �� ��� �
																					// �������
						sb.append(getText(first)[j]);// ������� ���������� ������������������ ��������
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
