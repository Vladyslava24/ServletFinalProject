package ua.training.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Edition {
    private int id;
    private String name;
    private String author;
    private long price;
    private int amountEdition;
    private EditionStatus editionStatus;
    private int amountAvailable;

    private List<Application> editions = new ArrayList<>();

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order orderId;*/

    public Edition() {
    }

    public Edition(int id, String name, String author, long price, int amountEdition, EditionStatus editionStatus, int amountAvailable, List<Application> editions) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.amountEdition = amountEdition;
        this.editionStatus = editionStatus;
        this.amountAvailable = amountAvailable;
        this.editions = editions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAmountEdition() {
        return amountEdition;
    }

    public void setAmountEdition(int amountEdition) {
        this.amountEdition = amountEdition;
    }

    public EditionStatus getEditionStatus() {
        return editionStatus;
    }

    public void setEditionStatus(EditionStatus editionStatus) {
        this.editionStatus = editionStatus;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(int amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public static final class Builder {
        private int id;
        private String name;
        private String author;
        private long price;
        private int amountEdition;
        private EditionStatus editionStatus;
        private int amountAvailable;

        public Edition.Builder buildId(int id) {
            this.id = id;
            return this;
        }

        public Edition.Builder buildName(String name) {
            this.name = name;
            return this;
        }

        public Edition.Builder buildAuthor(String author) {
            this.author = author;
            return this;
        }

        public Edition.Builder buildPrice(long price) {
            this.price = price;
            return this;
        }

        public Edition.Builder buildAmountEdition(int amountEdition) {
            this.amountEdition = amountEdition;
            return this;
        }

        public Edition.Builder buildStatus(EditionStatus editionStatus) {
            this.editionStatus = editionStatus;
            return this;
        }

        public Edition.Builder buildAmountAvailable(int amountAvailable) {
            this.amountAvailable = amountAvailable;
            return this;
        }

        public Edition build() {
            Edition edition = new Edition();
            edition.setId(id);
            edition.setName(name);
            edition.setAuthor(author);
            edition.setPrice(price);
            edition.setAmountEdition(amountEdition);
            edition.setEditionStatus(editionStatus);
            edition.setAmountAvailable(amountAvailable);
            return edition;
        }
    }
}