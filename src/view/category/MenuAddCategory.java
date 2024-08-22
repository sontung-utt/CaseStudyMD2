package view.category;

import input.Input;
import manager.CategoryManager;
import model.category.*;

public class MenuAddCategory {
    CategoryManager categoryManager = new CategoryManager();
    public void showMenuAddCategory(){
        int choice;
        do {
            System.out.println("=====Thêm loại sản phẩm=====");
            System.out.println("1. Thêm loại đồ nội thất");
            System.out.println("2. Thêm loại đồ công nghệ");
            System.out.println("3. Thêm loại thiết bị hình ảnh");
            System.out.println("4. Thêm loại đồ phụ kiện");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice){
                case 1:
                    showAddFurniture();
                    break;
                case 2:
                    showAddElectronic();
                    break;
                case 3:
                    showAddDeviceVisual();
                    break;
                case 4:
                    showAddAccessory();
                    break;
                case 0:
                    System.out.println("Thoát chương trình thêm loại sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);
    }

    private void showAddFurniture() {
        System.out.println("=====Thêm loại đồ nội thất=====");
        System.out.print("Nhập loại đồ nội thất: ");
        String name = Input.inputString();
        CFurniture a = new CFurniture(name);
        categoryManager.add(a);
        System.out.println("Thêm loại đồ nội thất thành công!");
    }

    private void showAddElectronic() {
        System.out.println("=====Thêm loại đồ công nghệ=====");
        System.out.print("Nhập loại đồ công nghệ: ");
        String name = Input.inputString();
        CElectronic a = new CElectronic(name);
        categoryManager.add(a);
        System.out.println("Thêm loại đồ công nghệ thành công!");
    }

    private void showAddDeviceVisual() {
        System.out.println("=====Thêm loại thiết bị hình ảnh=====");
        System.out.print("Nhập loại thiết bị hình ảnh: ");
        String name = Input.inputString();
        CDeviceVisual a = new CDeviceVisual(name);
        categoryManager.add(a);
        System.out.println("Thêm loại thiết bị hình ảnh thành công!");
    }

    private void showAddAccessory() {
        System.out.println("=====Thêm loại đồ phụ kiện=====");
        System.out.print("Nhập loại đồ phụ kiện: ");
        String name = Input.inputString();
        CAccessory a = new CAccessory(name);
        categoryManager.add(a);
        System.out.println("Thêm loại đồ phụ kiện thành công!");
    }
}
