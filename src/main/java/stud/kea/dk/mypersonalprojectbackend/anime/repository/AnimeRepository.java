package stud.kea.dk.mypersonalprojectbackend.anime.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stud.kea.dk.mypersonalprojectbackend.anime.model.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
