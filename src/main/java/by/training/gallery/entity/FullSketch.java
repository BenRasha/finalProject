package by.training.gallery.entity;

import java.util.List;
import java.util.Objects;

public class FullSketch extends Entity {

    private Sketch sketch;
    private List<String> photoPaths;

    public FullSketch() {}

    public FullSketch(Sketch sketch, List<String> photoPaths) {
        this.sketch = sketch;
        this.photoPaths = photoPaths;
    }

    public Sketch getSketch() {
        return sketch;
    }

    public void setSketch(Sketch sketch) {
        this.sketch = sketch;
    }

    public List<String> getPhotoPaths() {
        return photoPaths;
    }

    public void setPhotoPaths(List<String> photoPaths) {
        this.photoPaths = photoPaths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FullSketch that = (FullSketch) o;
        return Objects.equals(sketch, that.sketch) && Objects.equals(photoPaths, that.photoPaths);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sketch, photoPaths);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Full sketch{");
        sb.append("sketch=").append(sketch).append(", photo paths=").append(photoPaths);
        sb.append('}');
        return sb.toString();
    }
}
