package project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "rescue_mission")
public class RescueMission {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "mission_id")
    private Integer missionId;
   @Column(name = "dispatch_time")
    private LocalDateTime dispatchTime;
   @Column(name = "return_time")
    private LocalDateTime returnTime;
   @Column(name = "mission_status")
    private String missionStatus;
   @Column(name = "mission_note")
    private String missionNote;
   @ManyToOne()
   @JoinColumn(name = "request_id")
    private RescueRequest request;
  @ManyToMany
  @JoinTable(
          name = "Mission_Staff",
          joinColumns = @JoinColumn(name = "mission_id"),
          inverseJoinColumns = @JoinColumn(name = "staff_id")
  )
    private List<Staff> staffMembers;
  @OneToMany(mappedBy = "mission")
    private List<Animal> rescuedAnimals;

    public RescueMission() {
        this.rescuedAnimals = new ArrayList<>();
        this.staffMembers = new ArrayList<>();
    }

    public Integer getMissionId() {
        return missionId;
    }

    public void setMissionId(Integer missionId) {
        this.missionId = missionId;
    }

    public LocalDateTime getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(LocalDateTime dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public LocalDateTime getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(LocalDateTime returnTime) {
        this.returnTime = returnTime;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getMissionNote() {
        return missionNote;
    }

    public void setMissionNote(String missionNote) {
        this.missionNote = missionNote;
    }

    public RescueRequest getRequest() {
        return request;
    }

    public void setRequest(RescueRequest request) {
        this.request = request;
    }

    public List<Staff> getStaffMembers() {
        return staffMembers;
    }

    public void setStaffMembers(List<Staff> staffMembers) {
        this.staffMembers = staffMembers;
    }

    public List<Animal> getRescuedAnimals() {
        return rescuedAnimals;
    }

    public void setRescuedAnimals(List<Animal> rescuedAnimals) {
        this.rescuedAnimals = rescuedAnimals;
    }

    public void add(Staff staff){
        this.staffMembers.add(staff);
        staff.getMissions().add(this);
    }
}
