public class MentalHealth {

    private final static String separator = "------------------------------";
    private final static String greetingMessage = "Hello! I'm your friendly ChatBot assistant called MentalHealth :)\n" +
            "What can I do for you?";

    private final static String goodbyeMessage = "Bye. Hope to see you again soon! If you ever need help don't forget to reach out :)";
    public static void main(String[] args) {
        Greeting greeting = new Greeting(greetingMessage, separator);
        Goodbye goodbye = new Goodbye(goodbyeMessage, separator);
        Echo echo = new Echo(separator);
        System.out.println(greeting);
        echo.echoMessage();
        System.out.println(goodbye);
    }

}
