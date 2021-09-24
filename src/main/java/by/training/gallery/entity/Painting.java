package by.training.gallery.entity;

import java.sql.Date;
import java.util.Objects;

public class Painting extends Entity {

    private int paintingId;
    private String title;
    private String style;
    private String size;
    private String material;
    private Date date;

    public Painting() {}

    public Painting(int paintingId, String title, String style, String size,
                    String material, Date date) {
        this.paintingId = paintingId;
        this.title = title;
        this.style = style;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
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
        Painting painting = (Painting) o;
        return paintingId == painting.paintingId && Objects.equals(title, painting.title) && Objects.equals(style, painting.style) && Objects.equals(size, painting.size) && Objects.equals(material, painting.material) && Objects.equals(date, painting.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, title, style, size, material, date);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Painting{");
        sb.append("id=").append(paintingId).append(", title=").append(title);
        sb.append(", style").append(style);
        sb.append(", size=").append(size).append(", material=").append(material);
        sb.append(", date=").append(date).append('}');
        return sb.toString();
    }
}