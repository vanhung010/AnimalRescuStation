package project.ui;


import project.dao.BreedDao;
import project.dao.SpeciesDao;
import project.entity.Breed;
import project.entity.Species;

import java.util.List;
import java.util.Scanner;

public class AnimalMenu {
    private final SpeciesDao speciesDAO = new SpeciesDao();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DANH MỤC LOÀI ---");
            System.out.println("1. Thêm loài mới");
            System.out.println("2. Xem danh sách các loài");
            System.out.println("3. Tìm kiếm loài theo tên");
            System.out.println("4. Thêm giống mới");
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addNewSpecies();
                    break;
                case 2:
                    showAllSpecies();
                    break;
                case 3:
                   findSpecies();
                    break;
                case 4:
                    addNewBreed();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addNewBreed(){
        SpeciesDao speciesDao = new SpeciesDao();
        BreedDao breedDao = new BreedDao();
        System.out.println("Nhập tên loài của giống. Ví dụ Chó, Mèo,...");

        String nameSpecies = scanner.nextLine();
        Species species = speciesDao.findSpeciesByName(nameSpecies);
        if(species == null){
            System.out.println("Lỗi không tìm thấy loài trong cow sở dữ liệu, vui lòng nhập lại");
            return;
        }

        System.out.println("Mời nhập tên giống");
       String nameBreed = scanner.nextLine();
       System.out.println("Nhập mô tả");
       String description = scanner.nextLine();

       Breed breed = new Breed();
        breed.setBreedName(nameBreed);
        breed.setDescription(description);
       breed.setSpecies(species);

       species.addBreed(breed);

        breedDao.addBreed(breed);


    }

    private void addNewSpecies() {
        System.out.print("Nhập tên loài (VD: Chó, Mèo, Chim): ");
        String name = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String desc = scanner.nextLine();

        Species species = new Species();
        species.setSpeciesName(name);
        species.setDescription(desc);

        speciesDAO.save(species);
    }

    private void showAllSpecies() {
        List<Species> list = speciesDAO.getAllSpecies();
        if (list.isEmpty()) {
            System.out.println("Danh sách trống.");
        } else {
            System.out.println("\nDANH SÁCH CÁC LOÀI:");
            for (Species s : list) {
                System.out.printf("ID: %d | Tên: %s | Mô tả: %s\n",
                        s.getSpeciesId(), s.getSpeciesName(), s.getDescription());
            }
        }
    }

    public void findSpecies(){
        SpeciesDao speciesDao = new SpeciesDao();
        System.out.println("Mời nhập tên loài");
        String name = scanner.nextLine();
        System.out.println(speciesDao.findSpeciesByName(name));
    }
}