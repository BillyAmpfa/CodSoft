import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import org.json.JSONObject;

public class CurrencyConvert
{
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);
		DecimalFormat fmt = new DecimalFormat("##0.00"); 
		
		System.out.println("\t\tCurrency Converter\n");
		
		//Currency Selection
        System.out.print("Enter the base currency code (e.g., USD): ");
        String baseCurrency = in.nextLine();
		
        System.out.print("Enter the target currency code (e.g., ZAR): ");
        String targetCurrency = in.nextLine();
		
		//Amount Input 
		System.out.print("Enter the amount you want to convert: ");
		double baseAmount = in.nextDouble();
		
		try
		{
			//Method to get exchange rate from a API
			double exchangeRate = getExchangeRate(baseCurrency,targetCurrency);
			
			//Currency Conversion
			double convertedAmount = baseAmount * exchangeRate;
			
			//Display Results
		   System.out.println("Results\n" + fmt.format(baseAmount) + " " + baseCurrency + " = " + fmt.format(convertedAmount) + " " + targetCurrency);
		}catch (IOException e) {
            System.out.println("Error fetching exchange rates, try again later.");
        }finally{
            in.close();
        }
	}
	
	private static double getExchangeRate(String baseCurrency, String targetCurrency) throws IOException
	{
		//Get API key from exchange rate API
		String API_KEY= "80ff8fe2984d49a48781dfd5"; 
		
		//Set the URL to get exchange rate
        String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY+ "/pair/" + baseCurrency + "/" + targetCurrency;
		//testing API: https://v6.exchangerate-api.com/v6/80ff8fe2984d49a48781dfd5/pair/USD/ZAR
		
        URL url = new URL(API_URL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        
        int responseCode = connection.getResponseCode();
		
        if (responseCode == HttpURLConnection.HTTP_OK) 
		{
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();
            String line;
			
            while ((line = reader.readLine()) != null) 
			{
                response.append(line);
            }reader.close();
			
			JSONObject obj = new JSONObject(response.toString());
			double exchangeRate = obj.getBigDecimal("conversion_rate").doubleValue();

			return exchangeRate;
		}else{
            throw new IOException("Failed to fetch exchange rates. HTTP Error Code: " + responseCode);
        }
		
	}
	
}