import java.util.Objects;

public class GeneralHandler extends Handler {
    @Override
    public void handleRequest(Message message) {
        //check if we can handle it here
        if(Objects.equals(message.messageType, "General")){
            System.out.println("Message type is" + message.messageType + "It was handled by GeneralHandler");

        }
        else {
            System.out.println("Message type " + message.messageType + "cannot be handled by GeneralHandler, sending to the next handler");
            this.nextHandler.handleRequest(message);
        }

    }

}
