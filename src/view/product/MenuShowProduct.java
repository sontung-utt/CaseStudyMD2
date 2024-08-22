package view.product;

import input.Input;
import manager.ProductManager;
import model.product.*;

import java.util.List;

public class MenuShowProduct {
    ProductManager productManager = new ProductManager();
    public void showMenuListProduct(){
        int choice;
        do {
            System.out.println("=====Hiển thị danh sách sản phẩm=====");
            System.out.println("1. Danh sách tất cả sản phẩm");
            System.out.println("2. Danh sách đồ nội thất");
            System.out.println("3. Danh sách đồ công nghệ");
            System.out.println("4. Danh sách thiết bị hình ảnh");
            System.out.println("5. Danh sách đồ phụ kiện");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch(choice){
                case 1:
                    showAllProduct();
                    break;
                case 2:
                    showProductFurniture();
                    break;
                case 3:
                    showProductElectronic();
                    break;
                case 4:
                    showProductDeviceVisual();
                    break;
                case 5:
                    showProductAccessory();
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

    private void showAllProduct() {
        System.out.println("=====Danh sách tất cả sản phẩm=====");
        List<Product> list = productManager.getAll();
        for (Product product : list) {
            System.out.println(product);
        }
    }

    private void showProductFurniture() {
        System.out.println("=====Danh sách đồ nội thất=====");
        List<Furniture> list = productManager.getFurniture();
        for (Furniture furniture : list) {
            System.out.println(furniture);
        }
    }

    private void showProductElectronic() {
        System.out.println("=====Danh sách đồ công nghệ=====");
        List<Electronic> list = productManager.getElectronic();
        for (Electronic electronic : list) {
            System.out.println(electronic);
        }
    }

    private void showProductDeviceVisual() {
        System.out.println("=====Danh sách thiết bị hình ảnh=====");
        List<DeviceVisual> list = productManager.getDeviceVisual();
        for (DeviceVisual deviceVisual : list) {
            System.out.println(deviceVisual);
        }
    }

    private void showProductAccessory() {
        System.out.println("=====Danh sách đồ phụ kiện=====");
        List<Accessory> list = productManager.getAccessory();
        for (Accessory accessory : list) {
            System.out.println(accessory);
        }
    }
}
