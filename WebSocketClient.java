import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.URISyntaxException;

public class WazirXWebSocketClient extends WebSocketClient {

    public WazirXWebSocketClient(String uri) throws URISyntaxException {
        super(new URI(uri));
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        System.out.println("Connected to WebSocket");
        // Subscribe to BTC/INR market data
        subscribeToMarketData("btcinr");
    }

    @Override
    public void onMessage(String message) {
        JsonObject json = JsonParser.parseString(message).getAsJsonObject();
        // Handle incoming market data
        handleMarketData(json);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("WebSocket closed: " + reason);
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }

    private void subscribeToMarketData(String pair) {
        JsonObject subscribeMessage = new JsonObject();
        subscribeMessage.addProperty("event", "subscribe");
        subscribeMessage.addProperty("pair", pair);
        this.send(subscribeMessage.toString());
    }

    private void handleMarketData(JsonObject json) {
        // Extract and process market data
        String pair = json.get("pair").getAsString();
        double price = json.get("price").getAsDouble();
        System.out.println("Market data received for " + pair + ": " + price);
    }

    public static void main(String[] args) throws URISyntaxException {
        WazirXWebSocketClient client = new WazirXWebSocketClient("wss://stream.wazirx.com/stream");
        client.connect();
    }
}
