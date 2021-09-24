package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class Sketch extends Entity {

    private int sketchId;
    private String title;
    private Date date;

    public Sketch() {}

    public Sketch(int sketchId, String title, Date date) {
        this.sketchId = sketchId;
        this.title = title;
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
        return sketchId == sketch.sketchId && Objects.equals(title, sketch.title) && Objects.equals(date, sketch.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sketchId, title, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sketch{");
        sb.append("id=").append(sketchId).append(", title=").append(title);
        sb.append(", date=").append(date).append('}');
        return sb.toString();
    }
}
