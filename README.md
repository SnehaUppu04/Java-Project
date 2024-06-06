# Java-Project
# WazirX WebSocket Client

## Setup

1. Clone the repository.
2. Open the project in your preferred Java IDE.
3. Add the necessary dependencies:
   - Java-WebSocket
   - Gson

## Usage

1. Run the `CLI` class.
2. Input the trigger prices for buy and sell orders.
3. The application will display prepared payloads when the market price hits the trigger prices.

## Design Decisions

- **WebSocket Library**: Java-WebSocket for handling WebSocket connections.
- **JSON Parsing**: Gson for easy JSON parsing and payload preparation.
- **Logging**: Custom logger implementation for error and action logging.
