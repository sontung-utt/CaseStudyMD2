package readwritedata;

import model.category.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCategory {
    File file = new File("data/category/category.csv");

    public void writeCategory(List<Category> categoryList){
        String data = "";
        for (Category category : categoryList) {
            String type = "";
            if (category instanceof CFurniture) type = "CFurniture";
            else if (category instanceof CElectronic) type = "CElectronic";
            else if (category instanceof CDeviceVisual) type = "CDeviceVisual";
            else if (category instanceof CAccessory) type = "CAccessory";
            data += type + "," + category.getId() + "," + category.getName() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Category> readCategory() {
        List<Category> categoryList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                String type = data[0];
                int id = Integer.parseInt(data[1]);
                String name = data[2];

                Category category = null;
                switch (type) {
                    case "CFurniture":
                        category = new CFurniture(id, name);
                        break;
                    case "CElectronic":
                        category = new CElectronic(id, name);
                        break;
                    case "CDeviceVisual":
                        category = new CDeviceVisual(id, name);
                        break;
                    case "CAccessory":
                        category = new CAccessory(id, name);
                        break;
                    default:
                        System.out.println("Loại sản phẩm không hợp lệ: " + type);
                        continue;
                }
                categoryList.add(category);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return categoryList;
    }
}
