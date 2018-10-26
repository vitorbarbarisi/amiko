package amiko.repository;

import amiko.model.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag,Long> {

    @Query("select h from Hashtag h where h.hashtag = ?1")
    Optional<Hashtag> findByHashtag(String value);

}
