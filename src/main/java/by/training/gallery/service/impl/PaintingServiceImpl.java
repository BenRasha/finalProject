package by.training.gallery.service.impl;

import by.training.gallery.dao.EntityTransaction;
import by.training.gallery.dao.PaintingDao;
import by.training.gallery.dao.PaintingPhotoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.FullPainting;
import by.training.gallery.entity.Painting;
import by.training.gallery.entity.PaintingPhoto;
import by.training.gallery.service.PaintingService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class PaintingServiceImpl implements PaintingService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<FullPainting> findAll() throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findAll());
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }

    @Override
    public FullPainting findEntityById(Integer id) throws ServiceException {
        FullPainting fullPainting;
        Painting painting;
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            painting = paintingDao.findEntityById(id);
            int paintingId = painting.getPaintingId();
            paintingPhotos = new ArrayList<>();
            photoPaths = new ArrayList<>();
            paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
            for (PaintingPhoto paintingPhoto : paintingPhotos) {
                photoPaths.add(paintingPhoto.getPhotoPath());
            }
            fullPainting = new FullPainting(painting, photoPaths);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPainting;
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(paintingDao);
        try {
            paintingDao.delete(id);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public void delete(FullPainting entity) throws ServiceException {
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(paintingDao);
        try {
            paintingDao.delete(entity.getPainting());
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public FullPainting create(FullPainting entity) throws ServiceException {
        FullPainting fullPainting;
        Painting painting;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            painting = paintingDao.create(entity.getPainting());
            int paintingId = painting.getPaintingId();
            for (String photoPath : entity.getPaintingPhotos()) {
                paintingPhotoDao.create(new PaintingPhoto(paintingId, photoPath));
            }
            fullPainting = new FullPainting(painting, entity.getPaintingPhotos());
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPainting;
    }

    @Override
    public List<FullPainting> findPaintingsByTitle(String patternTitle) throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findPaintingsByTitle(patternTitle));
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }

    @Override
    public List<FullPainting> findPaintingsByStyle(String patternStyle) throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findPaintingsByStyle(patternStyle));
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }

    @Override
    public List<FullPainting> findPaintingsBySize(String patternSize) throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findPaintingsBySize(patternSize));
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }

    @Override
    public List<FullPainting> findPaintingsByMaterial(String patternMaterial) throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findPaintingsByMaterial(patternMaterial));
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }

    @Override
    public List<FullPainting> findPaintingsByDate(String patternDate) throws ServiceException {
        List<FullPainting> fullPaintings = new ArrayList<>();
        List<Painting> paintings = new ArrayList<>();
        List<PaintingPhoto> paintingPhotos;
        List<String> photoPaths;
        PaintingDao paintingDao = daoFactory.getPaintingDao();
        PaintingPhotoDao paintingPhotoDao = daoFactory.getPaintingPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(paintingDao, paintingPhotoDao);
        try {
            paintings.addAll(paintingDao.findPaintingsByDate(patternDate));
            for (Painting painting : paintings) {
                int paintingId = painting.getPaintingId();
                paintingPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                paintingPhotos.addAll(paintingPhotoDao.findAllPaintingsPhotosByPaintingId(paintingId));
                for (PaintingPhoto paintingPhoto : paintingPhotos) {
                    photoPaths.add(paintingPhoto.getPhotoPath());
                }
                fullPaintings.add(new FullPainting(painting, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullPaintings;
    }
}
