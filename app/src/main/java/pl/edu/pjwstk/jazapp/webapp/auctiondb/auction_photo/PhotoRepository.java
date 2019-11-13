package pl.edu.pjwstk.jazapp.webapp.auctiondb.auction_photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class PhotoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(PhotoEntity photoEntity) {
        em.persist(photoEntity);
    }

    @Transactional
    public boolean isExist(int auction_id) {
        PhotoEntity search = em.find(PhotoEntity.class, auction_id);
        return !(search == null);
    }

    @Transactional
    public void editLink(String link, int auction_id) {
        if (isExist(auction_id)) {
            PhotoEntity photoEntity = em.find(PhotoEntity.class, auction_id);
            photoEntity.setLink(link);
            em.persist(photoEntity);
        }
    }

    @Transactional
    public void editAuction_Id(int new_id, int auction_id) {
        if (isExist(auction_id)) {
            PhotoEntity photoEntity = em.find(PhotoEntity.class, auction_id);
            photoEntity.setAuction_id(new_id);
            em.persist(photoEntity);
        }
    }
}
