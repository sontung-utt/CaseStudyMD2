package manager;

import model.brand.Brand;
import readwritedata.ReadWriteBrand;

import java.util.Collections;
import java.util.List;

public class BrandManager implements IManager<Brand> {

    List<Brand> brandList;
    ReadWriteBrand readWriteBrand = new ReadWriteBrand();

    public BrandManager() {
        this.brandList = this.readWriteBrand.readBrand();
    }

    @Override
    public void add(Brand brand) {
        brandList.add(brand);
        readWriteBrand.writeBrand(brandList);
    }

    @Override
    public void update(int id, Brand brand) {
        int index = findIndexById(id);
        brandList.set(index, brand);
        readWriteBrand.writeBrand(brandList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        brandList.remove(index);
        readWriteBrand.writeBrand(brandList);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Brand> getAll() {
        this.brandList = readWriteBrand.readBrand();
        return this.brandList;
    }

    public Brand findBrandById(int id) {
        int index = findIndexById(id);
        return brandList.get(index);
    }

    public int getIdBrand(int index) {
        Brand brand = brandList.get(index);
        return brand.getId();
    }
}
