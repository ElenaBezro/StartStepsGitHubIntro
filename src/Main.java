import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Ctrl+D to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Cmd+F8.
            System.out.println("i = " + i);
        }
        ArtistImplementation artist1 = new ArtistImplementation("Taylor Swift");
        ArtistImplementation artist2 = new ArtistImplementation("Ed Sheeran");
        ArtistImplementation artist3 = new ArtistImplementation("Adele");
        ArtistImplementation artist4 = new ArtistImplementation("Beyonce");

        ArtistsImplementation artists = new ArtistsImplementation();

        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);

        List<Artist> searchResult = artists.search("swif");
        for (Artist artist : searchResult) {
            System.out.println("Artist: " + artist.getName());
        }
    }
}