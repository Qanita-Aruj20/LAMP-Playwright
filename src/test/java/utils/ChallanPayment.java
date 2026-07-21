package utils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ChallanPayment {

    private static final String URL =
            "https://qa-pulsegateway.lmkr.com/ThirdPartyAPIs/bop/SendBOPIntimation";

    // Correct API Key (same as Postman)
    private static final String API_KEY =
            "MMnwTePp!JytX7LuB3nY6sRE!n5BcQ";

    public static void payChallan(String challanNumber, String amount)
            throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        String requestBody =
                "{"
                        + "\"challanNumber\":\"" + challanNumber + "\","
                        + "\"cashierName\":\"Ali\","
                        + "\"branchCode\":\"12345\","
                        + "\"branchName\":\"Johar Town\","
                        + "\"consumerType\":\"bop\","
                        + "\"totalAmount\":" + amount + ","
                        + "\"organizationUserId\":8"
                        + "}";

        System.out.println("============= PAYMENT REQUEST =============");
        System.out.println("URL : " + URL);
        System.out.println("API KEY : " + API_KEY);
        System.out.println(requestBody);
        System.out.println("===========================================");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("accept", "*/*")
                .header("Content-Type", "application/json")
                .header("X-Api-Key", API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("============= PAYMENT RESPONSE ============");
        System.out.println("Status Code : " + response.statusCode());
        System.out.println(response.body());
        System.out.println("===========================================");

        if (response.statusCode() != 200) {
            throw new RuntimeException(
                    "Payment API Failed.\nStatus="
                            + response.statusCode()
                            + "\nResponse="
                            + response.body());
        }

        System.out.println("✓ Challan Paid Successfully");
    }
}