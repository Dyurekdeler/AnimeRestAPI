package com.dyurekdeler.AnimeRestAPI.customexception;

public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException(Long id){
        super("Could not find Anime with id: " + id);
    }
}
