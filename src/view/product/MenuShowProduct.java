package view.product;

import input.Input;
import manager.BrandManager;
import manager.CategoryManager;
import manager.ProductManager;
import model.brand.Brand;
import model.category.Category;
import model.product.*;

import java.util.List;

public class MenuShowProduct {
    ProductManager productManager = new ProductManager();
    BrandManager brandManager = new BrandManager();
    CategoryManager categoryManager = new CategoryManager();
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
            Category category = categoryManager.findCategoryById(product.getIdCategory());
            Brand brand = brandManager.findBrandById(product.getIdBrand());
            System.out.println(product + "\nLoại sản phẩm: " + category.getName() + "\nThương hiệu: " + brand.getName());
        }
    }

    private void showProductFurniture() {
        System.out.println("=====Danh sách đồ nội thất=====");
        List<Furniture> list = productManager.getFurniture();
        for (Furniture furniture : list) {
            Brand brand = brandManager.findBrandById(furniture.getIdBrand());
            Category category = categoryManager.findCategoryById(furniture.getIdCategory());
            System.out.println(furniture + "\nLoại sản phẩm: " + category.getName() + "\nThương hiệu: " + brand.getName());
        }
    }

    private void showProductElectronic() {
        System.out.println("=====Danh sách đồ công nghệ=====");
        List<Electronic> list = productManager.getElectronic();
        for (Electronic electronic : list) {
            Brand brand = brandManager.findBrandById(electronic.getIdBrand());
            Category category = categoryManager.findCategoryById(electronic.getIdCategory());
            System.out.println(electronic + "\nLoại sản phẩm: " + category.getName() + "\nThương hiệu: " + brand.getName());
        }
    }

    private void showProductDeviceVisual() {
        System.out.println("=====Danh sách thiết bị hình ảnh=====");
        List<DeviceVisual> list = productManager.getDeviceVisual();
        for (DeviceVisual deviceVisual : list) {
            Brand brand = brandManager.findBrandById(deviceVisual.getIdBrand());
            Category category = categoryManager.findCategoryById(deviceVisual.getIdCategory());
            System.out.println(deviceVisual + "\nLoại sản phẩm: " + category.getName() + "\nThương hiệu: " + brand.getName());
        }
    }

    private void showProductAccessory() {
        System.out.println("=====Danh sách đồ phụ kiện=====");
        List<Accessory> list = productManager.getAccessory();
        for (Accessory accessory : list) {
            Brand brand = brandManager.findBrandById(accessory.getIdBrand());
            Category category = categoryManager.findCategoryById(accessory.getIdCategory());
            System.out.println(accessory + "\nLoại sản phẩm: " + category.getName() + "\nThương hiệu: " + brand.getName());
        }
    }
}
