package view.category;

import input.Input;
import manager.CategoryManager;
import model.category.*;

import java.util.List;

public class MenuShowCategory {

    CategoryManager categoryManager = new CategoryManager();

    public void showMenuListCategory(){
        int choice;
        do {
            System.out.println("=====Hiển thị danh sách loại sản phẩm=====");
            System.out.println("1. Danh sách tất cả loại sản phẩm");
            System.out.println("2. Danh sách loại đồ nội thất");
            System.out.println("3. Danh sách loại đồ công nghệ");
            System.out.println("4. Danh sách loại thiết bị hình ảnh");
            System.out.println("5. Danh sách loại đồ phụ kiện");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice){
                case 1:
                    showAllCategory();
                    break;
                case 2:
                    showCategoryFurniture();
                    break;
                case 3:
                    showCategoryElectronic();
                    break;
                case 4:
                    showCategoryDeviceVisual();
                    break;
                case 5:
                    showCategoryAccessory();
                    break;
                case 0:
                    System.out.println("Thoát chương trình hiển thị danh sách loại sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);
    }

    private void showAllCategory(){
        System.out.println("=====Hiển thị tất cả loại sản phẩm=====");
        List<Category> list = categoryManager.getAll();
        for (Category category : list){
            System.out.println(category);
        }
    }

    private void showCategoryAccessory() {
        System.out.println("=====Danh sách đồ phụ kiện=====");
        List<CAccessory> list = categoryManager.getCategoryAccessory();
        for (CAccessory a : list) {
            System.out.println(a);
        }
    }

    private void showCategoryDeviceVisual() {
        List<CDeviceVisual> list = categoryManager.getCategoryDeviceVisual();
        for (CDeviceVisual a : list){
            System.out.println(a);
        }
    }

    private void showCategoryElectronic() {
        List<CElectronic> list = categoryManager.getCategoryElectronic();
        for (CElectronic a : list) {
            System.out.println(a);
        }
    }

    private void showCategoryFurniture() {
        List<CFurniture> list = categoryManager.getCategoryFurniture();
        for (CFurniture a : list) {
            System.out.println(a);
        }
    }
}
