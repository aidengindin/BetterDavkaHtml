import java.io.FileNotFoundException;

public class BetterDavkaMain {

    public static BetterDavkaHtml betterDavkaHtml;

    public static void main(String[] args) throws FileNotFoundException {
        betterDavkaHtml = new BetterDavkaHtml("page39.htm");
        betterDavkaHtml.getOutput();
    }
}
