package bai_tap_them.quan_ly_nhan_vien_2.service;

public interface IEmployeeService {
    //Tạo ra 1 interface có phương thức chấm công, không nên tạo trong abstract class employee
    //Vì chỉ có nhân viên quản lý và sản xuất mới cần chấm công ( implements interface là xong)
    //Tất cả các loại nhân viên đều extends từ class cha employee, nếu tạo phương thức abstract trong lớp employee
    //Thì tất cả các lớp nhân viên phải overriding lại phương thức chấm công ( ở đây chỉ có nhân viên quản lý và sản xuất mới cần chấm công)
    String keepingTime();
}
