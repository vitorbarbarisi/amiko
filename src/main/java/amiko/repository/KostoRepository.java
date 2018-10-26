package amiko.repository;

import amiko.model.Kosto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface KostoRepository extends JpaRepository<Kosto,Long>{

    @Query("select k from Kosto k " +
            "where k.date between :dateAfter and :dateBefore")
    public List<Kosto> findByDate(@Param("dateAfter") Date dateAfter, @Param("dateBefore") Date dateBefore);

    @Query("select k from Kosto k " +
            "where k.description in :descriptions")
    public List<Kosto> findByDescription(@Param("descriptions") List<String> descriptions);

    @Query("select kh.kosto from KostoHashtag as kh " +
            "inner join kh.hashtag as h " +
            "inner join kh.kosto as k " +
            "where h.hashtag in :hashtags")
    public List<Kosto> findByHashtag(@Param("hashtags") List<String> hashtags);

    @Query("select k from Kosto k where k.date between :dateAfter and :dateBefore and k.description in :descriptions")
    public List<Kosto> findByDateAndDescription(@Param("dateAfter") Date dateAfter,
                                                @Param("dateBefore") Date dateBefore,
                                                @Param("descriptions")List<String> descriptions);

    @Query("select kh.kosto from KostoHashtag as kh " +
            "inner join kh.hashtag as h " +
            "inner join kh.kosto as k " +
            "where k.date between :dateAfter and :dateBefore " +
            "and k.description in :descriptions " +
            "and h.hashtag in :hashtags")
    public List<Kosto> findByDateDescriptionAndHashtag(@Param("dateAfter") Date dateAfter,
                                                       @Param("dateBefore") Date dateBefore,
                                                       @Param("descriptions") List<String> descriptions,
                                                       @Param("hashtags") List<String> hashtags);

    @Query("select kh.kosto from KostoHashtag as kh " +
            "inner join kh.hashtag as h " +
            "inner join kh.kosto as k " +
            "where k.date between :dateAfter and :dateBefore " +
            "and h.hashtag in :hashtags")
    public List<Kosto> findByDateAndHashtag(@Param("dateAfter") Date dateAfter,
                                            @Param("dateBefore") Date dateBefore,
                                            @Param("hashtags") List<String> hashtags);

    @Query("select kh.kosto from KostoHashtag as kh " +
            "inner join kh.hashtag as h " +
            "inner join kh.kosto as k " +
            "where k.description in :descriptions " +
            "and h.hashtag in :hashtags")
    public List<Kosto> findByDescriptionAndHashtag(@Param("descriptions") List<String> descriptions,
                                                   @Param("hashtags") List<String> hashtags);

}
