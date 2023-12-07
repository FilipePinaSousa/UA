package Campismo;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.*;

public class CampingService implements CampingServiceInterface {



    

    public void addCampingSpace(List<CampingSpace> asList) {
        addCampingSpace(asList);
    }
    

    @Override
    public boolean registerClient(int taxId, String name, ClientType normal) {
    
        return Client.registerClient(taxId, name, normal);}

    @Override
    public Client getClient(int taxId) {
        return Client.getClient(taxId);
    }

    @Override
    public void addCampingSpaces(Collection<CampingSpace> campingSpaces) {
       addCampingSpaces(campingSpaces);
    }

    @Override
    public boolean checkAvailable(CampingSpace campingSpace, LocalDate startDate, LocalDate endDate) {
        if (campingSpace == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    @Override
    public List<CampingSpace> findAvailableCampingSpaces(SpaceType spaceType, LocalDate fromDate, int duration,
            int[] minDimensions) {
                CampingSpace[] campingSpaces;
                for (CampingSpace campingSpace : campingSpaces) {
                    if (campingSpace.getSpaceType() == spaceType && campingSpace.getDimensões()[0] >= minDimensions[0]
                            && campingSpace.getDimensões()[1] >= minDimensions[1]) {
                        List<CampingSpace> availableSpaces;
                        availableSpaces.add(campingSpace);
                    }
                }
        
    }

    @Override
    public boolean bookCampingSpace(Client client, CampingSpace campingSpace, LocalDate startDate, int duration) {
       return Booking.bookCampingSpace(client, campingSpace, startDate, duration);
    }

    @Override
    public double calculateTotalCost(CampingSpace campingSpace, int duration) {
       for (CampingSpace campingSpace : campingSpaces) {
            return campingSpace.getPreçopordia() * duration;
    }

    public List<String> listBookings() {
        while(Bookings.listBookings() != null){
            return Bookings.listBookings();
        }
    }

    
    public Iterable<CampingSpace> getAvailableSpacesByTotalArea(LocalDate of, int i) {
        CampingSpace[] campingSpaces;
        for (CampingSpace campingSpace : campingSpaces) {
            if (campingSpace.getDimensões()[0] * campingSpace.getDimensões()[1] >= i) {
                List<CampingSpace> availableSpaces;
                availableSpaces.add(campingSpace);
            }
        }
    }
    @Override

    public void registerClient(int taxId, String name, ClientType member) {
        return Client.registerClient(taxId, name, member);
    }

    public void getficheiro(){
        try{
            File file = new File("Bookings.txt");
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();

        
            
        } catch (Exception e) {
            
        }

    }
    
        public void readBookings(File ) throws IOException {
        Scanner reader = new Scanner(new FileReader(filename));
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] parts = line.split("\\|");
            String id = parts[0];
            LocalDate date = LocalDate.parse(parts[1]);
            LocalDate rentalduration = LocalDate.parse(parts[2]);
            Int RentalState= (parts[4]);
            String dimenstions = (parts[5])
        }
        reader.close();
    }

    }
    public Iterable<CampingSpace> getAvailableSpacesByTotalArea(LocalDate of, int i) {
        CampingSpace[] campingSpaces;
        for (CampingSpace campingSpace : campingSpaces) {
            SortedMap<CampingSpace, Integer> availableSpaces;
            if (campingSpace.getDimensões()[0] * campingSpace.getDimensões()[1] >= i) {
                availableSpaces.put(campingSpace, campingSpace.getDimensões()[0] * campingSpace.getDimensões()[1]);
            } 
            
            
           
        }
    }
    

   

    
}


