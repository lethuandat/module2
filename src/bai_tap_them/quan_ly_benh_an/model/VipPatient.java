package bai_tap_them.quan_ly_benh_an.model;

import bai_tap_them.quan_ly_benh_an.comma.Comma;

public class VipPatient extends Patient {
    private String type;
    private String duration;

    public VipPatient() {
    }

    public VipPatient(Integer numerical, String patientID, String patienterID, String namePatient, String dayStart, String dayEnd, String reason, String type, String duration) {
        super(numerical, patientID, patienterID, namePatient, dayStart, dayEnd, reason);
        this.type = type;
        this.duration = duration;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", type: " + type +
                ", duration: " + duration;
    }

    @Override
    public String getInfo() {
        return super.getNumerical() + Comma.COMMA +
                super.getPatientID() + Comma.COMMA +
                super.getPatienterID() + Comma.COMMA +
                super.getNamePatient() + Comma.COMMA +
                super.getDayStart() + Comma.COMMA +
                super.getDayEnd() + Comma.COMMA +
                super.getReason() + Comma.COMMA +
                this.getType() + Comma.COMMA +
                this.getDuration() + "\n";
    }
}
