package p11_Online_Radio_Database;

import p11_Online_Radio_Database.exceptions.*;

public class Song {
    private String artist;
    private String name;
    private Integer seconds;
    private Integer minutes;

    public Song(String artist, String name, String minutes , String seconds) throws InvalidSongException {
        this.setArtist(artist);
        this.setName(name);
        this.checkLength(minutes, seconds);
        this.setMinutes(Integer.parseInt(minutes));
        this.setSeconds(Integer.parseInt(seconds));
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String artist) throws InvalidArtistNameException {
        if (artist.length() < 3 || artist.length() > 20) {
            throw new InvalidArtistNameException("Artist name should be between 3 and 20 symbols.");
        }
        this.artist = artist;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) throws InvalidSongNameException {
        if (name.length() < 3 || name.length() > 30) {
            throw new InvalidSongNameException("Song name should be between 3 and 30 symbols.");
        }

        this.name = name;
    }

    public Integer getSeconds() {
        return this.seconds;
    }

    public void setSeconds(Integer seconds) throws InvalidSongSecondsException {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException("Song seconds should be between 0 and 59.");
        }
        this.seconds = seconds;
    }

    public Integer getMinutes() {
        return this.minutes;
    }

    public void setMinutes(Integer minutes) throws InvalidSongMinutesException {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException("Song minutes should be between 0 and 14.");
        }
        this.minutes = minutes;
    }

    private void checkLength(String minutes, String seconds) throws InvalidSongLengthException {
        try {
            int currentMinutes = Integer.parseInt(minutes);
            int currentSeconds = Integer.parseInt(seconds);
        } catch (NumberFormatException ex) {
            throw new InvalidSongLengthException("Invalid song length.");
        }
    }
}
