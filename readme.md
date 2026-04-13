Hệ thống Quản lý Trạm Cứu hộ Động vật (Animal Rescue Management System)
📌 Giới thiệu dự án
Dự án là một ứng dụng Java Console được thiết kế để quản lý quy trình vận hành của một trạm cứu hộ động vật. Hệ thống tập trung vào việc xử lý luồng dữ liệu từ khi tiếp nhận tin báo, thực hiện chuyến cứu hộ, quản lý hồ sơ y tế cho đến khi động vật được nhận nuôi.

Project được xây dựng nhằm mục tiêu thực hành kỹ thuật ORM (Object-Relational Mapping) với Hibernate và áp dụng tư duy thiết kế cơ sở dữ liệu ở Dạng chuẩn 3 (3NF).

🚀 Tính năng chính
1. Quản lý Động vật (Animal Management)
   Quản lý danh mục Loài (Species) và Giống (Breed) theo phân cấp.

Tiếp nhận và lưu trữ thông tin động vật (Tên, tuổi, tình trạng sức khỏe, nguồn gốc cứu hộ).

Theo dõi trạng thái nhận nuôi.

2. Nghiệp vụ Cứu hộ (Rescue Workflow)
   Ghi nhận tin báo từ người dân (Reporter & Rescue Request).

Lập kế hoạch và điều phối chuyến cứu hộ (Rescue Mission).

Phân công nhân sự thực hiện chuyến đi (Mission Staff).

3. Quản lý Y tế (Medical & Health)
   Theo dõi hồ sơ khám bệnh chi tiết (Medical Record).

Quản lý danh mục Vắc-xin và lịch sử tiêm chủng (Vaccine & Record Vaccine).

Tự động tính toán chi phí phát sinh trong quá trình điều trị.

4. Quản lý Nhận nuôi & Quyên góp (Adoption & Donation)
   Quản lý thông tin người nhận nuôi và xét duyệt hồ sơ.

Thực hiện giao dịch bàn giao động vật.

Ghi nhận các khoản đóng góp từ nhà tài trợ.

5. Quản lý Nhân sự (Staff Management)
   Quản lý danh sách nhân viên chung.

Phân tách vai trò cụ thể cho Tình nguyện viên (Volunteer) và Bác sĩ thú y (Veterinarian).

🛠 Công nghệ sử dụng
Ngôn ngữ: Java (JDK 17+)

Framework ORM: Hibernate 5.x / 6.x

Cơ sở dữ liệu: PostgreSQL

Giao diện: Java Console (Scanner & System.out)

Quản lý thư viện: Maven 