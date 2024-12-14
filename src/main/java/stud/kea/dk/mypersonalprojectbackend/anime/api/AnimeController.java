package stud.kea.dk.mypersonalprojectbackend.anime.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.service.AnimeService;
import stud.kea.dk.mypersonalprojectbackend.anime.service.ExcelService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/anime")
public class AnimeController {

    private final AnimeService animeService;
    private final ExcelService excelService;

    public AnimeController(AnimeService animeService, ExcelService excelService) {
        this.animeService = animeService;
        this.excelService = excelService;
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

    @PostMapping("/createNewAnimeEntry")
    public ResponseEntity<Anime> createNewAnimeEntry(@RequestBody Anime anime) {
        return animeService.createNewAnimeEntry(anime);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Anime> updateAnime(@PathVariable long id, @RequestBody Anime anime) {
        Anime updateAnime = animeService.updateAnimeById(id, anime);
        return ResponseEntity.ok(updateAnime);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAnime(@PathVariable long id) {
        String result= animeService.deleteAnimeById(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            excelService.importExcelFile(file);
            return ResponseEntity.ok("File uploaded and data saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }
}