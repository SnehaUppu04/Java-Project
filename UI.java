import java.util.Scanner;

public class CLI {
    private static double triggerBuyPrice;
    private static double triggerSellPrice;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter trigger price for buy order:");
        triggerBuyPrice = scanner.nextDouble();

        System.out.println("Enter trigger price for sell order:");
        triggerSellPrice = scanner.nextDouble();

        System.out.println("Trigger prices set. Monitoring market...");

        // Start WebSocket client
        try {
            WazirXWebSocketClient client = new WazirXWebSocketClient("wss://stream.wazirx.com/stream");
            client.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        while (true) {
            // Simulate checking market data and preparing payloads
            // This is where you would check the market data and prepare the payloads
        }
    }

    public static void handleMarketData(double price) {
        if (price <= triggerBuyPrice) {
            System.out.println("Trigger price hit for buy order.");
            System.out.println("Prepared Buy Payload: " + OrderPayload.prepareBuyPayload(price));
        }

        if (price >= triggerSellPrice) {
            System.out.println("Trigger price hit for sell order.");
            System.out.println("Prepared Sell Payload: " + OrderPayload.prepareSellPayload(price));
        }
    }
}
