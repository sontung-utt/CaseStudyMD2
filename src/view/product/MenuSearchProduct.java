package view.product;

import input.Input;
import manager.BrandManager;
import manager.CategoryManager;
import manager.ProductManager;
import model.brand.Brand;
import model.category.CAccessory;
import model.category.CDeviceVisual;
import model.category.CElectronic;
import model.category.CFurniture;
import model.product.Product;

import java.util.List;

public class MenuSearchProduct {
    ProductManager productManager = new ProductManager();
    CategoryManager categoryManager = new CategoryManager();
    BrandManager brandManager = new BrandManager();

    public void showMenuSearchProduct() {
        int choice;
        do {
            System.out.println("=====Tìm kiếm sản phẩm=====");
            System.out.println("1. Tìm kiếm sản phẩm theo loại sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm theo tên thương hiệu");
            System.out.println("3. Tìm kiếm sản phẩm theo khoảng giá");
            System.out.println("4. Tìm kiếm sản phẩm có giá cao nhất");
            System.out.println("5. Sắp xếp sản phẩm theo giá");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice){
                case 1:
                    searchProductByCategory();
                    break;
                case 2:
                    searchProductByBrand();
                    break;
                case 3:
                    searchProductByRangePrice();
                    break;
                case 4:
                    searchMaxPriceProduct();
                    break;
                case 5:
                    sortProductByPrice();
                    break;
                case 0:
                    System.out.println("Thoát chương trình tìm kiếm sản phẩm!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice!=0);

    }

    private void searchProductByCategory() {
        System.out.println("=====Tìm kiếm theo loại sản phẩm=====");
        System.out.println("1. Đồ nội thất");
        System.out.println("2. Đồ công nghệ");
        System.out.println("3. Thiết bị âm thanh");
        System.out.println("4. Đồ phụ kiện");
        System.out.print("Nhập lựa chọn: ");
        int choice = Input.inputInteger();
        switch (choice) {
            case 1:
                List<CFurniture> furnitures = categoryManager.getCategoryFurniture();
                System.out.println("Danh sách đồ nội thất");
                for (int i = 0; i < furnitures.size(); i++){
                    System.out.println((i + 1) + ". " + furnitures.get(i).getName());
                }
                int indexFurniture, idFurniture;
                do {
                    System.out.print("Chọn đồ nội thất muốn tìm kiếm: ");
                    int choose = Input.inputInteger();
                    indexFurniture = choose - 1;
                    if (indexFurniture >= furnitures.size() || indexFurniture <0) {
                        System.out.println("Không có lựa chọn phù hợp!");
                    }
                } while (indexFurniture >= furnitures.size() || indexFurniture <0);
                idFurniture = categoryManager.getIdFurniture(indexFurniture);
                List<Product> products1 = productManager.getProductByCategory(idFurniture);
                if (products1.isEmpty()){
                    System.out.println("Không có sản phẩm nào thuộc đồ nội thất là " + categoryManager.findCategoryById(idFurniture).getName());
                } else {
                    System.out.println("Dánh sách sản phẩm của " + categoryManager.findCategoryById(idFurniture).getName());
                    for (Product product : products1){
                        System.out.println(product);
                    }
                }
                break;
            case 2:
                List<CElectronic> electronics = categoryManager.getCategoryElectronic();
                System.out.println("Danh sách đồ công nghệ");
                for (int i = 0; i < electronics.size(); i++) {
                    System.out.println((i + 1) + ". " + electronics.get(i).getName());
                }
                int indexElectronic, idElectronic;
                do {
                    System.out.print("Chọn đồ công nghệ muốn tìm kiếm: ");
                    int choose = Input.inputInteger();
                    indexElectronic = choose - 1;
                    if (indexElectronic >= electronics.size() || indexElectronic < 0){
                        System.out.println("Không có lựa chọn phù hợp!");
                    }
                } while (indexElectronic >= electronics.size() || indexElectronic < 0);
                idElectronic = categoryManager.getIdElectronic(indexElectronic);
                List<Product> products2 = productManager.getProductByCategory(idElectronic);
                if (products2.isEmpty()){
                    System.out.println("Không có sản phẩm nào thuộc đồ công nghệ là " + categoryManager.findCategoryById(idElectronic).getName());
                } else {
                    System.out.println("Danh sách sản phẩm của " + categoryManager.findCategoryById(idElectronic).getName());
                    for (Product product : products2) {
                        System.out.println(product);
                    }
                }
                break;
            case 3:
                List<CDeviceVisual> deviceVisuals = categoryManager.getCategoryDeviceVisual();
                System.out.println("Danh sách thiết bị âm thanh");
                for (int i = 0; i < deviceVisuals.size(); i++) {
                    System.out.println((i + 1) + ". " + deviceVisuals.get(i).getName());
                }
                int indexDevice, idDevice;
                do {
                    System.out.print("Chọn thiết bị âm thanh muốn tìm kiếm: ");
                    int choose = Input.inputInteger();
                    indexDevice = choose - 1;
                    if (indexDevice >= deviceVisuals.size() || indexDevice < 0) {
                        System.out.println("Không có lựa chọn phù hợp!");
                    }
                } while (indexDevice >= deviceVisuals.size() || indexDevice < 0);
                idDevice = categoryManager.getIdDeviceVisual(indexDevice);
                List<Product> products3 = productManager.getProductByCategory(idDevice);
                if (products3.isEmpty()){
                    System.out.println("Không có sản phẩm nào thuộc đồ công nghệ là " + categoryManager.findCategoryById(idDevice).getName());
                } else {
                    System.out.println("Danh sách sản phẩm của " + categoryManager.findCategoryById(idDevice).getName());
                    for (Product product : products3){
                        System.out.println(product);
                    }
                }
                break;
            case 4:
                List<CAccessory> accessories = categoryManager.getCategoryAccessory();
                System.out.println("Danh sách đồ phụ kiện");
                for (int i = 0; i < accessories.size(); i++) {
                    System.out.println((i + 1) + ". " + accessories.get(i).getName());
                }
                int idAccessory, indexAccessory;
                do {
                    System.out.println("Chọn đồ phụ kiện muốn tìm kiếm: ");
                    int choose = Input.inputInteger();
                    indexAccessory = choose - 1;
                    if (indexAccessory >= accessories.size() || indexAccessory < 0){
                        System.out.println("Không có lựa chọn phù hợp!");
                    }
                } while (indexAccessory >= accessories.size() || indexAccessory < 0);
                idAccessory = categoryManager.getIdAccessory(indexAccessory);
                List<Product> products4 = productManager.getProductByCategory(idAccessory);
                if (products4.isEmpty()){
                    System.out.println("Không có sản phẩm nào thuộc đồ công nghệ là " + categoryManager.findCategoryById(idAccessory).getName());
                } else {
                    System.out.println("Danh sách sản phẩm của " + categoryManager.findCategoryById(idAccessory).getName());
                    for (Product product : products4){
                        System.out.println(product);
                    }
                }
                break;
            default:
                System.out.println("Không có lựa chọn phù hợp!");
                break;
        }
    }

    private void searchProductByBrand() {
        System.out.println("=====Tìm kiếm sản pẩm theo tên thương hiệu=====");
        List<Brand> list = brandManager.getAll();
        System.out.println("Danh sách thương hiệu");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int index, id;
        do {
            System.out.print("Chọn thương hiệu muốn tìm kiếm: ");
            int choose = Input.inputInteger();
            index = choose - 1;
            if (index >= list.size() || index < 0) {
                System.out.println("Không có lựa chọn phù hợp!");
            }
        } while (index >= list.size() || index < 0);
        id = brandManager.getIdBrand(index);
        List<Product> products = productManager.getProductByBrand(id);
        if (products.isEmpty()){
            System.out.println("Không có sản phẩm có thương hiệu là " + brandManager.findBrandById(id).getName());
        } else {
            System.out.println("Danh sách sản phẩm thương hiệu " + brandManager.findBrandById(id).getName());
            for (Product product : products){
                System.out.println(product);
            }
        }
    }

    private void searchProductByRangePrice() {
        System.out.println("=====Tìm kiếm sản phẩm theo khoảng giá=====");
        double min, max;
        do {
            do {
                System.out.print("Nhập số tiền nhỏ nhất: ");
                min = Input.inputDouble();
                if (min < 0) {
                    System.out.println("Số tiền không hợp lệ! Yêu cầu nhập lại");
                }
            } while (min < 0);
            do {
                System.out.print("Nhập số tiền lớn nhất: ");
                max = Input.inputDouble();
                if (max < 0) {
                    System.out.println("Số tiền không hợp lệ! Yêu cầu nhập lại");
                }
            } while (max < 0);
            if (min >= max) {
                System.out.println("Nhập không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (min >= max);
        List<Product> list = productManager.getProductByRangePrice(min, max);
        if (list.isEmpty()){
            System.out.println("Không có sản phẩm nào có khoảng giá từ " + min + " đến " + max + "!");
        } else {
            System.out.println("Danh sách sản phẩm có khoảng giá từ " + min + " đến " + max);
            for (Product product : list) {
                System.out.println(product);
            }
        }
    }

    private void searchMaxPriceProduct() {
        System.out.println("=====Tìm kiếm sản phẩm có giá cao nhất=====");
        System.out.println(productManager.getMaxPriceProduct());
    }

    private void sortProductByPrice() {
        List<Product> products = productManager.getSortProductByPrice();
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
