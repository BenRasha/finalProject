package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class AbstractPainting extends Entity {

    private int paintingId;
    private String size;
    private int imageId;
    private String material;
    private Date date;

    public AbstractPainting() {}

    public AbstractPainting(int paintingId, String size, int imageId, String material, Date date) {
        this.paintingId = paintingId;
        this.size = size;
        this.imageId = imageId;
        this.material = material;
        this.date = date;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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
        AbstractPainting that = (AbstractPainting) o;
        return paintingId == that.paintingId && size.equals(that.size) && Objects.equals(imageId, that.imageId) && Objects.equals(material, that.material) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, size, imageId, material, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Abstract Painting{");
        sb.append("id=").append(paintingId).append(", size=").append(size);
        sb.append(", imageId=").append(imageId).append(", material=").append(material);
        sb.append(", date=").append(date).append('}');
        return sb.toString();
    }
}
