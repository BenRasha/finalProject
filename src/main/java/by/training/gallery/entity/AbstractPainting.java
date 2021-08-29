package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class AbstractPainting extends Entity {

    private int paintingId;
    private int size;
    private String imageURL;
    private String material;
    private Date date;

    public AbstractPainting() {}

    public AbstractPainting(int paintingId, int size, String imageURL, String material, Date date) {
        this.paintingId = paintingId;
        this.size = size;
        this.imageURL = imageURL;
        this.material = material;
        this.date = date;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
        return paintingId == that.paintingId && size == that.size && Objects.equals(imageURL, that.imageURL) && Objects.equals(material, that.material) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, size, imageURL, material, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Abstract Painting{");
        sb.append("id=").append(paintingId).append(", size=").append(size);
        sb.append(", imageURL=").append(imageURL).append(", material=").append(material);
        sb.append(", date=").append(date).append('}');
        return sb.toString();
    }
}
