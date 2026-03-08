import java.util.Objects;

public class ContactHandler extends Handler {
    @Override
    public void handleRequest(Message message) {
        //check if we can handle it here
        if(Objects.equals(message.messageType, "Contact")){
            System.out.println("Message type is" + message.messageType + "It was handled by ContactHandler");
        }
        else {
            System.out.println("Message type " + message.messageType + "cannot be handled by ContactHandler, sending to the next handler");
            this.nextHandler.handleRequest(message);
        }

    }
}
