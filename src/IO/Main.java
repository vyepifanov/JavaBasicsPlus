package IO;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		String firstFilePath = ".\\src\\IO\\data.dat";
		String secondFilePath = ".\\src\\IO\\promo.dat";
		int count = 0;

		try (FileInputStream first = new FileInputStream(firstFilePath);
			 FileInputStream second = new FileInputStream(secondFilePath);) {

			int byte1;
			int byte2;
            do {
					 byte1 = first.read();
					 byte2 = second.read();

					 if (byte1 == byte2) {
						 count++;
					 }
			} while (byte1 != -1 || byte2 != -1);

			System.out.println("Количество байт, которые в этих файлах совпадают: " + count);
		} catch (IOException e) {
			System.err.println("Ошибка при чтении файла: " + e.getMessage());
		}
	}

	public void countBytesInFile() {
		String filePath = ".\\src\\IO\\info.dat";
		int count = 0;

		try (FileInputStream fis = new FileInputStream(filePath)) {
			int currentByte;
			while ((currentByte = fis.read()) != -1) {
				if (currentByte >= 50 && currentByte <= 100) {
					count++;
				}
			}
			System.out.println("Количество байт в диапазоне [50, 100]: " + count);
		} catch (IOException e) {
			System.err.println("Ошибка при чтении файла: " + e.getMessage());
		}
	}

	public void getTenBytes() {
		int[] buffer = new int[10];
		int item;
		int k = 0;
		try {
			while ((item = System.in.read()) != -1 && k < 10) {
				buffer[k++] = item;
			}

			for (int i = 0; i < k; i++) {
				System.out.write(buffer[i]);
			}
			System.out.flush();
		} catch (IOException ex) {}
	}

	public void getInputBytes() {
		byte[] buffer = new byte[128];
		try {
			int bytesRead = System.in.read(buffer);
			System.out.println("Количество байт = " + bytesRead);
		} catch (IOException ex) {}
	}
}
