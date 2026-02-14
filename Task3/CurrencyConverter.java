import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
public class CurrencyConverter 
{
    private static final String API_URL="https://api.exchangerate-api.com/v4/latest/";
    private static double fetchRate(String fromCurr,String toCurr) 
    {
        try 
        {
            HttpClient httpClient=HttpClient.newHttpClient();
            HttpRequest httpRequest=HttpRequest.newBuilder().uri(URI.create(API_URL+fromCurr)).GET().build();
            HttpResponse<String> httpResponse=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
            String jsonData=httpResponse.body();
            return extractRate(jsonData,toCurr);

        } 
        catch (IOException | InterruptedException e) 
        {
            System.out.println("Unable to retrieve exchange rate.");
            return -1;
        }
    }
    private static double extractRate(String json,String currencyCode) 
    {
        String pattern="\""+currencyCode+"\":";
        int position=json.indexOf(pattern);
        if (position==-1) 
        {
            return -1;
        }
        int valueStart=position+pattern.length();
        int valueEnd=json.indexOf(",",valueStart);
        if (valueEnd==-1) 
        {
            valueEnd=json.indexOf("}",valueStart);
        }
        String rateValue=json.substring(valueStart,valueEnd);

        return Double.parseDouble(rateValue);
    }
    private static String readCurrencyCode(Scanner sc,String message) 
    {
        while (true) 
        {
            System.out.print(message);
            String input=sc.next().trim().toUpperCase();
            if (input.matches("[A-Z]{3}")) {
                return input;
            }
            System.out.println("Please enter a valid 3-letter currency code (e.g., USD, INR, EUR).");
        }
    }
    public static void main(String[] args) 
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("========== Currency Converter ==========");
        String baseCurrency=readCurrencyCode(sc, "Enter base currency: ");
        String targetCurrency=readCurrencyCode(sc, "Enter target currency: ");
        System.out.print("Enter amount to convert: ");
        double amount=sc.nextDouble();
        double exchangeRate = fetchRate(baseCurrency, targetCurrency);
        if (exchangeRate<=0) 
        {
            System.out.println("Conversion could not be completed.");
            return;
        }
        double result=amount*exchangeRate;
        System.out.printf("\n1 %s = %.4f %s\n",baseCurrency,exchangeRate,targetCurrency);
        System.out.printf("Converted Amount: %.2f %s\n",result,targetCurrency);
    }
}
