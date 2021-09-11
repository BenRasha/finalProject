package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class ContemporaryPainting extends Entity {

    private int paintingId;
    private String size;
    private String material;
    private Date date;

    public ContemporaryPainting() {}

    public ContemporaryPainting(int paintingId, String size, String material, Date date) {
        this.paintingId = paintingId;
        this.size = size;
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
        ContemporaryPainting that = (ContemporaryPainting) o;
        return paintingId == that.paintingId && size.equals(that.size) && Objects.equals(material, that.material) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, size, material, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Contemporary Painting{");
        sb.append("id=").append(paintingId).append(", size=").append(size);
        sb.append(", material=").append(material);
        sb.append(", date=").append(date).append('}');
        return sb.toString();
    }
}
