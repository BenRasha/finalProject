package by.training.gallery.service.impl;

import by.training.gallery.dao.EntityTransaction;
import by.training.gallery.dao.SketchDao;
import by.training.gallery.dao.SketchPhotoDao;
import by.training.gallery.dao.exception.DAOException;
import by.training.gallery.dao.factory.DaoFactory;
import by.training.gallery.entity.FullSketch;
import by.training.gallery.entity.Sketch;
import by.training.gallery.entity.SketchPhoto;
import by.training.gallery.service.SketchService;
import by.training.gallery.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class SketchServiceImpl implements SketchService {

    private DaoFactory daoFactory = DaoFactory.getInstance();

    @Override
    public List<FullSketch> findAll() throws ServiceException {
        List<FullSketch> fullSketches = new ArrayList<>();
        List<Sketch> sketches = new ArrayList<>();
        List<SketchPhoto> sketchPhotos;
        List<String> photoPaths;
        SketchDao sketchDao = daoFactory.getSketchDao();
        SketchPhotoDao sketchPhotoDao = daoFactory.getSketchPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(sketchDao, sketchPhotoDao);
        try {
            sketches.addAll(sketchDao.findAll());
            for (Sketch sketch : sketches) {
                int sketchId = sketch.getSketchId();
                sketchPhotos = new ArrayList<>();
                photoPaths = new ArrayList<>();
                sketchPhotos.addAll(sketchPhotoDao.findAllSketchesPhotosById(sketchId));
                for (SketchPhoto sketchPhoto : sketchPhotos) {
                    photoPaths.add(sketchPhoto.getPhotoPath());
                }
                fullSketches.add(new FullSketch(sketch, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullSketches;
    }

    @Override
    public FullSketch findEntityById(Integer id) throws ServiceException {
        FullSketch fullSketch;
        Sketch sketch;
        List<SketchPhoto> sketchPhotos;
        List<String> photoPaths;
        SketchDao sketchDao = daoFactory.getSketchDao();
        SketchPhotoDao sketchPhotoDao = daoFactory.getSketchPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(sketchDao, sketchPhotoDao);
        try {
            sketch = sketchDao.findEntityById(id);
            int sketchId = sketch.getSketchId();
            sketchPhotos = new ArrayList<>();
            sketchPhotos.addAll(sketchPhotoDao.findAllSketchesPhotosById(sketchId));
            photoPaths = new ArrayList<>();
            for (SketchPhoto sketchPhoto : sketchPhotos) {
                photoPaths.add(sketchPhoto.getPhotoPath());
            }
            fullSketch = new FullSketch(sketch, photoPaths);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullSketch;
    }

    @Override
    public void delete(Integer id) throws ServiceException {
        SketchDao sketchDao = daoFactory.getSketchDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(sketchDao);
        try {
            sketchDao.delete(id);
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public void delete(FullSketch entity) throws ServiceException {
        SketchDao sketchDao = daoFactory.getSketchDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.init(sketchDao);
        try {
            sketchDao.delete(entity.getSketch());
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.end();
        }
    }

    @Override
    public FullSketch create(FullSketch entity) throws ServiceException {
        FullSketch fullSketch;
        Sketch sketch;
        SketchDao sketchDao = daoFactory.getSketchDao();
        SketchPhotoDao sketchPhotoDao = daoFactory.getSketchPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(sketchDao, sketchPhotoDao);
        try {
            sketch = sketchDao.create(entity.getSketch());
            int sketchId = sketch.getSketchId();
            for (String photoPath : entity.getPhotoPaths()) {
                sketchPhotoDao.create(new SketchPhoto(sketchId, photoPath));
            }
            fullSketch = new FullSketch(sketch, entity.getPhotoPaths());
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullSketch;
    }

    @Override
    public List<FullSketch> findSketchesByTitle(String patternTitle) throws ServiceException {
        List<FullSketch> fullSketches = new ArrayList<>();
        List<Sketch> sketches = new ArrayList<>();
        List<SketchPhoto> sketchPhotos;
        List<String> photoPaths;
        SketchDao sketchDao = daoFactory.getSketchDao();
        SketchPhotoDao sketchPhotoDao = daoFactory.getSketchPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(sketchDao, sketchPhotoDao);
        try {
            sketches.addAll(sketchDao.findSketchesByTitle(patternTitle));
            for (Sketch sketch : sketches) {
                int sketchId = sketch.getSketchId();
                sketchPhotos = new ArrayList<>();
                sketchPhotos.addAll(sketchPhotoDao.findAllSketchesPhotosById(sketchId));
                photoPaths = new ArrayList<>();
                for (SketchPhoto sketchPhoto : sketchPhotos) {
                    photoPaths.add(sketchPhoto.getPhotoPath());
                }
                fullSketches.add(new FullSketch(sketch, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullSketches;
    }

    @Override
    public List<FullSketch> findSketchesByDate(String patternDate) throws ServiceException {
        List<FullSketch> fullSketches = new ArrayList<>();
        List<Sketch> sketches = new ArrayList<>();
        List<SketchPhoto> sketchPhotos;
        List<String> photoPaths;
        SketchDao sketchDao = daoFactory.getSketchDao();
        SketchPhotoDao sketchPhotoDao = daoFactory.getSketchPhotoDao();
        EntityTransaction transaction = new EntityTransaction();
        transaction.initTransaction(sketchDao, sketchPhotoDao);
        try {
            sketches.addAll(sketchDao.findSketchesByDate(patternDate));
            for (Sketch sketch : sketches) {
                int sketchId = sketch.getSketchId();
                sketchPhotos = new ArrayList<>();
                sketchPhotos.addAll(sketchPhotoDao.findAllSketchesPhotosById(sketchId));
                photoPaths = new ArrayList<>();
                for (SketchPhoto sketchPhoto : sketchPhotos) {
                    photoPaths.add(sketchPhoto.getPhotoPath());
                }
                fullSketches.add(new FullSketch(sketch, photoPaths));
            }
        } catch (DAOException exception) {
            transaction.rollback();
            throw new ServiceException(exception);
        } finally {
            transaction.endTransaction();
        }
        return fullSketches;
    }
}
