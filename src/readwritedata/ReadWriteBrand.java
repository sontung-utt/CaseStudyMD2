package readwritedata;

import model.brand.Brand;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteBrand {
    File file = new File("data/brand/brand.csv");
    public void writeBrand(List<Brand> brandList) {
        String data = "";
        for (Brand brand : brandList) {
            data += brand.getId() + "," + brand.getName() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Brand> readBrand() {
        List<Brand> brandList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data = line.split(",");
                Brand brand = new Brand(Integer.parseInt(data[0]), data[1]);
                brandList.add(brand);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return brandList;
    }
}
