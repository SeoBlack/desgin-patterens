import java.util.Objects;

public class CompensationHandler extends Handler {
    @Override
    public void handleRequest(Message message) {
        //check if we can handle it here
        if(Objects.equals(message.messageType, "Compensation")){
            System.out.println("Message type is" + message.messageType + "It was handled by CompensationHandler");
        }
        else {
            System.out.println("Message type " + message.messageType + "cannot be handled by Compensation, sending to the next handler");
            this.nextHandler.handleRequest(message);
        }

    }
}
