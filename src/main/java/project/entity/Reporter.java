package project.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Reporter")
public class Reporter {
    //joincolum tạo cột id khóa ngoại
    //mappby
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reporter_id")
    private Integer reporterId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "address", nullable = true)
    private String address;
    @OneToMany(mappedBy = "reporter")
    private List<RescueRequest> requests;

    public Integer getReporterId() {
        return reporterId;
    }

    public void setReporterId(Integer reporterId) {
        this.reporterId = reporterId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<RescueRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<RescueRequest> requests) {
        this.requests = requests;
    }
// @OneToMany
}
