package com.company.recordstoreapi.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Record {

    @NotEmpty(message = "You must supply a value for artist.")
    private String artist;
    @NotEmpty(message = "You must supply a value for album.")
    private String album;
    @NotEmpty(message = "You must supply a value for year.")
    @Size(min = 4, max = 4, message = "Year must be exactly 4 digits.")
    private String year;
    private int id;

    public Record() { }

    public Record(String artist, String album, String year, int id) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return getId() == record.getId() &&
                Objects.equals(getArtist(), record.getArtist()) &&
                Objects.equals(getAlbum(), record.getAlbum()) &&
                Objects.equals(getYear(), record.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArtist(), getAlbum(), getYear(), getId());
    }
}
