package by.training.gallery.entity;

import java.net.URL;
import java.util.Objects;

public class Image extends Entity {

    private int image_id;
    private URL mainImage;
    private URL firstImage;
    private URL secondImage;
    private URL thirdImage;
    private URL fourthImage;
    private URL fifthImage;

    public Image() {}

    public Image(int image_id, URL mainImage, URL firstImage, URL secondImage, URL thirdImage,
                 URL fourthImage, URL fifthImage) {
        this.image_id = image_id;
        this.mainImage = mainImage;
        this.firstImage = firstImage;
        this.secondImage = secondImage;
        this.thirdImage = thirdImage;
        this.fourthImage = fourthImage;
        this.fifthImage = fifthImage;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public URL getMainImage() {
        return mainImage;
    }

    public void setMainImage(URL mainImage) {
        this.mainImage = mainImage;
    }

    public URL getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(URL firstImage) {
        this.firstImage = firstImage;
    }

    public URL getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(URL secondImage) {
        this.secondImage = secondImage;
    }

    public URL getThirdImage() {
        return thirdImage;
    }

    public void setThirdImage(URL thirdImage) {
        this.thirdImage = thirdImage;
    }

    public URL getFourthImage() {
        return fourthImage;
    }

    public void setFourthImage(URL fourthImage) {
        this.fourthImage = fourthImage;
    }

    public URL getFifthImage() {
        return fifthImage;
    }

    public void setFifthImage(URL fifthImage) {
        this.fifthImage = fifthImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return image_id == image.image_id && Objects.equals(mainImage, image.mainImage) && Objects.equals(firstImage, image.firstImage) && Objects.equals(secondImage, image.secondImage) && Objects.equals(thirdImage, image.thirdImage) && Objects.equals(fourthImage, image.fourthImage) && Objects.equals(fifthImage, image.fifthImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image_id, mainImage, firstImage, secondImage, thirdImage, fourthImage, fifthImage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Image{");
        sb.append("id=").append(image_id).append(", main image=").append(mainImage);
        sb.append(", first image=").append(firstImage).append(", second image=").append(secondImage);
        sb.append(", third image=").append(thirdImage).append(", fourth image=").append(fourthImage);
        sb.append(", fifth image=").append(fifthImage).append('}');
        return sb.toString();
    }
}
