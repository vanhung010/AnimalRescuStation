package project.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "Staff")
@Inheritance(strategy = InheritanceType.JOINED)
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private Integer staffId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "staff_type", nullable = false)
    private String staffType;
    @ManyToMany(mappedBy = "staffMembers")
    private List<RescueMission> missions;

    public Staff() {
        this.missions = new ArrayList<>();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public List<RescueMission> getMissions() {
        return missions;
    }

    public void setMissions(List<RescueMission> missions) {
        this.missions = missions;
    }


}
