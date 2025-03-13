import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

// Class to gather and store vehicle data
class VehicleData{
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What is the year of your vehicle?");
        String year = scan.next();
        
        System.out.println("The make of the vehicle?");
        String make = scan.next();
        
        System.out.println("The Model?");
        String model = scan.next();
        
        System.out.println("What is the mileage of the car?");
        String mileage = scan.next();
        
        System.out.println("When was the oil changed? (Please enter in YYYY-MM-DD format)");
        String oilChangeDate = scan.next();
        
        System.out.println("Has the coolant reservoir level been inspected? (yes/no)");
        String coolantInspection = scan.next();
        
        System.out.println("Have the tires been inspected? (yes/no)");
        String tireInspection = scan.next();

        String formattedData = formatData(year, make, model, mileage, oilChangeDate, coolantInspection, tireInspection);

        System.out.println("Formatted Vehicle Data:\n" + formattedData);

        writeToFile(formattedData);

        scan.close();
    }
    
    //Method that formats the Vehicles Data 
    public static String formatData(String year, String make, String model, String mileage, String oilChangeDate, String coolantInspection, String tireInspection) {
        LocalDate currentDate = LocalDate.now();
        return "Date: " + currentDate + "\n" +
               "Year: " + year + "\n" +
               "Make: " + make + "\n" +
               "Model: " + model + "\n" +
               "Mileage: " + mileage + "\n" +
               "Oil Change Date: " + oilChangeDate + "\n" +
               "Coolant Reservoir Inspected: " + coolantInspection + "\n" +
               "Tires Inspected: " + tireInspection + "\n";
    }
    //Method that writes the Data to a file
    public static void writeToFile(String vehicleData){
        String path = "info.txt";
        try(FileWriter file = new FileWriter(path)){
            file.write(vehicleData);
            System.out.println("The data has sucessfully been written to the file!");
        }
        catch(IOException e){
            System.out.println("An error occured trying to write the data" + e.getMessage());
            
        }
    }

}
