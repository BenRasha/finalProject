package by.training.gallery.entity;

import java.util.List;
import java.util.Objects;

public class FullPainting extends Entity {

    private Painting painting;
    private List<String> photoPaths;

    public FullPainting() {}

    public FullPainting(Painting painting, List<String> photoPaths) {
        this.painting = painting;
        this.photoPaths = photoPaths;
    }

    public Painting getPainting() {
        return painting;
    }

    public void setPainting(Painting painting) {
        this.painting = painting;
    }

    public List<String> getPaintingPhotos() {
        return photoPaths;
    }

    public void setPaintingPhotos(List<String> photoPaths) {
        this.photoPaths = photoPaths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullPainting that = (FullPainting) o;
        return Objects.equals(painting, that.painting) && Objects.equals(photoPaths, that.photoPaths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(painting, photoPaths);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Full painting{");
        sb.append("painting=").append(painting).append(", painting photos=");
        sb.append(photoPaths).append('}');
        return sb.toString();
    }
}
