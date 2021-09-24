package by.training.gallery.entity;

import java.util.Objects;

public class LikedPainting extends Entity {

    private int userId;
    private int paintingId;

    public LikedPainting() {}

    public LikedPainting(int userId, int paintingId) {
        this.userId = userId;
        this.paintingId = paintingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPaintingId() {
        return paintingId;
    }

    public void setPaintingId(int paintingId) {
        this.paintingId = paintingId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikedPainting that = (LikedPainting) o;
        return userId == that.userId && paintingId == that.paintingId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, paintingId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Liked Painting{");
        sb.append("user id=").append(userId).append(", painting id=").append(paintingId);
        sb.append('}');
        return sb.toString();
    }
}
