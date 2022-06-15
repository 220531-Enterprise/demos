package com.revature;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
 * com.sun.net.httpserver is not an API (there is an access restriction, and Eclipse indicate this as error).
 * You need to add an access rule "Accessible" for the pattern com/sun/net/httpserver/**:
 * 
 * Follow the second answer (with 50+ upvotes):
 * https://stackoverflow.com/questions/13155734/eclipse-cant-recognize-com-sun-net-httpserver-httpserver-package
 */
public class App {
	/*
	 * Step 1a. Copy War and Peace into workspace.
	 * 
	 * Step 1b. Save the path of book resource as a final String variable;
	 */
    private static final String INPUT_FILE = "C:\\Users\\SophieGavrila\\Desktop\\demos\\3-javaSE-apis\\throughput-http-server\\src\\main\\resources\\war_and_peace.txt";
    
    // variable passed to executor to control thread pool size
    private static final int NUMBER_OF_THREADS = 4;

    public static void main(String[] args) throws IOException {
		// Step 2. Save the entire content of file into a String obj in heap.
    	String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));  // This method returns a byte array of the
																			  // text file
    	// Step 3. pass it to startServer() method -- we have yet to create this.
        startServer(text);
    }

    public static void startServer(String text) throws IOException {
		/*
		 * Step 4. Create start server method by calling HttpServer.create() method.
		 * 
		 * 1st param: Takes address of our localhost an port we want to listen on from
		 * com.sun.net package in the form of SocketAddress object.
		 * 
		 * 2nd param is backlog size which is size of queue for HTTP server requests. We
		 * keep it at 0 because all requests should end up in the thread pool queue
		 * instead
		 */
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        
        /*
		 * Step 5. Create a context which assigns a handler object to a specific http
		 * route. This handler handles each incoming http request and sends a response.
		 */
        server.createContext("/search", new WordCountHandler(text));  // we will create this handler class soon.

		/*
		 * Step 6. Create the executor which will schedule each incoming http request to
		 * a pool of threads. Set the deault thread pool to 1.
		 */
        Executor executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        
    	// pass executor to Http Server
        server.setExecutor(executor);
        
        server.start();
        
		/*
		 * =============================================================== 
		 * Once the server's start() method is called our app will 
		 * start listening to incoming requests on port 8000
		 * 
		 * Every incoming req that belongs to "search" route will be handled by
		 * WordCountHandler and executed on 1 of the threads in the fixed thread pool.
		 * ===============================================================
		 */

    }

    /* ============================================================================
	 * Step 7. Implement WordCountHandler class itself which implements the logic of
	 * searching for the word and counting its recurrence throughout the text.
	 * ============================================================================
	 */
    private static class WordCountHandler implements HttpHandler {
        private String text;

        public WordCountHandler(String text) {
            this.text = text;
        }

    	/*
		 * What is HttpExchange param?
		 * 
		 * This class encapsulates a HTTP request received and a response to be
		 * generated in one exchange. 
		 * 
		 * It provides methods for examining the request from
		 * the client, and for building and sending the response.
		 */
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String query = httpExchange.getRequestURI().getQuery();
            
        	/* since the split generates 2 values in an array, the first would be
			 * the string "word" and the second would be the actual word bwe want 
			 * to search for 
			 */ 
            String[] keyValue = query.split("=");
            String action = keyValue[0];
            String word = keyValue[1];
            
            // Check that the query param key is indeed correct
            if (!action.equals("word")) {
                httpExchange.sendResponseHeaders(400, 0);
                return;
            }

            String count = countWord(word);

            // then convert the count into a byte array we can serialize and send thru HTTP
            byte[] response = count.getBytes();
            httpExchange.sendResponseHeaders(200, response.length);

            // We will represent out response body as an OutputStream
            OutputStream outputStream = httpExchange.getResponseBody();
           
 			// then write repsonse body into http ReponseBody Output stream
 			outputStream.write(response);
 			
 			// when we close the stream it automatically sends the response to the client
 			outputStream.close();
        }

		/*
		 * Step 8.
		 * Create the count word method which takes in the word it needs to look for as an arg.
		 */
        private String countWord(String word) {
        	
        	System.out.println("countWord() method triggered");
        	
            long count = 0;
            int index = 0;
    		/*
			 * Run a loop.
			 * in every iteration look for the next appearance of the word in the text
			 */
            while (index >= 0) {
            	
                index = text.indexOf(word, index);

                // if index is positive, we successfully found the word in the book.
                if (index >= 0) {
                    count++;  
                    index++; // increment index so that we can keep searching for the 
					 		 // word again starting from the next position in in the book.
                }
            }
            
        	/* 
			 * if the index is negative that means there are no more occurences of
			 * the word in the book, so we exit the loop and return count;
			 */
            return "The word \"" + word + "\" appeared " + count + " times";
        }
    }
}