/**
 * 
 */
package openweb.wmc.java.eight.flow.io;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class JavaIO {

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
	}

}
