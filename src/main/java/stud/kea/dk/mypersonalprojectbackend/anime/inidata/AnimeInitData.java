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

            Anime anime = new Anime("Angel Beats!","https://hianime.to/angel-beats-321?ref=search","Action, Comedy, Drama, School, Supernatural","Good","Yes",2, LocalDate.of(2018, 10, 20),LocalDate.of(2024, 3, 7),"Spring 2010","Dub");
            Anime anime1 = new Anime("Re:Zero Starting Life in Another World","https://hianime.to/rezero-starting-life-in-another-world-212?ref=search","Action, Adventure, Drama, Fantasy, Psychological, Romance, Thriller, Suspense, Isekai, Demons, Magic","Extremely Good","Yes",10,LocalDate.of(2018, 10, 20),LocalDate.of(2024, 3, 7),"Spring 2016","Dub");

            animeRepository.save(anime);
            animeRepository.save(anime1);
            System.out.println("Animer tilføjet til databasen.");
        } else {
            System.out.println("Anime-tabellen er allerede udfyldt. Ingen data tilføjet.");

        }
    }

}
