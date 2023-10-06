public class ArtistImplementation implements Artist {
    private  String name;
    private  int albumsCount;

    public ArtistImplementation(final String name, int albumsCount) {
        this.name = name;
        this.albumsCount = albumsCount;

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getAlbumsCount() {
        return this.albumsCount;
    }
}