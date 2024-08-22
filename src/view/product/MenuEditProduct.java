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
import model.product.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class MenuEditProduct {
    ProductManager productManager = new ProductManager();
    CategoryManager categoryManager = new CategoryManager();
    BrandManager brandManager = new BrandManager();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void showMenuEditProduct() {
        System.out.println("=====Sửa thông tin sản phẩm=====");
        System.out.println("Danh sách sản phẩm");
        List<Product> productList = productManager.getAll();
        for (Product product : productList){
            System.out.println(product);
        }
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int idEdit = Input.inputInteger();
        Product oldProduct = productManager.findProductById(idEdit);
        if (oldProduct != null){
            System.out.println("===Thông tin sản phẩm hiện tại===\n" + oldProduct);
            if (oldProduct instanceof Furniture){
                System.out.println("=====Sửa thông tin sản phẩm nội thất=====");
                System.out.println("Danh sách đồ nội thất");
                List<CFurniture> list = categoryManager.getCategoryFurniture();
                for (int i = 0; i < list.size(); i++){
                    System.out.println((i + 1) + ". " + list.get(i).getName());
                }
                int index, idFurniture;
                do {
                    System.out.print("Chọn loại đồ nội thất: ");
                    int choice = Input.inputInteger();
                    index = choice - 1;
                    if (index >= list.size()  ||index<0) {
                        System.out.println("Đồ nội thất không tồn tại! Yêu cầu nhập lại.");
                    }
                } while (index >= list.size() || index<0);
                idFurniture = categoryManager.getIdFurniture(index);
                System.out.print("Nhập tên sản phẩm: ");
                String name = Input.inputString();
                System.out.println("Danh sách thương hiệu");
                List<Brand> listBrand = brandManager.getAll();
                for (int i = 0; i < listBrand.size(); i++) {
                    System.out.println((i + 1) + ". " + listBrand.get(i).getName());
                }
                int indexBrand, idBrand;
                do {
                    System.out.print("Nhập mã thương hiệu: ");
                    int choice = Input.inputInteger();
                    indexBrand = choice - 1;
                    if(indexBrand >= listBrand.size()||indexBrand < 0) {
                        System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
                    }
                } while (indexBrand >= listBrand.size()||indexBrand < 0);
                idBrand = brandManager.getIdBrand(indexBrand);
                System.out.print("Nhập giá tiền: ");
                double price = Input.inputDouble();
                System.out.print("Nhập số lượng: ");
                int quantity = Input.inputInteger();
                LocalDate purchaseDate = null;
                while (purchaseDate == null){
                    System.out.print("Nhập ngày mua hàng: ");
                    String date = Input.inputString();
                    try{
                        purchaseDate = LocalDate.parse(date, formatter);
                    } catch (DateTimeParseException e){
                        System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
                    }
                }
                System.out.print("Nhập thời gian bảo hành: ");
                int warranty = Input.inputInteger();
                System.out.print("Nhập mô tả sản phẩm: ");
                String description = Input.inputString();
                System.out.print("Nhập công suất tiêu thụ: ");
                double consumption = Input.inputDouble();
                System.out.print("Nhập khối lượng: ");
                double volume = Input.inputDouble();
                System.out.print("Nhập dung tích: ");
                double capacity = Input.inputDouble();
                Furniture furniture = new Furniture(idEdit,name,price,quantity,purchaseDate,warranty,description,idFurniture,idBrand,consumption,volume,capacity);
                productManager.update(idEdit,furniture);
                System.out.println("Sửa thông tin sản phẩm nội thất thành công!");
            }
            if (oldProduct instanceof Electronic){
                System.out.println("=====Sửa thông tin sản phẩm công nghệ=====");
                System.out.println("Danh sách đồ công nghệ");
                List<CElectronic> list = categoryManager.getCategoryElectronic();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName());
                }
                int index, idElectronic;
                do {
                    System.out.print("Chọn loại đồ công nghệ: ");
                    int choice = Input.inputInteger();
                    index = choice - 1;
                    if (index >= list.size()|| index < 0) {
                        System.out.println("Đồ công nghệ không tồn tại! Yêu cầu nhập lại.");
                    }
                } while (index >= list.size() || index < 0);
                idElectronic = categoryManager.getIdElectronic(index);
                System.out.print("Nhập tên sản phẩm: ");
                String name = Input.inputString();
                System.out.println("Danh sách thương hiệu");
                List<Brand> listBrand = brandManager.getAll();
                for (int i = 0; i < listBrand.size(); i++) {
                    System.out.println((i + 1) + ". " + listBrand.get(i).getName());
                }
                int indexBrand, idBrand;
                do {
                    System.out.print("Nhập mã thương hiệu: ");
                    int choice = Input.inputInteger();
                    indexBrand = choice - 1;
                    if(indexBrand >= listBrand.size()||indexBrand < 0) {
                        System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
                    }
                } while (indexBrand >= listBrand.size()||indexBrand < 0);
                idBrand = brandManager.getIdBrand(indexBrand);
                System.out.print("Nhập giá tiền: ");
                double price = Input.inputDouble();
                System.out.print("Nhập số lượng: ");
                int quantity = Input.inputInteger();
                LocalDate purchaseDate = null;
                while (purchaseDate == null){
                    System.out.print("Nhập ngày mua hàng: ");
                    String date = Input.inputString();
                    try{
                        purchaseDate = LocalDate.parse(date, formatter);
                    } catch (DateTimeParseException e){
                        System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
                    }
                }
                System.out.print("Nhập thời gian bảo hành: ");
                int warranty = Input.inputInteger();
                System.out.print("Nhập mô tả sản phẩm: ");
                String description = Input.inputString();
                System.out.print("Nhập bộ nhớ: ");
                double memory = Input.inputDouble();
                System.out.print("Nhập dung lượng: ");
                double storage = Input.inputDouble();
                System.out.print("Nhập cấu hình: ");
                String configuration = Input.inputString();
                Electronic electronic = new Electronic(idEdit,name,price,quantity,purchaseDate,warranty,description,idElectronic,idBrand,memory,storage,configuration);
                productManager.update(idEdit,electronic);
                System.out.println("Sửa thông tin sản phẩm công nghệ thành công!");
            }
            if (oldProduct instanceof DeviceVisual) {
                System.out.println("=====Sửa thông tin sản phẩm thiết bị hình ảnh=====");
                System.out.println("Danh sách thiết bị hình ảnh");
                List<CDeviceVisual> list = categoryManager.getCategoryDeviceVisual();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName());
                }
                int index, idDeviceVisual;
                do {
                    System.out.print("Chọn loại thiết bị hình ảnh: ");
                    int choice = Input.inputInteger();
                    index = choice - 1;
                    if (index >= list.size() || index < 0) {
                        System.out.println("Thiết bị hình ảnh không tồn tại! Yêu cầu nhập lại.");
                    }
                } while (index >= list.size() || index < 0);
                idDeviceVisual = categoryManager.getIdDeviceVisual(index);
                System.out.print("Nhập tên sản phẩm: ");
                String name = Input.inputString();
                System.out.println("Danh sách thương hiệu");
                List<Brand> listBrand = brandManager.getAll();
                for (int i = 0; i < listBrand.size(); i++) {
                    System.out.println((i + 1) + ". " + listBrand.get(i).getName());
                }
                int indexBrand, idBrand;
                do {
                    System.out.print("Nhập mã thương hiệu: ");
                    int choice = Input.inputInteger();
                    indexBrand = choice - 1;
                    if(indexBrand >= listBrand.size()||indexBrand < 0) {
                        System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
                    }
                } while (indexBrand >= listBrand.size()||indexBrand < 0);
                idBrand = brandManager.getIdBrand(indexBrand);
                System.out.print("Nhập giá tiền: ");
                double price = Input.inputDouble();
                System.out.print("Nhập số lượng: ");
                int quantity = Input.inputInteger();
                LocalDate purchaseDate = null;
                while (purchaseDate == null){
                    System.out.print("Nhập ngày mua hàng: ");
                    String date = Input.inputString();
                    try{
                        purchaseDate = LocalDate.parse(date, formatter);
                    } catch (DateTimeParseException e){
                        System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
                    }
                }
                System.out.print("Nhập thời gian bảo hành: ");
                int warranty = Input.inputInteger();
                System.out.print("Nhập mô tả sản phẩm: ");
                String description = Input.inputString();
                System.out.print("Nhập độ phân giải: ");
                String resolution = Input.inputString();
                DeviceVisual deviceVisual = new DeviceVisual(idEdit,name,price,quantity,purchaseDate,warranty,description,idDeviceVisual,idBrand,resolution);
                productManager.update(idEdit,deviceVisual);
                System.out.println("Sửa thông tin thiết bị hình ảnh thành công!");
            }
            if (oldProduct instanceof Accessory) {
                System.out.println("=====Sửa thông tin sản phẩm phụ kiện=====");
                System.out.println("Danh sách đồ phụ kiện");
                List<CAccessory> list = categoryManager.getCategoryAccessory();
                for (int i = 0; i < list.size(); i++) {
                    System.out.println((i + 1) + ". " + list.get(i).getName());
                }
                int idAccessory, index;
                do {
                    System.out.print("Chọn loại đồ phụ kiện: ");
                    int choice = Input.inputInteger();
                    index = choice - 1;
                } while (index >= list.size() || index < 0);
                idAccessory = categoryManager.getIdAccessory(index);
                System.out.print("Nhập tên sản phẩm: ");
                String name = Input.inputString();
                System.out.println("Danh sách thương hiệu");
                List<Brand> listBrand = brandManager.getAll();
                for (int i = 0; i < listBrand.size(); i++) {
                    System.out.println((i + 1) + ". " + listBrand.get(i).getName());
                }
                int indexBrand, idBrand;
                do {
                    System.out.print("Nhập mã thương hiệu: ");
                    int choice = Input.inputInteger();
                    indexBrand = choice - 1;
                    if(indexBrand >= listBrand.size()||indexBrand < 0) {
                        System.out.println("Không tồn tại thương hiệu! Yêu cầu nhập lại.");
                    }
                } while (indexBrand >= listBrand.size()||indexBrand < 0);
                idBrand = brandManager.getIdBrand(indexBrand);
                System.out.print("Nhập giá tiền: ");
                double price = Input.inputDouble();
                System.out.print("Nhập số lượng: ");
                int quantity = Input.inputInteger();
                LocalDate purchaseDate = null;
                while (purchaseDate == null){
                    System.out.print("Nhập ngày mua hàng: ");
                    String date = Input.inputString();
                    try{
                        purchaseDate = LocalDate.parse(date, formatter);
                    } catch (DateTimeParseException e){
                        System.out.println("Ngày không hợp lệ! Yêu cầu nhập lại ngày theo định dạng dd/MM/yyyy");
                    }
                }
                System.out.print("Nhập thời gian bảo hành: ");
                int warranty = Input.inputInteger();
                System.out.print("Nhập mô tả sản phẩm: ");
                String description = Input.inputString();
                System.out.print("Nhập màu sắc: ");
                String color = Input.inputString();
                System.out.print("Nhập chất liệu: ");
                String material = Input.inputString();
                Accessory accessory = new Accessory(idEdit,name,price,quantity,purchaseDate,warranty,description,idAccessory,idBrand,color,material);
                productManager.update(idEdit,accessory);
                System.out.println("Sửa thông tin sản phẩm phụ kiện thành công!");
            }
        } else {
            System.out.println("Không tìm thấy mã sản phẩm!");
        }
    }
}
