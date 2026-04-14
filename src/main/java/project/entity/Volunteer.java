package project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Volunteer")
@PrimaryKeyJoinColumn(name = "staff_id")
public class Volunteer extends Staff {

    @Column(name = "training_status")
    private String trainingStatus;
    @Column(name = "available_shifts")
    private String availableShifts;

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public String getAvailableShifts() {
        return availableShifts;
    }

    public void setAvailableShifts(String availableShifts) {
        this.availableShifts = availableShifts;
    }

    @Override
    public String toString() {
        return "Volunteer{" +
                "availableShifts='" + availableShifts + '\'' +
                ", trainingStatus='" + trainingStatus + '\'' +
                '}';
    }
}
