package Z.Pruebas.test;

import java.util.Scanner;

public class Test {

	  public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        
	        // Input variables:
	        StringBuffer input = new StringBuffer();
	        Scanner reader=null;
	        int expectedN = 0;
	        int receivedN = 0;
	        
	        // Output variables:
	        StringBuffer output = new StringBuffer();
	                
	        try{
	            reader= new Scanner(System.in);    
	        
	            // Programm:
	            expectedN = Integer.parseInt(reader.nextLine());
	            System.out.println("Expected: " + expectedN);
	          while(reader.hasNext()){
	                String character = reader.nextLine();
	                System.out.println("Char: " + character);
	                if(character.equals("\n")){
	                    receivedN++;  
	                    System.out.println("Received: " + receivedN);
	                }
	                input.append(character);
	            }
	          
	        
	            if(receivedN >= 1){
	                if(expectedN == receivedN){
	                String[] lines = input.toString().split("-");
	                    for(int i=0;i<lines.length;i++){
	                        String batch = lines[i];
	                        if(batch.isEmpty()){
	                            output.append("FAILURE => WRONG INPUT (LINE "+i+1+")\n");
	                        }else {
	                            String[] events = batch.split(" ");
	                            for(int j=0; j<events.length; j++){
	                                String event = events[j];
	                                if(event.isEmpty()){
	                                    output.append("FAILURE => WRONG INPUT (LINE "+j+1+"\n")                                     ;
	                                } else{
	                                    try{
	                                        int eventNumber = Integer.parseInt(event);
	                                    }catch(Exception e){
	                                        output.append("FAILURE => WRONG INPUT (LINE "+j+1+"\n");
	                                    }
	                                }
	                            }
	                        }
	                    }
	                    output.append("SUCESS => RECEIVED: "+receivedN+"\n");
	                } else {
	                    output.append("FAILURE => RECEIVED:"+receivedN+", EXPECTED:"+expectedN                      +"\n");
	                }
	            
	            } else{
	            output.append("FAILURE => RECEIVED:" + receivedN + ", EXPECTED: N>=1\n");
	            }
	            System.out.println(output.toString());
	        } catch (Exception e){
	            e.printStackTrace();
	        }finally{
	            if(reader!=null){
	                try{
	                    reader.close();
	                } catch(Exception e){
	                    e.printStackTrace();
	                }
	            }
	        }
	      
	    }
	}


