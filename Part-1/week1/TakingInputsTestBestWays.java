import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class TakingInputsTestBestWays {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fileName = "F:\\course\\Algorithms\\Part 1\\Week 1\\tinyUF.txt";
		StringBuilder sb = new StringBuilder();
        long time = System.currentTimeMillis();
        time = System.currentTimeMillis();
		try(Stream<String> stream = Files.lines(Paths.get(fileName))){
			stream.forEach(sb::append);
		}
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => Files.lines" );
		System.out.println(sb);
		sb = new StringBuilder();
        time = System.currentTimeMillis();
		try(BufferedReader br = Files.newBufferedReader(Paths.get(fileName))){
			String line;
			while((line = br.readLine()) != null)
				sb.append(line);
		}
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => Files.newBufferedReader" );
		System.out.println(sb);
		sb = new StringBuilder();
        time = System.currentTimeMillis();
		try(FileReader fr = new FileReader(fileName);//Best
			BufferedReader br = new BufferedReader(fr)){
			String line;
			while((line = br.readLine()) != null)
				sb.append(line);
		}
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => BufferedReader(FileReader)" );
		System.out.println(sb);
		sb = new StringBuilder();
        time = System.currentTimeMillis();
		try(FileReader fr = new FileReader(fileName);
			Scanner sc = new Scanner(fr)){
			while(sc.hasNextLine()){
				sb.append(sc.nextLine());
			}
		}
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => Scanner" );
		System.out.println(sb);
        time = System.currentTimeMillis();
		String content = new String(Files.readAllBytes(Paths.get(fileName)));
        System.out.print( System.currentTimeMillis()-time );
        System.out.println(" => Files.readAllBytes" );
		System.out.println(content);
	}

}
