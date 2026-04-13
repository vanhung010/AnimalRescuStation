package project;



import project.ui.AnimalMenu;
import project.util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        System.out.println("Đang kết nối Database...");
        HibernateUtil.getSessionFactory(); // Kích hoạt Hibernate tạo bảng

        AnimalMenu animalMenu = new AnimalMenu();
        animalMenu.displayMenu();

        HibernateUtil.shutdown();
    }
}