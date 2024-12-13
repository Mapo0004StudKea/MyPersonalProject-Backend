package stud.kea.dk.mypersonalprojectbackend.anime.service;

import org.springframework.stereotype.Service;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.repository.AnimeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    public Anime getAnimeById(long id) {
        return animeRepository.findById(id).orElse(null);
    }
}
