package p11_Online_Radio_Database;

import p11_Online_Radio_Database.exceptions.InvalidSongException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Playlist playlist = new Playlist();

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split(";");
            String artist = tokens[0];
            String songName = tokens[1];
            String[] time = tokens[2].split(":");

            String minutes = time[0];
            String seconds = time[1];

            try {
                Song song = new Song(artist, songName, minutes, seconds);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.printf("Songs added: %d\n", playlist.getSongsCount());
        System.out.println(playlist.getTotalPlaylistLength());
    }
}
