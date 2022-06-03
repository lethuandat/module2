package bai_tap_them.quan_ly_benh_an.model;

public abstract class Patient {
    private Integer numerical;
    private String patientID;
    private String patienterID;
    private String namePatient;
    private String dayStart;
    private String dayEnd;
    private String reason;

    public Patient() {
    }

    public Patient(Integer numerical, String patientID, String patienterID, String namePatient, String dayStart, String dayEnd, String reason) {
        this.numerical = numerical;
        this.patientID = patientID;
        this.patienterID = patienterID;
        this.namePatient = namePatient;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.reason = reason;
    }

    public Integer getNumerical() {
        return numerical;
    }

    public void setNumerical(Integer numerical) {
        this.numerical = numerical;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getDayStart() {
        return dayStart;
    }

    public void setDayStart(String dayStart) {
        this.dayStart = dayStart;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPatienterID() {
        return patienterID;
    }

    public void setPatienterID(String patienterID) {
        this.patienterID = patienterID;
    }

    @Override
    public String toString() {
        return "STT: " + numerical +
                ", patientID: " + patientID +
                ", patienterID: " + patienterID +
                ", namePatient: " + namePatient +
                ", dayStart: " + dayStart +
                ", dayEnd: " + dayEnd +
                ", reason: " + reason;
    }

    public abstract String getInfo();
}
