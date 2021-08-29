package by.training.gallery.entity;

import java.util.Objects;

public class Painting extends Entity {

    private int paintingId;
    private String title;
    private String description;
    private String style;

    public Painting() {}

    public Painting(int paintingId, String title, String description, String style) {
        this.paintingId = paintingId;
        this.title = title;
        this.description = description;
        this.style = style;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Painting painting = (Painting) o;
        return paintingId == painting.paintingId && Objects.equals(title, painting.title) && Objects.equals(description, painting.description) && Objects.equals(style, painting.style);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paintingId, title, description, style);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Painting{");
        sb.append("id=").append(paintingId).append(", tittle=").append(title);
        sb.append(", description=").append(description).append(", style=").append(style).append('}');
        return sb.toString();
    }
}

