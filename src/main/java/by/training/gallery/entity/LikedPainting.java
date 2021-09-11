package by.training.gallery.entity;

import java.util.Objects;

public class LikedPainting extends Entity {

    private int likedId;
    private int userId;
    private int paintingId;
    private int sketchId;

    public LikedPainting() {}

    public LikedPainting(int likedId, int userId, int paintingId, int sketchId) {
        this.likedId = likedId;
        this.userId = userId;
        this.paintingId = paintingId;
        this.sketchId = sketchId;
    }

    public int getLikedId() {
        return likedId;
    }

    public void setLikedId(int likedId) {
        this.likedId = likedId;
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

    public int getSketchId() {
        return sketchId;
    }

    public void setSketchId(int sketchId) {
        this.sketchId = sketchId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikedPainting that = (LikedPainting) o;
        return likedId == that.likedId && userId == that.userId && paintingId == that.paintingId && sketchId == that.sketchId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(likedId, userId, paintingId, sketchId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Liked Painting{");
        sb.append("id=").append(likedId).append(", user id=").append(userId);
        sb.append(", painting id=").append(", sketch id=").append(sketchId).append(paintingId).append('}');
        return sb.toString();
    }
}
