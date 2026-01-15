// Logistics Interface
interface Logistics {
    void send();
}

// Class implementing the Ligistics Interface
class Road implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by road Logistics");
    }
}

// Class implementing the Logistics Interface
class Air implements Logistics {
    @Override
    public void send() {
        System.out.println("Sending by air Logistics");
    }
}

// Factory Class taking care of Logistics
class LogisticsFactory{
    public static Logistics getLogistics(String mode) {
        if(mode.equalsIgnoreCase("Road")){
            return new Road();
        } else if(mode.equalsIgnoreCase("Air")){
            return new Air();
        }
        throw new IllegalArgumentException("Unknown logistics mode: " + mode);
    }
}

// Class implementing the Logistics Services
class LogisticsService {
    public void send(String mode) {
        /* Using the Logistics Factory to get the
        desired object based on the mode */
        Logistics logistics = LogisticsFactory.getLogistics(mode);
        logistics.send();
    }
}

// Driver Code
public class LogisticsWithFactory {
    public static void main(String[] args) {
        LogisticsService service = new LogisticsService();
        service.send("Air");
        service.send("Road");
    }
}
