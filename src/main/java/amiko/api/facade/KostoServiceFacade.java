package amiko.api.facade;

import amiko.api.KostojRequestEnum;
import amiko.api.to.KostoTO;
import amiko.api.to.KostojRequestTO;
import amiko.model.Kosto;
import amiko.service.HashtagService;
import amiko.service.KostoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KostoServiceFacade {

    @Autowired
    KostoService kostoService;

    @Autowired
    HashtagService hashtagService;

    public Long createKosto(KostoTO kostoTO){
        Kosto kosto = kostoService.saveKosto(new Kosto(kostoTO.getPrice(),
                kostoTO.getDescription(),
                kostoTO.getQuantity(),
                kostoTO.getWeight(),
                kostoTO.getDate()));

        hashtagService.saveHashtags(kosto.getKostoId(), kostoTO.getHashtags());

        return kosto.getKostoId();
    }

    public List<KostoTO> getAllKostoj(KostojRequestTO request) {
        List<Kosto> kostoj = kostoService.find(request, getKostojRequestEnum(request));
        System.out.println("---SAIU DO FIND---"); //TODO
        List<KostoTO> response = new ArrayList<>();
        for (Kosto kosto : kostoj) {
            KostoTO kostoTO = new KostoTO(kosto.getKostoId(), kosto.getPrice(), kosto.getDescription(),
                    kosto.getQuantity(), kosto.getWeight(), kosto.getDate());
            kostoTO.setHashtags(hashtagService.findHashtags(kosto.getKostoId()));
            response.add(kostoTO);
        }
        return response;
    }

    private KostojRequestEnum getKostojRequestEnum(KostojRequestTO request) {

        boolean isByDate = request.getDateAfter() != null && request.getDateBefore() != null;
        boolean isByDescriptions = request.getDescriptions() != null;
        boolean isByHashtags = request.getHashtags() != null;

        if (isByDate && isByDescriptions && isByHashtags){
            System.out.println("FIND_BY_DATE_DESCRIPTION_AND_HASHTAG"); //TODO
            return KostojRequestEnum.FIND_BY_DATE_DESCRIPTION_AND_HASHTAG;
        } else if (isByDate && isByDescriptions && !isByHashtags) {
            System.out.println("FIND_BY_DATE_AND_DESCRIPTION"); //TODO
            return KostojRequestEnum.FIND_BY_DATE_AND_DESCRIPTION;
        } else if (isByDate && !isByDescriptions && !isByHashtags) {
            System.out.println("FIND_BY_DATE"); //TODO
            return KostojRequestEnum.FIND_BY_DATE;
        } else if (!isByDate && isByDescriptions && isByHashtags) {
            System.out.println("FIND_BY_DESCRIPTION_AND_HASHTAG"); //TODO
            return KostojRequestEnum.FIND_BY_DESCRIPTION_AND_HASHTAG;
        } else if (!isByDate && isByDescriptions && !isByHashtags) {
            System.out.println("FIND_BY_DESCRIPTION"); //TODO
            return KostojRequestEnum.FIND_BY_DESCRIPTION;
        } else if (isByDate && !isByDescriptions && isByHashtags) {
            System.out.println("FIND_BY_DATE_AND_HASHTAG"); //TODO
            return KostojRequestEnum.FIND_BY_DATE_AND_HASHTAG;
        } else if (!isByDate && !isByDescriptions && isByHashtags) {
            System.out.println("FIND_BY_HASHTAG"); //TODO
            return KostojRequestEnum.FIND_BY_HASHTAG;
        } else {
            System.out.println("FIND_ALL"); //TODO
            return KostojRequestEnum.FIND_ALL;
        }

    }
}
