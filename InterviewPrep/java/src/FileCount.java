import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class FileCount {
	
	 private static final String path = "/Users/anshuljain/git/interview/InterviewPrep/src/";
	    public static void main(String[] args) throws IOException, URISyntaxException {
	    	int i=0;
	    
	        System.out.println("Path:" + path);
	        try (Stream<Path> fileList = Files.find(Paths.get(path), Integer.MAX_VALUE,
	                (filePath, fileAttr) -> fileAttr.isRegularFile() && filePath.toString().endsWith("java"))) {
	            List<String> someThingNew = fileList.sorted().map(String::valueOf).collect(Collectors.toList());
	            for (String t : someThingNew) {
	                i++;
	               
	            }
	            System.out.println("File count:" + i);
	        }
	    	/*
	    	
	    	//System.out.println(System.getProperty("user.dir"));
	        File directory = new File(PATH);
	   
	        File[] fileList = directory.listFiles(new MyFilter());
	        for (File file : fileList) System.out.println(file.getName());
	        
	        Files.walk(Paths.get(MyClass.class.getResource(".").toURI()))
	        .filter(Files::isRegularFile)
	        .forEach(System.out::println);
	    */}
	}
	class MyFilter implements FilenameFilter {
	    @Override
	    public boolean accept(File dir, String name) {
	        return name.endsWith(".java");
	    }
	}

  


