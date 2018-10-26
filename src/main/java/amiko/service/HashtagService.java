package amiko.service;

import amiko.model.Hashtag;
import amiko.model.KostoHashtag;
import amiko.repository.HashtagRepository;
import amiko.repository.KostoHashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HashtagService {

    @Autowired
    HashtagRepository hashtagRepository;

    @Autowired
    KostoHashtagRepository kostoHashtagRepository;

    public void saveHashtags(Long kostoId, List<String> hashtags) {
        for (String value : hashtags) {
            Optional<Hashtag> hashtagOptional = hashtagRepository.findByHashtag(value);
            if (!hashtagOptional.isPresent()) {
                hashtagOptional = Optional.of(hashtagRepository.save(new Hashtag(value)));
            }
            KostoHashtag kostoHashtag = new KostoHashtag(kostoId, hashtagOptional.get().getHashtagId());
            kostoHashtagRepository.save(kostoHashtag);
        }
    }

    public List<String> findHashtags(Long kostoId) {
        List<Hashtag> hashtags = kostoHashtagRepository.findHashtagsByKostoId(kostoId);
        List<String> values = new ArrayList<>();
        for (Hashtag hashtag : hashtags) {
            values.add(hashtag.getHashtag());
        }
        return values;
    }
}
