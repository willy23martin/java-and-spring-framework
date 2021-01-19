/**
 * 
 */
package openweb.wmc.java.eight.flow.nio2;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaNIO2 {

	public static void javaIOFileOutputStream() {
		OutputStream flowOut = null;
		try {
			flowOut = new FileOutputStream("./testFileBytePerByte.txt");
			for(int i=20; i<45; i*=2) {
				flowOut.write(i); 
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(flowOut != null) {
				try {
					flowOut.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void javaIOBufferOutputStream() {
		OutputStream flowOut = null;
		byte[] buffer=new byte[1024*32];
		Arrays.fill(buffer, Byte.parseByte("1")); 
		try {
			flowOut = new BufferedOutputStream(new FileOutputStream("./testBufferedChunksOfBytes.txt"));
			flowOut.write(buffer); 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(flowOut != null) {
				try {
					flowOut.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void javaIOFileWriter() {
		FileWriter fileWriter = null;
		String message = "No Line"; 
		try {
			fileWriter = new FileWriter("./testFileWriter.txt");
			fileWriter.write(message);  
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void javaIOBufferedWriter() {
		BufferedWriter fileWriter = null;
		try {
			fileWriter = new BufferedWriter(new FileWriter("./testBufferedWriter.txt"));
			fileWriter.write(Arrays.asList("No Line", "Answer Machine", "Busy", "\nSIT", "SIT", "Busy").toString());  
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fileWriter != null) {
				try {
					fileWriter.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void javaIOFileInputStream() {
		FileInputStream fileReader = null;
		try {
			fileReader = new FileInputStream("./testFileWriter.txt");
			int read;
			while((read = fileReader.read()) != -1) {
				System.out.println(read);  // NOTE! Se puede escribir en otro archivo después de cada lectura.
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fileReader != null) {
				try {
					fileReader.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void javaIOFile() {
		try {
			
		File file = new File("./", "newFile.txt");
		file.createNewFile();
		
		File tempFile = File.createTempFile("temp", ".tmp");
		System.out.println(tempFile.getAbsolutePath());
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void javaFiles() {
		// Files: file management: exists, isWritable, isExcecutable, isSameFile, deleteIfExists, copy, move, createFile, createTempFile, bufferedReader, bufferedWriter
		// inputStream, outputStream, getRootDirectories, directoryStream, createDirectory, createTempDirectory
		Path path = Paths.get("testFileIII.txt");	
		if(Files.notExists(path)) {
			System.out.println("Path does not exist.");
			try {
				Files.createFile(path);
				BufferedWriter bufferedWriter = Files.newBufferedWriter(path);
				bufferedWriter.write("New test line."); 
				bufferedWriter.close();
				
				ArrayList<String> toRead = (ArrayList<String>) Files.readAllLines(path);
				toRead.stream()
				.forEach(System.out::println); 
				
				Path toCopy = Paths.get("./new/");
				Files.copy(path, toCopy, StandardCopyOption.REPLACE_EXISTING);
				
				Files.deleteIfExists(Paths.get("./new/testFileIII.txt"));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void javaFilesStreamAPI() {
		// Files: file management: exists, isWritable, isExcecutable, isSameFile, deleteIfExists, copy, move, createFile, createTempFile, bufferedReader, bufferedWriter
		// inputStream, outputStream, getRootDirectories, directoryStream, createDirectory, createTempDirectory
		Path path = Paths.get("../../");	
		try {
			
			System.out.println("Files.list");
			Stream<Path> stream = Files.list(path);
			stream.map(String::valueOf)
			.filter(p -> p.startsWith("."))
			.forEach(System.out::println);
			System.out.println("");
			
			System.out.println("Files.find");
			Stream<Path> directoryTree = Files.find(path, 5, (p,a)-> String.valueOf(path).endsWith(".txt"));
			directoryTree.sorted().map(String::valueOf).forEach(System.out::println); 
			System.out.println("");
			
			System.out.println("Files.walk");
			Stream<Path> walkingDirectoryTree = Files.walk(path);
			walkingDirectoryTree.sorted().forEach(System.out::println); 
			System.out.println("");
			
			System.out.println("Files.lines");
			Files.lines(path, Charset.forName("Cp1252")).map(s->s.split(";")).collect(Collectors.toList()).forEach(System.out::println); 
			System.out.println("");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// Output:
		javaIOFileOutputStream();
		javaIOBufferOutputStream();
		javaIOFileWriter();
		javaIOBufferedWriter();
		// Input:
		javaIOFileInputStream();
		// FIle:
		javaIOFile();
		// NIO2 - Files
		javaFiles();
		javaFilesStreamAPI();
	}

}
