package by.training.gallery.entity;

import java.util.Objects;

public class PaintingPhoto extends Entity {

    private int paintingId;
    private String photoPath;

    public PaintingPhoto() {}

    public PaintingPhoto(int paintingId, String photoPath) {
        this.paintingId = paintingId;
        this.photoPath = photoPath;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaintingPhoto that = (PaintingPhoto) o;
        return paintingId == that.paintingId && Objects.equals(photoPath, that.photoPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, photoPath);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Painting photo{");
        sb.append("painting id=").append(paintingId);
        sb.append(", photo path=").append(photoPath).append('}');
        return sb.toString();
    }
}
