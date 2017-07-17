import java.io.*;
import java.util.Scanner;

/**
 * Split the HTML outputted by DavkaWriter into separate HTML & CSS files
 */
public class BetterDavkaHtml {


    /**
     * The file from DavkaWriter we're fixing
     */
    private Scanner input;


    /**
     * The name of the file, minus its extension
     */
    private String shortName;


    /**
     * Output HTML file
     */
    private PrintStream html;


    /**
     * Output CSS file
     */
    private PrintStream css;


    public BetterDavkaHtml(String name) throws FileNotFoundException {
        this.input = new Scanner(new File(name));
        this.shortName = name.substring(0, name.length() - 4);
        this.html = new PrintStream(new File(shortName + ".html"));
        this.css = new PrintStream(new File(shortName + ".css"));
    }


    /**
     * Split up the input file into HTML & CSS
     */
    public void getOutput() throws FileNotFoundException {
        boolean isCss = false;
        String current;
        while (input.hasNextLine()) {  // Keep going as long as there's still more HTML
            current = input.nextLine();
            if (current.equals("</title><style type=\"text/css\">")) {  // Start of CSS
                html.println("</title>");
                isCss = true;
            } else if (current.equals("</style></head>")) { // End of CSS
                html.println("<link href=\"" + shortName + ".css\" type=\"text/css\" rel=\"stylesheet\"></head>");
                isCss = false;
            } else {
                (isCss ? css : html).println(current);
            }
        }
    }
}
