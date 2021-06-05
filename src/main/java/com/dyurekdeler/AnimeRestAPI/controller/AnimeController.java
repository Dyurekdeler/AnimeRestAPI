package com.dyurekdeler.AnimeRestAPI.controller;

import com.dyurekdeler.AnimeRestAPI.customexception.AnimeNotFoundException;
import com.dyurekdeler.AnimeRestAPI.model.Anime;
import com.dyurekdeler.AnimeRestAPI.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AnimeController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/animes")
    public List<Anime> listAnimes(){
        return animeRepository.findAll();
    }

    @GetMapping("/animes/{id}")
    public Anime findAnime(@PathVariable Long id){
        return animeRepository.findById(id).orElseThrow(() -> new AnimeNotFoundException(id));
    }

    @PostMapping("/animes")
    public Anime createAnime(@RequestBody Anime anime){
        return animeRepository.save(anime);

    }

    @PutMapping("/animes/{id}")
    public Anime updateAnime(@RequestBody Anime updatedAnime, @PathVariable Long id){
        return animeRepository.findById(id)
                .map(anime -> {
                    anime.setTitle(updatedAnime.getTitle());
                    return animeRepository.save(anime);
                })
                .orElseGet(() -> {
                    updatedAnime.setId(id);
                    return animeRepository.save(updatedAnime);
                });

    }

    @DeleteMapping("/animes/{id}")
    public void deleteAnime(@PathVariable Long id){
        animeRepository.deleteById(id);
    }

}
