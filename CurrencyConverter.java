package CodSoftTask4;

import org.json.JSONObject;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {


    public static double getExchangeRate(String BaseCurrency, String TargetCurrency) {
        try {
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + BaseCurrency;
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String Line;

            while ((Line = reader.readLine()) != null){
                response.append(Line);
            }
            reader.close();


            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject rates = jsonObject.getJSONObject("rates");

            return rates.getDouble(TargetCurrency);


        } catch (Exception e) {
            System.out.println("Error Fetching Exchange Rate : " + e);
            return -1;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======= CURRENCY CONVERTER ========");

        System.out.print("Enter Base Currency (USD, INR, EUR): ");
        String baseCurrency = sc.next().toUpperCase();

        System.out.print("Enter Target Currency (USD, INR, EUR) : ");
        String targetCurrency = sc.next().toUpperCase();

        System.out.print("Enter Amount to convert : ");
        double amount = sc.nextDouble();

        double rate = getExchangeRate(baseCurrency, targetCurrency);

        if (rate == -1){
            System.out.println("Coversion failed try again !");
            return;
        }

        double ConvertAmount = amount * rate;

        //display result

        System.out.println("Exchange Rate : 1"+ baseCurrency+" = "+rate+" "+targetCurrency);
        System.out.println("Coverted Amount : "+ConvertAmount+" "+targetCurrency);

    }
}