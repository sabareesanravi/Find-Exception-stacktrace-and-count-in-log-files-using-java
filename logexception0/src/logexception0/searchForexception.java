package logexception1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

class searchForexception {
	Map <String,FileDetails> fileMap=new LinkedHashMap<String,FileDetails>();
//	void printMap(){
//		for(Map.Entry<String, FileDetails> file : fileMap.entrySet())
//		{
//			System.out.println(file);
//		}
//	}
	boolean openFolder(int choice,String exceptionName,String pathName){
		if(choice>=4)
		{
			return false;
		}
		String filename="";
		File folder = new File(pathName);
		File[] listOfFiles = folder.listFiles();
		String key="";
		
		for (File file : listOfFiles) {
		  key=exceptionName.toLowerCase();
		  if (file.isFile()) { 
		    filename=file.getName();
		    System.out.println(filename);
		    key=key+filename.toLowerCase();
		    
		switch(choice){

		case 1:
			if(fileMap.containsKey(key)&&file.lastModified()==fileMap.get(key).getLastModifiedline()&&!fileMap.get(key).getLine().equals(""))
			{
				System.out.println("from cache");
				System.out.println(fileMap.get(key).getLine());
			}
			else
			{
			System.out.println("from file");
			String line="";
			line+=this.printLine(exceptionName,filename);
			FileDetails fileObject;
			if(fileMap.containsKey(key))
			{
			fileObject=fileMap.get(key);	
			}
			else
			{
			fileObject=new FileDetails();
			}
			fileObject.setLine(line);
			fileObject.lastModifiedline=file.lastModified();
			fileMap.put(key, fileObject);
			
			}
			break;

		case 2:
			if(fileMap.containsKey(key)&&file.lastModified()==fileMap.get(key).lastModifiedStackTrace&&!fileMap.get(key).getStacktrace().equals(""))
			{
				System.out.println("from cache");
				System.out.println(fileMap.get(key).getStacktrace());
			}
			else
			{
			System.out.println("from file");	
			String stacktrace="";
			stacktrace+=this.printStackTrace(exceptionName,filename);
			FileDetails fileObject;
			if(fileMap.containsKey(key))
			{
			fileObject=fileMap.get(key);	
			}
			else
			{
			fileObject=new FileDetails();
			}
			fileObject.setStacktrace(stacktrace);
			fileObject.lastModifiedStackTrace=file.lastModified();
			fileMap.put(key, fileObject);	
			
			}
			break;
			
		case 3:
			if(fileMap.containsKey(key)&&file.lastModified()==fileMap.get(key).lastModifiedStackTrace&&fileMap.get(key).getCount()!=-1)
			{
				System.out.println("from cache");
				System.out.println(fileMap.get(key).getCount());
			}
			else
			{
			System.out.println("from file");	
			int count=0;
			count=this.printCount(exceptionName, filename);
			FileDetails fileObject;
			if(fileMap.containsKey(key))
			{
			fileObject=fileMap.get(key);	
			}
			else
			{
			fileObject=new FileDetails();
			}
			fileObject.setCount(count);
			fileObject.lastModifiedcount=file.lastModified();
			fileMap.put(key, fileObject);	
			
			}
			break;
		default:
			return true;
		}
		
		  }
		}
		folder=null;
		return true;
		
	}
	
	String printLine(String exceptionName,String filename){
		String returnString="";
		try (FileInputStream fstream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\logs\\"+filename);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));){

			
		

			String strLine;
			boolean noexception=true;
			
			
			while ((strLine = br.readLine()) != null) {
				String strLineCopy=strLine;
				strLine=strLine.toLowerCase();
				if (strLine.contains(exceptionName.toLowerCase())){		// keyword
					System.out.println(strLineCopy);
					returnString+=strLineCopy;
					noexception=false;
				}
				
				
			}
			if(noexception)
			returnString="None";	
			System.out.println("None");
			
			
	
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		
	return returnString;	
	}
	
	String printStackTrace(String exceptionName,String filename){
		String returnString="";
		try (FileInputStream fstream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\logs\\"+filename);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));){

			String strLine;
			boolean noexception=true;

			while ((strLine = br.readLine()) != null) {
				
				String strLineCopy=strLine;
				strLine=strLine.toLowerCase();
				
				
				if (strLine.contains(exceptionName.toLowerCase())){		// keyword
					{
						noexception=false;
				while(strLineCopy.toLowerCase().contains("at")||strLineCopy.toLowerCase().contains("error")	||strLineCopy.toLowerCase().contains(exceptionName.toLowerCase())	){
					System.out.println(strLineCopy);
					strLineCopy=br.readLine();
					
					}
				}
				
				}
			}
			if(noexception)
			returnString="None";	
			System.out.println("None");
			
			in.close();
			br.close();
	
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return returnString;
	}
	
	int printCount(String exceptionName,String filename){
		
		int exceptionCount=0;
	
		try (FileInputStream fstream = new FileInputStream("C:\\Users\\Administrator\\Downloads\\logs\\"+filename);
				DataInputStream in = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(in));){
				
				exceptionCount=0;
				String strLine;
				while ((strLine = br.readLine()) != null) {

					strLine=strLine.toLowerCase();
					if (strLine.contains(exceptionName.toLowerCase())){		// keyword
						exceptionCount++;
					
					}
					 
				}
				
				System.out.println("count : "+exceptionCount);
		
			} catch (Exception e) {
				System.err.println("Error: " + e);
			}
		return exceptionCount;
	}
	
	
}
