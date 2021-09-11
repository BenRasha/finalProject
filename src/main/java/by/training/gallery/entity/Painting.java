package by.training.gallery.entity;

import java.util.Objects;

public class Painting extends Entity {

    private int paintingId;
    private int imageId;
    private String title;
    private String description;
    private String style;

    public Painting() {}

    public Painting(int paintingId, int imageId, String title, String description, String style) {
        this.paintingId = paintingId;
        this.imageId = imageId;
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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
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
    public String toString() {
        final StringBuilder sb = new StringBuilder("Painting{");
        sb.append("id=").append(paintingId).append(", image id=").append(imageId).append(", tittle=").append(title);
        sb.append(", description=").append(description).append(", style=").append(style).append('}');
        return sb.toString();
    }
}

