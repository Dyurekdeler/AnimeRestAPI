package com.dyurekdeler.AnimeRestAPI.repository;

import com.dyurekdeler.AnimeRestAPI.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimeRepository  extends JpaRepository<Anime, Long> {
}
