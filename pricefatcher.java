import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner;

public class pricefatcher {
	public static void main(String[] args) throws IOException  {
		String ticker = args[0];
		System.out.println("This is your ticker: " + ticker);

		String formattedURL = "https://sandbox.iexapis.com/stable/stock/" + ticker + "/price?token=Tpk_16fd8cf2725940919d09516804f03a71";
		System.out.println(formattedURL);	
		URL url = new URL(formattedURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		

		// Read the data in the url. 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Store the data at the url here as a string. 
        String price = response.toString();
        
        //print in String
        System.out.println(price);

		
	}
}