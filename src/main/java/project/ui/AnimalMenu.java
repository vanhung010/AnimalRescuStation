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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AnimalMenu {
    private final SpeciesDao speciesDAO = new SpeciesDao();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ DANH MỤC LOÀI ---");

            System.out.println("1. Xem danh sách các loài");
            System.out.println("2. Xem danh sách tất cả các nhân viên");
            System.out.println("3. Xem danh sách những yêu cầu cứu hộ");
            System.out.println("4. Xem danh sách những người báo cứu hộ");
            System.out.println("5. Xem danh sách những cuộc cứu hộ");
            System.out.println("6. Xem danh sách động vật");
            System.out.println("7. Xem danh sách những người nhận nuôi");
            System.out.println("8. Xem danh sách những lần nhận nuôi");//unfinish
            System.out.println("9. Xem danh sách hồ sơ y tế");//unfinish
            System.out.println("11. Thêm loài mới");
            System.out.println("12. Thêm giống mới");
            System.out.println("13. Thêm tình nguyện viên");
            System.out.println("14. Thêm bác sĩ thú y");
            System.out.println("15. Thêm người báo cứu hộ");
            System.out.println("16. Thêm yêu cầu cứu ho");
            System.out.println("17. Thêm Chuyến cứu hộ");
            System.out.println("18. Tiếp nhận Động vật");
            System.out.println("19. Thêm Hồ sơ Y tế");//unfinish
            System.out.println("20. Thêm Người nhận nuôi");
            System.out.println("21. Thêm Giao dịch nhận nuôi");//unfinish
            System.out.println("22. Thêm khoản Quyên góp");//unfinish
            System.out.println("23. Thêm vaccine cho trạm");
            System.out.println("24. Cập nhật trạng thái yêu cầu cứu hộ");//unfinish
            System.out.println("25. Cập nhật trạng thái chuyến cứu hộ");//unfinish
            System.out.println("26. Cập nhật trạng thái động vật");//unfinish
            System.out.println("27. Tính tổng số tiền quyên góp (Donation) trong tháng.");//unfinish
            System.out.println("28. Tra cứu Lịch sử");//unfinish
            System.out.println("0. Quay lại menu chính");
            System.out.print("Chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAllSpecies();
                    break;
                case 2:
                    allStaff();
                    break;
                case 3:
                    allRescueRequest();
                    break;
                case 4:
                    showAllReporters();
                    break;
                case 5:
                    showAllRescueMissions();
                    break;
                case 6:
                    showAllAnimals();
                    break;
                case 7:
                    showAllAdopters();
                    break;
                case 8:
                    showAllAdoptionTransactions();
                    break;
                case 9:
                    showAllMedicalRecords();
                    break;
                case 11:
                    addNewSpecies();
                    break;
                case 12:
                    addNewBreed();
                    break;
                case 13:
                    addStaff(true);
                    break;
                case 14:
                    addStaff(false);
                    break;
                case 15:
                    addReporter();
                    break;
                case 16:
                    addRescueRequest();
                    break;
                case 17:
                    addRescueMission();
                    break;
                case 18:
                    admitAnimal();
                    break;
                case 19:
                    addMedicalRecord();
                    break;
                case 20:
                    addAdopter();
                    break;
                case 21:
                    addAdoptionTransaction();
                    break;
                case 22:
                    addDonation();
                    break;
                case 23:
                    addVaccine();
                    break;
                case 24:
                    updateRescueRequestStatus();
                    break;
                case 25:
                    updateRescueMissionStatus();
                    break;
                case 26:
                    updateAnimalStatus();
                    break;
                case 27:
                    calculateMonthlyDonationTotal();
                    break;
                case 28:
                    lookupHistory();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        }
    }

    private void addVaccine() {
        VaccineDao vaccineDao = new VaccineDao();
        Vaccine vaccine = new Vaccine();

        System.out.println("Nhập tên vaccine");
        vaccine.setVaccineName(scanner.nextLine());
        System.out.println("Nhập mô tả vaccine");
        vaccine.setDescription(scanner.nextLine());
        while(true) {
        System.out.println("Nhập giá vaccine");
        String priceString = scanner.nextLine();
        double priceDouble = 0;

            try {
                priceDouble = Double.parseDouble(priceString);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        }



    }

    public void showAllVaccine(){
        VaccineDao vaccineDao = new VaccineDao();
        List<Vaccine> vaccineList = vaccineDao.getAllVaccine();
        System.out.println("-----Danh sách tất cả vaccine-----");
        for(Vaccine vaccine : vaccineList){
            System.out.printf("ID: %d | Tên: %s | Mô tả: %s | Giá: %.2f%n");
        }
    }


    private void addRescueMission() {
        allRescueRequest();

        RescueRequest rescueRequest = new RescueRequest();
        RescueMission rescueMission = new RescueMission();
        RescueMissionDao rescueMissionDao = new RescueMissionDao();
        StaffDao staffDao = new StaffDao();

        RescueRequestDao rescueRequestDao = new RescueRequestDao();

        System.out.println("Nhập id yêu cầu cứu hộ");
        int requestid = Integer.parseInt(scanner.nextLine());
        rescueRequest = rescueRequestDao.getRescueRequestById(requestid);
        allStaff();
        while(true){
            System.out.println("Nhập id nhân viên thực hiện cứu hộ (Nhập 0 nếu đã thêm đủ nhân viên)");
            String idStaffString = scanner.nextLine();
            int idStaff =0;
           try{

                idStaff = Integer.parseInt(idStaffString);
                //Nếu nhập 0
                if(idStaff == 0){
                    System.out.println("Chốt danh sách nhân sự tham gia chuyến đi");
                    break;
                }
               Staff staff = staffDao.getStaffById(idStaff);
               if(staff != null){
                   rescueMission.add(staff);
               }
               else{
                   System.out.println("Không tìm thấy nhân viên với id "+ idStaff);
               }

           }
           catch (NumberFormatException e) {
               System.out.println("Vui long nhập đúng id nhân viên");
           }
        }


            System.out.println("Nhập thời gian gửi chuyến cứu hộ (yyyy-MM-ddTHH:mm) ví dụ 2026-04-14T19:30");

        String date = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("u-M-d'T'HH:mm");
        try {
            rescueMission.setDispatchTime(LocalDateTime.parse(date, formatter));
        } catch (DateTimeParseException e) {
            System.out.println("❌ Định dạng ngày giờ không hợp lệ! Vui lòng sử dụng định dạng yyyy-MM-ddTHH:mm");
            return;
        }

        System.out.println("Nhập thời gian chuyến cứu hộ về (yyyy-MM-ddTHH:mm) ví dụ 2026-04-14T19:30");

        String date1 = scanner.nextLine();

        try {
            rescueMission.setReturnTime(LocalDateTime.parse(date1, formatter));
        } catch (DateTimeParseException e) {
            System.out.println("❌ Định dạng ngày giờ không hợp lệ! Vui lòng sử dụng định dạng yyyy-MM-ddTHH:mm");
            return;
        }

        System.out.println("Nhập tình trạng chuyến cứu hộ");
        rescueMission.setMissionStatus(scanner.nextLine());

        System.out.println("Nhập ghi chú chuyến cứu hộ nếu có");
        rescueMission.setMissionNote(scanner.nextLine());

        rescueMission.setRequest(rescueRequest);

        rescueMissionDao.save(rescueMission);

    }

    private void showAllReporters() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Reporter> reporters = session.createQuery("FROM Reporter", Reporter.class).list();
            if (reporters.isEmpty()) {
                System.out.println("Danh sách trống.");
                return;
            }

            System.out.println("\n--- DANH SÁCH NGƯỜI BÁO CỨU HỘ ---");
            for (Reporter reporter : reporters) {
                System.out.printf("ID: %d | Tên: %s | SĐT: %s | Địa chỉ: %s%n",
                        reporter.getReporterId(),
                        reporter.getFullName(),
                        reporter.getPhoneNumber(),
                        reporter.getAddress());
            }
        }
    }

    private void showAllRescueMissions() {
        RescueMissionDao rescueMissionDao = new RescueMissionDao();

        List<RescueMission> rescueMissionList = rescueMissionDao.getAllRescueMission();

        if(rescueMissionList.isEmpty()){
            System.out.println("Chưa có chuyến cứu hộ được thực hiện");
        }
        else {
            System.out.println("-----Danh sách những cuộc cứu hộ-----");
            for(RescueMission rescueMission: rescueMissionList){
                LocalDateTime dispath = rescueMission.getDispatchTime();
                LocalDateTime return1 = rescueMission.getReturnTime();

                System.out.printf("ID: %d | Thời gian gửi chuyến cứu hộ: Ngày %td, Tháng %tm, năm %tY, %tH giờ, %tM phút | Thời gian chuyến cứu hộ quay về: Ngày %td, Tháng %tm, năm %tY, %tH giờ, %tM phút | Tình trạng chuyến cứu hộ: %s | Ghi chú: %s%n",
                        rescueMission.getMissionId(), dispath, dispath, dispath, dispath, dispath, return1, return1, return1, return1, return1, rescueMission.getMissionStatus(), rescueMission.getMissionNote());
            }
        }

    }

    private void showAllAnimals() {
        AnimalDao animalDao = new AnimalDao();
        List<Animal> animalList = animalDao.getAllAnimal();
        if(animalList.isEmpty()) {
            System.out.println("Chưa có động vật");
            return;
        }
        System.out.println("------Danh sách động vật------");
        for(Animal animal: animalList){
            System.out.printf("ID: %d | Tên động vật: %s | Tên giống: %s | Tuổi ước tính: %d | Tình trạng sức khỏe: %s | Trạng thái nhận nuôi: %s%n", animal.getAnimalId(), animal.getName(),
                    animal.getBreed().getBreedName(), animal.getEstimatedAge(), animal.getCurrentHealthStatus(), animal.getAdoptionStatus());
        }
    }

    private void showAllAdopters() {
        AdopterDao adopterDao = new AdopterDao();
        List<Adopter> adopterList = adopterDao.getAllAdopter();
        if(adopterList.isEmpty()){
            System.out.println("Chưa có người nhận nuôi");
            return;
        }
        else{
            System.out.println("--------Danh sách những người nhận nuôi--------");
            for (Adopter adopter : adopterList){
                System.out.printf("ID: %d | Tên: %s | Số điện thoại: %s | Trạng thái: %s%n", adopter.getAdopterId(), adopter.getFullName(), adopter.getPhoneNumber(), adopter.getApplicationApprovalStatus());
            }
        }

    }

    private void showAllAdoptionTransactions() {
    }

    private void showAllMedicalRecords() {
    }

    public void showAllBreed(){
        BreedDao breedDao = new BreedDao();
        List<Breed> breedList = breedDao.getAllBreed();
        for(Breed breed : breedList){
            System.out.printf("ID: %d | Tên giống: %s | Mô tả: %s%n", breed.getBreedId(), breed.getBreedName(), breed.getDescription());
        }
    }

    private void admitAnimal() {
        showAllRescueMissions();  //show những cuộc cứu hộ

        RescueMissionDao rescueMissionDao = new RescueMissionDao();
        BreedDao breedDao = new BreedDao();
        Animal animal = new Animal();
        AnimalDao animalDao = new AnimalDao();
        System.out.println("Nhập id cuộc cứu hộ nếu động vật từ cứu hộ(Bỏ qua nếu không có, nhập 0 hoặc chữ)");

        String idRescue = scanner.nextLine();
        int idRescueInt =0;

        try {
            idRescueInt = Integer.parseInt(idRescue);
        }
        catch (NumberFormatException e){
        }

        RescueMission rescueMission = rescueMissionDao.getRescueMissionById(idRescueInt);
        //Nếu cứu hộ khác null thì set
        if(rescueMission != null){
            animal.setMission(rescueMission);
        }


        //show all giống
        showAllBreed();

        System.out.println("Nhập id giống của động vật muốn thêm");

        String idBreedString = scanner.nextLine();

        int idBreedInt = 0;
        //xử lí idBreed
        try {
            idBreedInt = Integer.parseInt(idBreedString);
        }
        catch(NumberFormatException e){
            System.out.println("Vui lòng nhập số");
        }
        Breed breed = breedDao.getBreedById(idBreedInt);
        //gán id giống
        if(breed != null) {
            animal.setBreed(breed);
        }
        else{
            System.out.println("không có giống");
            return;
        }

        System.out.println("Nhập tên thus cưng");
        animal.setName(scanner.nextLine());


        System.out.println("Nhập tuổi ước tính");
        String ageString = scanner.nextLine();
        int ageInt = 0;
        try{
            ageInt = Integer.parseInt(ageString);
        }
        catch(NumberFormatException e){
            System.out.println("Nhập số");
        }
        animal.setEstimatedAge(ageInt); //set tuổi
        boolean isValid = true;
        while(isValid) {

            System.out.println("Nhập ngày tham giao trạm cứu hộ theo định dangg dd/MM/yyyy (ví dụ 15/02/2026");

            String dateString = scanner.nextLine();

            LocalDate intakeDate = null;
            DateTimeFormatter intakeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            try {
                intakeDate = LocalDate.parse(dateString, intakeFormat);
                animal.setIntakeDate(intakeDate);
                isValid = false;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng vui lòng nhập lại");
            }
        }

        System.out.println("Nhập tình trạng sức khỏe");
        
        animal.setCurrentHealthStatus(scanner.nextLine());
        
        animal.setAdoptionStatus("Chưa được nhận nuôi");

        animalDao.save(animal);

    }

    private void addMedicalRecord() {
        MedicalRecordDao medicalRecordDao = new MedicalRecordDao();
        MedicalRecord medicalRecord = new MedicalRecord();


    }

    private void addAdopter() {
        //khởi tạo
        AdopterDao adopterDao = new AdopterDao();
        Adopter adopter = new Adopter();
        System.out.println("Nhâp tên người nhận nuôi");
        adopter.setFullName(scanner.nextLine());
        System.out.println("Nhập số điện thoại của người nhận nuôi");
        adopter.setPhoneNumber(scanner.nextLine());
        System.out.println("Nhap địa chỉ người nhận nuôi");
        adopter.setResidentialAddress(scanner.nextLine());
        adopter.setApplicationApprovalStatus("Đang chờ phê duyệt");
        adopterDao.save(adopter);
    }

    private void addAdoptionTransaction() {
    }

    private void addDonation() {
    }

    private void updateRescueRequestStatus() {
    }

    private void updateRescueMissionStatus() {
    }

    private void updateAnimalStatus() {
    }

    private void calculateMonthlyDonationTotal() {
    }

    private void lookupHistory() {
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
        showAllReporters();


        RescueRequestDao rescueRequestDao = new RescueRequestDao();
        ReporterDao reporterDao = new ReporterDao();

        RescueRequest rescueRequest = new RescueRequest();
        Reporter reporter = new Reporter();

        rescueRequest.setRequestStatus("Đang thực hiện");




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



        rescueRequestDao.save(rescueRequest);

        System.out.println("Thêm thành ooong yêu cầu cứu hộ");
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

        System.out.println("Thêm thành công người báo tin: " + reporter.getFullName());
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