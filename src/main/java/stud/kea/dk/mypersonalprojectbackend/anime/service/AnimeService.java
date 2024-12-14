package stud.kea.dk.mypersonalprojectbackend.anime.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.repository.AnimeRepository;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Anime> createNewAnimeEntry(Anime anime) {
        return ResponseEntity.ok(animeRepository.save(anime));
    }

    public Anime updateAnimeById(long id, Anime anime) {
        Optional<Anime> animeOptional = animeRepository.findById(id);
        if (animeOptional.isPresent()) {
            Anime animeToUpdate = animeOptional.get();
            animeToUpdate.setTitle(anime.getTitle());
            animeToUpdate.setLink(anime.getLink());
            animeToUpdate.setGenre(anime.getGenre());
            animeToUpdate.setOpinion(anime.getOpinion());
            animeToUpdate.setWatch_again(anime.getWatch_again());
            animeToUpdate.setTimes_watched(anime.getTimes_watched());
            animeToUpdate.setStart_date(anime.getStart_date());
            animeToUpdate.setLast_change(anime.getLast_change());
            animeToUpdate.setRelease_date(anime.getRelease_date());
            animeToUpdate.setSub_dub(anime.getSub_dub());
            return animeRepository.save(animeToUpdate);
        } else {
            throw new EntityNotFoundException("Anime with id "+id+" not found");
        }
    }

    public String deleteAnimeById(long id) {
        animeRepository.deleteById(id);
        return "Anime with id "+id+" deleted";
    }

    public Page<Anime> getAllPaginatedAnime(Pageable pageable) {
        return animeRepository.findAll(pageable);
    }
}
