package bai_tap_them.quan_ly_benh_an.model;

import bai_tap_them.quan_ly_benh_an.comma.Comma;

public class NormalPatient extends Patient {
    private double fee;

    public NormalPatient() {
    }

    public NormalPatient(Integer numerical, String patientID, String patienterID, String namePatient, String dayStart, String dayEnd, String reason, double fee) {
        super(numerical, patientID, patienterID, namePatient, dayStart, dayEnd, reason);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", fee: " + fee;
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
                this.getFee() + "\n";
    }
}
