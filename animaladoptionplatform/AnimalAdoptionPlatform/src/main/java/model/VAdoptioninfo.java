package model;



public class VAdoptioninfo {
    private String adoptionId;

    private String animalId;

    private String animalType;

    private String breed;

    private String petName;

    private String adopterAccount;

    private String adopterName;

    private String adopterPhone;

    private String adoptionDate;

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

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType == null ? null : animalType.trim();
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed == null ? null : breed.trim();
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    public String getAdopterAccount() {
        return adopterAccount;
    }

    public void setAdopterAccount(String adopterAccount) {
        this.adopterAccount = adopterAccount == null ? null : adopterAccount.trim();
    }

    public String getAdopterName() {
        return adopterName;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName == null ? null : adopterName.trim();
    }

    public String getAdopterPhone() {
        return adopterPhone;
    }

    public void setAdopterPhone(String adopterPhone) {
        this.adopterPhone = adopterPhone == null ? null : adopterPhone.trim();
    }

    public String getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(String adoptionDate) {
        this.adoptionDate = adoptionDate;
    }
}