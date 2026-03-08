
public abstract class Handler {
    Handler nextHandler;
    void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleRequest(Message message);
}
