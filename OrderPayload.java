public class OrderPayload {

    public static JsonObject prepareBuyPayload(double price) {
        JsonObject payload = new JsonObject();
        payload.addProperty("operation", "buy");
        payload.addProperty("price", price);
        // Add other necessary order details
        return payload;
    }

    public static JsonObject prepareSellPayload(double price) {
        JsonObject payload = new JsonObject();
        payload.addProperty("operation", "sell");
        payload.addProperty("price", price);
        // Add other necessary order details
        return payload;
    }

    public static JsonObject prepareCancelPayload(String orderId) {
        JsonObject payload = new JsonObject();
        payload.addProperty("operation", "cancel");
        payload.addProperty("orderId", orderId);
        // Add other necessary cancellation details
        return payload;
    }
}
