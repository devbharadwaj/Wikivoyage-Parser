/**
 * 
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.solr.common.SolrInputDocument;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path, XMLDump = null;
		Properties properties = new Properties();
		try{
			properties.load(new FileInputStream("files/properties.config"));
			path = properties.getProperty("root.dir");
			XMLDump = properties.getProperty("dump.filename");
			XMLDump = path + XMLDump;
			System.out.println("dump:"+XMLDump);
		}catch (IOException e){
			System.err.println("XML dump is invalid or doesn't exist!!");
		}
		if (XMLDump == null){
			System.err.println("No XML dump specified!");
		}
			
		Parser parser = new Parser();
			
		parser.parse(XMLDump);
		
	}
}
		
	