package by.training.gallery.entity;

import java.util.Objects;

public class SketchPhoto extends Entity {

    private int sketchId;
    private String photoPath;

    public SketchPhoto() {}

    public SketchPhoto(int sketchId, String photoPath) {
        this.sketchId = sketchId;
        this.photoPath = photoPath;
    }

    public int getSketchId() {
        return sketchId;
    }

    public void setSketchId(int sketchId) {
        this.sketchId = sketchId;
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
        SketchPhoto that = (SketchPhoto) o;
        return sketchId == that.sketchId && Objects.equals(photoPath, that.photoPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sketchId, photoPath);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sketch photo{");
        sb.append("sketch id=").append(sketchId).append(", photo path=").append(photoPath);
        sb.append('}');
        return sb.toString();
    }
}
