package stud.kea.dk.mypersonalprojectbackend.anime.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.service.AnimeService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/GetAllAnime")
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> getAnime(@PathVariable long id) {
        Anime anime = animeService.getAnimeById(id);
        if (anime != null) {
            return ResponseEntity.ok(anime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
