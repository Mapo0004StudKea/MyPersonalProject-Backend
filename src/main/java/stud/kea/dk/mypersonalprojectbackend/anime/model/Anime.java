package stud.kea.dk.mypersonalprojectbackend.anime.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    private String genre;
    private String opinion;
    private String watch_again;
    private int times_watched;
    @Column(name = "start_date", columnDefinition = "DATE")
    private LocalDate start_date;
    @Column(name = "last_change", columnDefinition = "DATE")
    private LocalDate last_change;
    @Column(name = "release_date")
    private String release_date;
    private String sub_dub;

    public Anime(String title, String link, String genre, String opinion, String watch_again, int times_watched, LocalDate start_date, LocalDate last_change, String release_date, String sub_dub) {
        this.title = title;
        this.link = link;
        this.genre = genre;
        this.opinion = opinion;
        this.watch_again = watch_again;
        this.times_watched = times_watched;
        this.start_date = start_date;
        this.last_change = last_change;
        this.release_date = release_date;
        this.sub_dub = sub_dub;
    }
}
