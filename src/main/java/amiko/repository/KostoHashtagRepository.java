package amiko.repository;

import amiko.model.Hashtag;
import amiko.model.KostoHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KostoHashtagRepository extends JpaRepository<KostoHashtag,Long> {

    @Query("select kh.hashtag from KostoHashtag as kh inner join kh.hashtag where kh.kostoId = ?1")
    List<Hashtag> findHashtagsByKostoId(Long kostoId);

}
