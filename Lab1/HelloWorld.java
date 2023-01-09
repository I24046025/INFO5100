/**
 * Assignment 1
 * Kehsin Yu
 * 002747728
 * Section 08
 */
public class HelloWorld {

    private String word;

    public HelloWorld(String greeting) {
        word = greeting;
    }

    public String getGreeting(){
        return word;
    }

    public void greet() {
        System.out.println(getGreeting());
    }

    public static void main (String args[]) {
        HelloWorld helloworld = new HelloWorld("Hello World");
        helloworld.greet();
    }
}