package project.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Rescue_Request")
public class RescueRequest {
    // Class: RescueRequest
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Integer requestId;
    @Column(name = "request_date")
    private LocalDateTime requestDate;
    @Column(name = "incident_location")
    private String incidentLocation;
    @Column(name = "animal_condition")
    private String animalCondition;
    @Column(name = "request_status")
    private String requestStatus;
    @ManyToOne()
    @JoinColumn(name = "reporter_id")
    private Reporter reporter;
    @OneToMany(mappedBy = "request")
    private List<RescueMission> missions;

    public RescueRequest() {
        this.missions = new ArrayList<>();
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public String getIncidentLocation() {
        return incidentLocation;
    }

    public void setIncidentLocation(String incidentLocation) {
        this.incidentLocation = incidentLocation;
    }

    public String getAnimalCondition() {
        return animalCondition;
    }

    public void setAnimalCondition(String animalCondition) {
        this.animalCondition = animalCondition;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public List<RescueMission> getMissions() {
        return missions;
    }

    public void setMissions(List<RescueMission> missions) {
        this.missions = missions;
    }

    // @OneToMany
}
