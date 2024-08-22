package readwritedata;

import model.product.*;

import java.io.*;
import java.nio.Buffer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteProduct {
    File fileAccessory = new File("data/product/accessory.csv");
    File fileDeviceVisual = new File("data/product/devicevisual.csv");
    File fileElectronic = new File("data/product/electronic.csv");
    File fileFurniture = new File("data/product/furniture.csv");
    File fileProduct = new File("data/product/product.csv");

    public void writeProduct(Product product) {
        // Determine the product type and call the respective method to save the product
        if (product instanceof Accessory) {
            writeAccessory((Accessory) product);
        } else if (product instanceof DeviceVisual) {
            writeDeviceVisual((DeviceVisual) product);
        } else if (product instanceof Electronic) {
            writeElectronic((Electronic) product);
        } else if (product instanceof Furniture) {
            writeFurniture((Furniture) product);
        }
    }


    public void writeAllProducts(List<Product> productList) {
        // Clear and rewrite all products to their respective files
        clearAllFiles();
        for (Product product : productList) {
            writeProduct(product);
        }
    }

    private void clearAllFiles() {
        try {
            new FileWriter(fileAccessory, false).close();
            new FileWriter(fileDeviceVisual, false).close();
            new FileWriter(fileElectronic, false).close();
            new FileWriter(fileFurniture, false).close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Product> readAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.addAll(readAccessory());
        productList.addAll(readDeviceVisual());
        productList.addAll(readElectronic());
        productList.addAll(readFurniture());
        return productList;
    }

    public void writeAccessory(Accessory accessory) {
        String data = "";
        data += accessory.getId() + "," + accessory.getName() + "," + accessory.getPrice() + "," + accessory.getQuantity() + "," +
                accessory.getPurchaseDate() + "," + accessory.getWarranty() + "," + accessory.getDescription() + "," +
                accessory.getIdCategory() + "," + accessory.getIdBrand() + "," + accessory.getColor() + "," + accessory.getMaterial() + "\n";
        try {
            FileWriter fileWriter = new FileWriter(fileAccessory, true);
            BufferedWriter bufferedWriter = new BufferedWriter((fileWriter));
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Accessory> readAccessory() {
        List<Accessory> accessoryList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileAccessory);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Accessory accessory = new Accessory(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), LocalDate.parse(data[4]), Integer.parseInt(data[5]), data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]), data[9], data[10]);
                accessoryList.add(accessory);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return accessoryList;
    }

    public void writeDeviceVisual(DeviceVisual deviceVisual) {
        String data = "";
        data += deviceVisual.getId() + "," + deviceVisual.getName() + "," + deviceVisual.getPrice() + "," + deviceVisual.getQuantity() + "," +
                deviceVisual.getPurchaseDate() + "," + deviceVisual.getWarranty() + "," + deviceVisual.getDescription() + "," +
                deviceVisual.getIdCategory() + "," + deviceVisual.getIdBrand() + "," + deviceVisual.getResolution() + "\n";
        try {
            FileWriter fileWriter = new FileWriter(fileDeviceVisual, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<DeviceVisual> readDeviceVisual() {
        List<DeviceVisual> deviceVisualList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileDeviceVisual);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                DeviceVisual deviceVisual = new DeviceVisual(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), LocalDate.parse(data[4]), Integer.parseInt(data[5]), data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]), data[9]);
                deviceVisualList.add(deviceVisual);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return deviceVisualList;
    }

    public void writeElectronic(Electronic electronic) {
        String data = "";

        data += electronic.getId() + "," + electronic.getName() + "," + electronic.getPrice() + "," + electronic.getQuantity() + "," +
                electronic.getPurchaseDate() + "," + electronic.getWarranty() + "," + electronic.getDescription() + "," +
                electronic.getIdCategory() + "," + electronic.getIdBrand() + "," + electronic.getMemory() + "," + electronic.getStorage() + "," +
                electronic.getConfiguration() + "\n";
        try {
            FileWriter fileWriter = new FileWriter(fileElectronic, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Electronic> readElectronic() {
        List<Electronic> electronicList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileElectronic);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Electronic electronic = new Electronic(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), LocalDate.parse(data[4]), Integer.parseInt(data[5]), data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]), data[11]);
                electronicList.add(electronic);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return electronicList;
    }

    public void writeFurniture(Furniture furniture) {
        String data = "";

        data += furniture.getId() + "," + furniture.getName() + "," + furniture.getPrice() + "," + furniture.getQuantity() + "," +
                furniture.getPurchaseDate() + "," + furniture.getWarranty() + "," + furniture.getDescription() + "," +
                furniture.getIdCategory() + "," + furniture.getIdBrand() + "," + furniture.getConsumption() + "," + furniture.getVolume() + "," +
                furniture.getCapacity() + "\n";

        try {
            FileWriter fileWriter = new FileWriter(fileFurniture, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Furniture> readFurniture() {
        List<Furniture> furnitureList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileFurniture);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                Furniture furniture = new Furniture(Integer.parseInt(data[0]), data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), LocalDate.parse(data[4]), Integer.parseInt(data[5]), data[6], Integer.parseInt(data[7]), Integer.parseInt(data[8]), Double.parseDouble(data[9]), Double.parseDouble(data[10]), Double.parseDouble(data[11]));
                furnitureList.add(furniture);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return furnitureList;
    }
}
