import java.util.Scanner;

public class Chian {
    static public  void main(String args[]) {

        Handler suggestionsHandler = new SuggestionsHandler();
        Handler contactHandler = new ContactHandler();

        Handler chain  = new GeneralHandler();
        chain.setNextHandler(new CompensationHandler());
        chain.nextHandler.setNextHandler(suggestionsHandler);
        chain.nextHandler.nextHandler.setNextHandler(contactHandler); // there is something wrong here, but I don't know what it is. for example what if we had more than 10 handers? this would take forever!





        Message message = new Message("General");
        Message message2 = new Message("Compensation");

        chain.handleRequest(message);
        chain.handleRequest(message2);

    }
}
