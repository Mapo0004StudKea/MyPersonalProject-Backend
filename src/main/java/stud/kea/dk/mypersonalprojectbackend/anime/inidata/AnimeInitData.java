package stud.kea.dk.mypersonalprojectbackend.anime.inidata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;
import stud.kea.dk.mypersonalprojectbackend.anime.repository.AnimeRepository;

import java.time.LocalDate;

@Component
@Order(1)
public class AnimeInitData implements CommandLineRunner {

    private final AnimeRepository animeRepository;

    public AnimeInitData(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (animeRepository.count() == 0) {
            System.out.println("Anime-tabellen er tom. Tilføjer testdata...");

            Anime anime = new Anime(
                "Angel Beats!",
                    "https://hianime.to/angel-beats-321?ref=search",
                    "Action, Comedy, Drama, School, Supernatural",
                    "Good",
                        "YES",
                    2,
                     LocalDate.of(2018, 10, 20),
                     LocalDate.of(2024, 3, 7),
                    "Spring 2010",
                    "DUB"
            );

            animeRepository.save(anime);
            System.out.println("Animer tilføjet til databasen.");
        } else {
            System.out.println("Anime-tabellen er allerede udfyldt. Ingen data tilføjet.");

        }
    }

}
