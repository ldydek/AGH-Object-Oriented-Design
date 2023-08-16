package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;

public class Music extends Item {

    private MusicGenre musicGenre;
    private boolean hasVideo;

    public Music(String name, Category category, int price, int quantity, MusicGenre musicGenre, boolean hasVideo) {
        super(name, category, price, quantity);
        this.musicGenre = musicGenre;
        this.hasVideo = hasVideo;
    }

    public MusicGenre getGenre() {
        return musicGenre;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }
}
