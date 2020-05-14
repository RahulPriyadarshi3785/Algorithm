package Week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TakingInputs {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		String fileName = "F:\\course\\Algorithms\\Part 1\\Week 1\\tinyUF.txt";
		try(FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr)) {
			String line;
			while((line = br.readLine()) != null)
				sb.append(line + '\n');
		}
		System.out.println(sb);
	}

}
