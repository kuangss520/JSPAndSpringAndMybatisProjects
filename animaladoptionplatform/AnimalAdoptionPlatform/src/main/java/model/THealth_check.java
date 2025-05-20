package model;

import java.util.Date;

public class THealth_check {
    private Integer checkId;

    private String animalId;

    private String checkItem;

    private String checkResult;

    private String treatmentDesc;

    private String checkerAccount;

    private Date checkDate;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getAnimalId() {
        return animalId;
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId == null ? null : animalId.trim();
    }

    public String getCheckItem() {
        return checkItem;
    }

    public void setCheckItem(String checkItem) {
        this.checkItem = checkItem == null ? null : checkItem.trim();
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult == null ? null : checkResult.trim();
    }

    public String getTreatmentDesc() {
        return treatmentDesc;
    }

    public void setTreatmentDesc(String treatmentDesc) {
        this.treatmentDesc = treatmentDesc == null ? null : treatmentDesc.trim();
    }

    public String getCheckerAccount() {
        return checkerAccount;
    }

    public void setCheckerAccount(String checkerAccount) {
        this.checkerAccount = checkerAccount == null ? null : checkerAccount.trim();
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }
}