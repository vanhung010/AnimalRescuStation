package project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="Species")
public class Species {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "species_id")
   private Integer speciesId;
    @Column(name = "species_name")
  private  String speciesName;
    @Column(name = "description")
   private String description;
    @OneToMany(mappedBy = "species")
     private List<Breed> breeds;

    public Species() {
        this.breeds = new ArrayList<>();
    }



    @Override
    public String toString() {
        return "Species{" +
                "speciesName='" + speciesName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Breed> getBreeds() {
        return breeds;
    }


    public void setBreeds(List<Breed> breeds) {
        this.breeds = breeds;
    }

    // Hàm Helper Method
    public void addBreed(Breed breed) {
        // 1. Phía MỘT (Species) nhận con: Cập nhật RAM (In-Memory)
        this.breeds.add(breed);

        // 2. Phía NHIỀU (Breed) nhận cha: Chuẩn bị Khóa ngoại cho Database
        breed.setSpecies(this);
    }
}
