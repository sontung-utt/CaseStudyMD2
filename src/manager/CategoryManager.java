package manager;

import model.category.*;
import readwritedata.ReadWriteCategory;

import java.beans.XMLDecoder;
import java.util.ArrayList;
import java.util.List;

public class CategoryManager implements IManager<Category>{

    List<Category> categoryList;
    ReadWriteCategory readWriteCategory = new ReadWriteCategory();

    public CategoryManager() {
        this.categoryList = this.readWriteCategory.readCategory();
    }
    @Override
    public void add(Category category) {
        categoryList.add(category);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public void update(int id, Category category) {
        int index = findIndexById(id);
        categoryList.set(index, category);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        categoryList.remove(index);
        readWriteCategory.writeCategory(categoryList);
    }

    @Override
    public int findIndexById(int id) {
        this.categoryList = this.readWriteCategory.readCategory();
        for (int i = 0; i < categoryList.size(); i++) {
            if (categoryList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Category> getAll() {
        this.categoryList = readWriteCategory.readCategory();
        return this.categoryList;
    }

    public List<CFurniture> getCategoryFurniture(){
        this.categoryList = this.readWriteCategory.readCategory();
        List<CFurniture> list = new ArrayList<>();
        for (Category category : categoryList){
            if (category instanceof CFurniture){
                list.add((CFurniture) category);
            }
        }
        return list;
    }

    public List<CElectronic> getCategoryElectronic(){
        List<CElectronic> list = new ArrayList<>();
        for (Category category : categoryList){
            if (category instanceof CElectronic){
                list.add((CElectronic) category);
            }
        }
        return list;
    }

    public List<CDeviceVisual> getCategoryDeviceVisual(){
        List<CDeviceVisual> list = new ArrayList<>();
        for (Category category : categoryList){
            if (category instanceof CDeviceVisual){
                list.add((CDeviceVisual) category);
            }
        }
        return list;
    }

    public List<CAccessory> getCategoryAccessory(){
        List<CAccessory> list = new ArrayList<>();
        for (Category category : categoryList){
            if (category instanceof CAccessory){
                list.add((CAccessory) category);
            }
        }
        return list;
    }

    private <T extends Category> int findIndexByList (List<T> list, int id){
        for (int i = 0; i <list.size(); i++) {
            if (list.get(i).getId()==id){
                return i;
            }
        }
        return -1;
    }

    public Category findCategoryById(int id){
        this.categoryList = this.readWriteCategory.readCategory();
        for (Category category : categoryList){
            if (category.getId() == id){
                return category;
            }
        }
        return null;
    }

    public int getIdFurniture(int index) {
        List<CFurniture> list = getCategoryFurniture();
        CFurniture a = list.get(index);
        return a.getId();
    }

    public int getIdElectronic(int index) {
        List<CElectronic> list = getCategoryElectronic();
        CElectronic a = list.get(index);
        return a.getId();
    }

    public int getIdAccessory(int index) {
        List<CAccessory> list = getCategoryAccessory();
        CAccessory a = list.get(index);
        return a.getId();
    }

    public int getIdDeviceVisual(int index) {
        List<CDeviceVisual> list = getCategoryDeviceVisual();
        CDeviceVisual a = list.get(index);
        return a.getId();
    }

}
