package project.ui;


import org.hibernate.Session;
import org.hibernate.Transaction;
import project.dao.*;
import project.entity.*;
import project.util.HibernateUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class AnimalMenu {
    private final SpeciesDao speciesDAO = new SpeciesDao();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DANH MỤC LOÀI ---");
//            System.out.println("1. Thêm loài mới");
//            System.out.println("2. Xem danh sách các loài");
//            System.out.println("3. Tìm kiếm loài theo tên");
//            System.out.println("4. Thêm giống mới");
//            System.out.println("5. Thêm tình nguyện viên");
//            System.out.println("6. Thêm bác sĩ thú y");
//            System.out.println("7. Danh sách tất cả các nhân viên");
//            System.out.println("8. Thêm người báo cứu hộ");
//            System.out.println("9. THêm yêu cầu cứu hộ");
//            System.out.println("10. Danh sách những yêu cầu cứu hộ");
//            System.out.println("0. Quay lại menu chính");
            System.out.println("1. Xem danh sách các loài");
            System.out.println("2. Xem danh sách tất cả các nhân viên");
            System.out.println("3. Xem danh sách những yêu cầu cứu hộ");
            System.out.println("4. Xem danh sách những người báo cứu hộ");
            System.out.println("5. Xem danh sách những cuộc cứu hộ");
            System.out.println("6. Xem danh sách động vật");
            System.out.println("7. Xem danh sách những người nhận nuôi");
            System.out.println("8. Xem danh sách những lần nhận nuôi");
            System.out.println("9. THêm yêu cầu cứu hộ");
            System.out.println("10. ");
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
                case 5:
                    addStaff(true);
                    break;
                case 6:
                    addStaff(false);
                    break;
                case 7:
                   allStaff();
                    break;
                case 8:
                    addReporter();
                    break;
                case 9:
                    addRescueRequest();
                    break;
                case 10:
                    allRescueRequest();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    public void allRescueRequest(){
        RescueRequestDao rescueRequestDao = new RescueRequestDao();
        List<RescueRequest> rescueRequestList = rescueRequestDao.getAllRescurequest();
        System.out.println("-----Danh sách tất cả những yêu cầu cứu hộ");
        for(RescueRequest rescueRequest : rescueRequestList){
            System.out.printf("ID: %d | Địa điểm: %s | Tình trạng: %s%n",
                    rescueRequest.getRequestId(),
                    rescueRequest.getIncidentLocation(),
                    rescueRequest.getRequestStatus());
        }

    }

    public void addRescueRequest(){
        RescueRequestDao rescueRequestDao = new RescueRequestDao();
        ReporterDao reporterDao = new ReporterDao();

        RescueRequest rescueRequest = new RescueRequest();
        Reporter reporter = new Reporter();

        System.out.println("Nhập thời gian cuộc cứu hộ (yyyy-MM-ddTHH:mm) ví dụ 2026-04-14T19:30");

        String date = scanner.nextLine();

        // Sử dụng DateTimeFormatter hỗ trợ cả 1 và 2 chữ số cho tháng/ngày
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("u-M-d'T'HH:mm");
        try {
            rescueRequest.setRequestDate(LocalDateTime.parse(date, formatter));
        } catch (DateTimeParseException e) {
            System.out.println("❌ Định dạng ngày giờ không hợp lệ! Vui lòng sử dụng định dạng yyyy-MM-ddTHH:mm");
            return;
        }

        System.out.println("Nhập địa điểm cứu hộ");

        rescueRequest.setIncidentLocation(scanner.nextLine());

        System.out.println("Nhập trạng thái động vật");

        rescueRequest.setAnimalCondition(scanner.nextLine());

        System.out.println("Nhập tên người báo cứu hộ");

        reporter = reporterDao.getReporterByName(scanner.nextLine());


        rescueRequest.setReporter(reporter);

        rescueRequest.setRequestStatus("Đang cứu hộ");

        rescueRequestDao.save(rescueRequest);
    }

    private void addReporter(){
        ReporterDao reporterDao = new ReporterDao();
        Reporter reporter = new Reporter();
        System.out.println("Nhập tên người báo tin");
        reporter.setFullName(scanner.nextLine());
        System.out.println("Nhập soos điện thoại người báo tin");
        reporter.setPhoneNumber(scanner.nextLine());
        System.out.println("Nhập địa chỉ người báo tin");
        reporter.setAddress(scanner.nextLine());

        reporterDao.save(reporter);
    }

    private void allStaff(){
        StaffDao staffDao = new StaffDao();
        List<Staff> staffList = staffDao.getAllStaff();
        if(staffList.isEmpty()){
            System.out.println("Trung tâm chưa có nhân viên nàooo");
        }
        System.out.println("\n--- DANH SÁCH TOÀN BỘ NHÂN SỰ ---");
        for(Staff staff : staffList){

                System.out.printf("ID: %d | Tên: %s | SĐT: %s | Loại: %s%n",
                        staff.getStaffId(),
                        staff.getFullName(),
                        staff.getPhoneNumber(),
                        staff.getStaffType());
            if (staff instanceof Volunteer) {
                Volunteer v = (Volunteer) staff;
                System.out.println("  ↳ [Tình nguyện viên] Trạng thái: " + v.getTrainingStatus() + " | Ca rảnh: " + v.getAvailableShifts());
            } else if (staff instanceof Veterinarian) {
                Veterinarian v = (Veterinarian) staff;
                System.out.println("  ↳ [Bác sĩ] Chuyên khoa: " + v.getSpecialty() + " | Số GP: " + v.getLicenseNumber());
            }
        }
    }

    private void addStaff(boolean isVolunter){
        Staff staff;
        //nhập thông tin cơ bản của nhân viên
        System.out.println("Nhập tên nhân viên ");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại nhân viên");
        String phone = scanner.nextLine();
        LocalDate dateStart = LocalDate.now();
        String staffType = isVolunter ? "Tình nguyện viên" : "Bác sĩ thú y";
        //kiểm tra loại
        if(isVolunter){
            Volunteer volunteer = new Volunteer();

            String trainingStatus = "Intern";

            System.out.println("Nhập ca làm: ví dụ Thứ 7, Thứ 2,...");
            volunteer.setAvailableShifts(scanner.nextLine());
            //set thuộc tính
           volunteer.setTrainingStatus(trainingStatus);

            staff = volunteer;
        }
        else {
            Veterinarian veterinarian = new Veterinarian();
            System.out.println("Nhập số chứng chỉ hành nghề của bác sĩ thú y ");
            veterinarian.setLicenseNumber(scanner.nextLine());
            System.out.println("Nhập loại của bác sĩ thú y");
            veterinarian.setSpecialty(scanner.nextLine());

            staff = veterinarian;
        }
        //set các thông tin cơ bản
        staff.setFullName(name);
        staff.setPhoneNumber(phone);
        staff.setStartDate(dateStart);
        staff.setStaffType(staffType);

        StaffDao staffDao = new StaffDao();
        staffDao.save(staff);

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

       breed.setSpecies(species);

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