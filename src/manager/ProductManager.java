package manager;

import model.product.*;
import readwritedata.ReadWriteProduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager implements IManager<Product>{
    List<Product> productList;
    ReadWriteProduct readWriteProduct = new ReadWriteProduct();

    public ProductManager(){
        this.productList = this.readWriteProduct.readAllProducts();
    }
    @Override
    public void add(Product product) {
        productList.add(product);
        readWriteProduct.writeProduct(product);
    }

    @Override
    public void update(int id, Product product) {
        int index = findIndexById(id);
        productList.set(index,product);
        readWriteProduct.writeAllProducts(productList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        productList.remove(index);
        readWriteProduct.writeAllProducts(productList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Product> getAll() {
        this.productList = readWriteProduct.readAllProducts();
        return this.productList;
    }

    public Product findProductById(int id){
        for (Product product : productList){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Furniture> getFurniture() {
        return readWriteProduct.readFurniture();
    }

    public List<Electronic> getElectronic() {
        return readWriteProduct.readElectronic();
    }

    public List<DeviceVisual> getDeviceVisual() {
        return readWriteProduct.readDeviceVisual();
    }

    public List<Accessory> getAccessory() {
        return readWriteProduct.readAccessory();
    }

    public List<Product> getProductByCategory(int idCategory) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getIdCategory()==idCategory){
                list.add(productList.get(i));
            }
        }
        return list;
    }

    public List<Product> getProductByBrand(int id) {
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getIdBrand() == id){
                list.add(productList.get(i));
            }
        }
        return list;
    }

    public List<Product> getProductByRangePrice(double min, double max) {
        List<Product> list = new ArrayList<>();
        for (int i =0; i < productList.size(); i++){
            if (productList.get(i).getPrice()>=min && productList.get(i).getPrice()<=max){
                list.add(productList.get(i));
            }
        }
        return list;
    }

    public Product getMaxPriceProduct() {
        Product maxPriceProduct = productList.get(0);
        for (int i = 0; i < productList.size(); i++){
            if (productList.get(i).getPrice()>maxPriceProduct.getPrice()){
                maxPriceProduct = productList.get(i);
            }
        }
        return maxPriceProduct;
    }

    public List<Product> getSortProductByPrice() {
        List<Product> list = getAll();
        list.sort((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
        return list;
    }
}
