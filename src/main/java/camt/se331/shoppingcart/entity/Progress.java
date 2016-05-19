package camt.se331.shoppingcart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by raPhat on 5/18/16 AD.
 */
@Entity
public class Progress {
    @Id
    @GeneratedValue
    Long id;
    String message;
    boolean progressStatus;
    String progressName;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    ShoppingCart cart;

    @Temporal(TemporalType.TIMESTAMP)
    Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    Date endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    Set<Image> images = new HashSet<>();

    public Progress() {
    }

    public Progress(String message, boolean progressStatus, String progressName) {
        this.message = message;
        this.progressStatus = progressStatus;
        this.progressName = progressName;
        this.setCreatedDate(Calendar.getInstance().getTime());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isProgressStatus() {
        return progressStatus;
    }

    public void setProgressStatus(boolean progressStatus) {
        this.progressStatus = progressStatus;
    }

    public String getProgressName() {
        return progressName;
    }

    public void setProgressName(String progressName) {
        this.progressName = progressName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Progress)) return false;

        Progress progress = (Progress) o;

        if (isProgressStatus() != progress.isProgressStatus()) return false;
        if (getId() != null ? !getId().equals(progress.getId()) : progress.getId() != null) return false;
        if (getMessage() != null ? !getMessage().equals(progress.getMessage()) : progress.getMessage() != null)
            return false;
        if (getProgressName() != null ? !getProgressName().equals(progress.getProgressName()) : progress.getProgressName() != null)
            return false;
        if (getCart() != null ? !getCart().equals(progress.getCart()) : progress.getCart() != null) return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(progress.getCreatedDate()) : progress.getCreatedDate() != null)
            return false;
        if (getEndDate() != null ? !getEndDate().equals(progress.getEndDate()) : progress.getEndDate() != null)
            return false;
        return !(getImages() != null ? !getImages().equals(progress.getImages()) : progress.getImages() != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getMessage() != null ? getMessage().hashCode() : 0);
        result = 31 * result + (isProgressStatus() ? 1 : 0);
        result = 31 * result + (getProgressName() != null ? getProgressName().hashCode() : 0);
        result = 31 * result + (getCart() != null ? getCart().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getEndDate() != null ? getEndDate().hashCode() : 0);
        result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
        return result;
    }

}
