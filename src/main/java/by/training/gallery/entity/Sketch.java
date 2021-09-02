package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class Sketch extends Entity {

    private int sketchId;
    private String title;
    private String description;
    private String size;
    private int imageId;
    private Date date;

    public Sketch() {}

    public Sketch(int sketchId, String title, String description, String size, int imageId, Date date) {
        this.sketchId = sketchId;
        this.title = title;
        this.description = description;
        this.size = size;
        this.imageId = imageId;
        this.date = date;
    }

    public int getSketchId() {
        return sketchId;
    }

    public void setSketchId(int sketchId) {
        this.sketchId = sketchId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sketch sketch = (Sketch) o;
        return sketchId == sketch.sketchId && size.equals(sketch.size) && Objects.equals(title, sketch.title) && Objects.equals(description, sketch.description) && Objects.equals(imageId, sketch.imageId) && Objects.equals(date, sketch.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sketchId, title, description, size, imageId, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sketch{");
        sb.append("id=").append(sketchId).append(", title=").append(title);
        sb.append(", description=").append(description).append(", size=").append(size);
        sb.append(", imageId=").append(imageId).append(", date=").append(date);
        return sb.toString();
    }
}
