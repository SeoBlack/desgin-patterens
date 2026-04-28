public class FacadeMain {
        public static void main(String[] args) {

            ApiFacade api = new ApiFacade();

            // Chuck Norris Joke
            try {
                String joke = api.getAttributeValueFromJson(
                        "https://api.chucknorris.io/jokes/random",
                        "value"
                );
                System.out.println("Joke: " + joke);

            } catch (Exception e) {
                System.out.println("Error fetching joke: " + e.getMessage());
            }

            //Exchange Rates API
            try {
                String base = api.getAttributeValueFromJson(
                        "https://api.fxratesapi.com/latest",
                        "base"
                );
                System.out.println("Base currency: " + base);

            } catch (Exception e) {
                System.out.println("Error fetching FX data: " + e.getMessage());
            }

            //error handlling
            try {
                api.getAttributeValueFromJson(
                        "https://api.chucknorris.io/jokes/random",
                        "nonexistent" // falsy attribute
                );

            } catch (IllegalArgumentException e) {
                System.out.println("Expected error: " + e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
