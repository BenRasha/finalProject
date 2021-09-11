package by.training.gallery.entity;

import java.util.Objects;

public class Image extends Entity {

    private int imageId;
    private String mainImage;
    private String firstImage;
    private String secondImage;
    private String thirdImage;
    private String fourthImage;
    private String fifthImage;

    public Image() {}

    public Image(int imageId, String mainImage, String firstImage, String secondImage, String thirdImage,
                 String fourthImage, String fifthImage) {
        this.imageId = imageId;
        this.mainImage = mainImage;
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourthImage = fourthImage;
        this.fifthImage = fifthImage;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(String firstImage) {
        this.firstImage = firstImage;
    }

    public String getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(String secondImage) {
        this.secondImage = secondImage;
    }

    public String getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(String thirdImage) {
        this.thirdImage = thirdImage;
    }

    public String getFourthImage() {
        return fourthImage;
    }

    public void setFourthImage(String fourthImage) {
        this.fourthImage = fourthImage;
    }

    public String getFifthImage() {
        return fifthImage;
    }

    public void setFifthImage(String fifthImage) {
        this.fifthImage = fifthImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return imageId == image.imageId && Objects.equals(mainImage, image.mainImage) && Objects.equals(firstImage, image.firstImage) && Objects.equals(secondImage, image.secondImage) && Objects.equals(thirdImage, image.thirdImage) && Objects.equals(fourthImage, image.fourthImage) && Objects.equals(fifthImage, image.fifthImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId, mainImage, firstImage, secondImage, thirdImage, fourthImage, fifthImage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id=").append(imageId).append(", main image=").append(mainImage);
        sb.append(", first image=").append(firstImage).append(", second image=").append(secondImage);
        sb.append(", third image=").append(thirdImage).append(", fourth image=").append(fourthImage);
        sb.append(", fifth image=").append(fifthImage).append('}');
        return sb.toString();
    }
}
