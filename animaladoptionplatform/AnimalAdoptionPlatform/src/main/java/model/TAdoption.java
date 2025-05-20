package model;


import java.util.Date;

public class TAdoption {
    private String adoptionId;

    private String animalId;

    private String adopterAccount;

    private Date adoptionDate;

    public String getAdoptionId() {
        return adoptionId;
    }

    public void setAdoptionId(String adoptionId) {
        this.adoptionId = adoptionId == null ? null : adoptionId.trim();
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId == null ? null : animalId.trim();
    }

    public String getAdopterAccount() {
        return adopterAccount;
    }

    public void setAdopterAccount(String adopterAccount) {
        this.adopterAccount = adopterAccount == null ? null : adopterAccount.trim();
    }

    public Date getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(Date adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}