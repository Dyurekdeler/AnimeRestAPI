package com.dyurekdeler.AnimeRestAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Anime {

    @Id
    @GeneratedValue
    private Long id;
    private String title;

    public Anime() {
    }

    public Anime(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if(!(o instanceof Anime))
            return false;
        Anime anime = (Anime) o;
        return Objects.equals(this.id, anime.id) && Objects.equals(this.title, anime.title);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id, this.title);
    }

    @Override
    public String toString(){
        return "Title:" + this.title + " (Id: " + this.id + " )";
    }
}
