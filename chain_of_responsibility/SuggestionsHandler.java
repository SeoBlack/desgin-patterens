import java.util.Objects;

public class SuggestionsHandler extends Handler {
    @Override
    public void handleRequest(Message message) {
        //check if we can handle it here
        if(Objects.equals(message.messageType, "Suggestions")){
            System.out.println("Message type is" + message.messageType + "It was handled by Suggestions Handler");

        }
        else {
            System.out.println("Message type " + message.messageType + "cannot be handled by Suggestions Handler, sending to the next handler");
            this.nextHandler.handleRequest(message);
        }

    }
}
