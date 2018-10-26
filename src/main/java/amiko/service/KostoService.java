package amiko.service;

import amiko.api.KostojRequestEnum;
import amiko.api.to.KostojRequestTO;
import amiko.model.Kosto;
import amiko.repository.KostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KostoService {

    @Autowired
    KostoRepository kostoRepository;

    public Kosto saveKosto(Kosto kosto) {
        return kostoRepository.save(kosto);
    }

    public List<Kosto> find(KostojRequestTO request, KostojRequestEnum kostojRequestEnum) {
        switch (kostojRequestEnum){
            case FIND_BY_DATE:
                System.out.println("findByDate"); //TODO
                return kostoRepository.findByDate(request.getDateAfter(), request.getDateBefore());
            case FIND_BY_DESCRIPTION:
                System.out.println("findByDescription"); //TODO
                return kostoRepository.findByDescription(request.getDescriptions());
            case FIND_BY_HASHTAG:
                System.out.println("findByHashtag"); //TODO
                return kostoRepository.findByHashtag(request.getHashtags());
            case FIND_BY_DATE_AND_DESCRIPTION:
                System.out.println("findByDateAndDescription"); //TODO
                return kostoRepository.findByDateAndDescription(request.getDateAfter(), request.getDateBefore(),
                        request.getDescriptions());
            case FIND_BY_DATE_AND_HASHTAG:
                System.out.println("findByDateAndHashtag"); //TODO
                return kostoRepository.findByDateAndHashtag(request.getDateAfter(), request.getDateBefore(),
                        request.getHashtags());
            case FIND_BY_DATE_DESCRIPTION_AND_HASHTAG:
                System.out.println("findByDateDescriptionAndHashtag"); //TODO
                return kostoRepository.findByDateDescriptionAndHashtag(request.getDateAfter(), request.getDateBefore(),
                        request.getDescriptions(), request.getHashtags());
            case FIND_BY_DESCRIPTION_AND_HASHTAG:
                System.out.println("findByDescriptionAndHashtag"); //TODO
                return kostoRepository.findByDescriptionAndHashtag(request.getDescriptions(), request.getHashtags());
            default:
                System.out.println("findAll"); //TODO
                return kostoRepository.findAll();
        }
    }
}
