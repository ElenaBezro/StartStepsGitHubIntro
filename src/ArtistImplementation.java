public class ArtistImplementation implements Artist {
    private  String name;

    public ArtistImplementation(final String name) {
        this.name = name;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return name;
    }
}