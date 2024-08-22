package view;

import input.Input;
import manager.BrandManager;
import model.brand.Brand;

import java.util.List;

public class MenuBrand {
    BrandManager brandManager = new BrandManager();
    public void showMenuBrand() {
        int choice;
        do {
            System.out.println("========Quản lý thương hiệu========");
            System.out.println("1. Thêm mới thương hiệu");
            System.out.println("2. Sửa thông tin thương hiệu");
            System.out.println("3. Xóa thương hiệu");
            System.out.println("4. Hiển thị danh sách thương hiệu");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showMenuAll();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý thương hiệu!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showMenuAdd(){
        System.out.println("=====Thêm mới thương hiệu=====");
        System.out.print("Nhập tên thương hiệu: ");
        String name = Input.inputString();
        Brand brand = new Brand(name);
        brandManager.add(brand);
        System.out.println("Thêm thương hiệu thành công!");
    }

    private void showMenuEdit() {
        System.out.println("=====Sửa thông tin thương hiệu=====");
        System.out.print("Nhập mã thương hiệu muốn sửa: ");
        int idEdit = Input.inputInteger();
        if (brandManager.findIndexById(idEdit) != -1){
            System.out.print("Nhập tên thương hiệu: ");
            String name = Input.inputString();
            Brand brand = new Brand(idEdit,name);
            brandManager.update(idEdit,brand);
            System.out.println("Sửa thông tin thương hiệu thành công!");
        } else {
            System.out.println("Không tìm thấy mã thương hiệu!");
        }
    }

    private void showMenuRemove() {
        System.out.println("=====Xóa thương hiệu=====");
        System.out.print("Nhập mã thương hiệu muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (brandManager.findIndexById(idRemove) != -1){
            brandManager.remove(idRemove);
            System.out.println("Xóa thương hiệu thành công!");
        } else {
            System.out.println("Không tìm thấy mã thương hiệu!");
        }
    }

    private void showMenuAll(){
        System.out.println("=====Hiển thị danh sách thương hiệu=====");
        List<Brand> brandList = brandManager.getAll();
        for (Brand brand : brandList){
            System.out.println(brand);
        }
    }
}
