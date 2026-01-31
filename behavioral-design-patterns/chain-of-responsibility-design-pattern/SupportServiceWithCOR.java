// Abstract class defining the SupportHandler
abstract class SupportHandler {
    protected SupportHandler nextHandler;

    // Method to set the next handler in the chain
    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    // Abstract method to handle the request
    public abstract void handleRequest(String requestType);
}

// Concrete Handler for General Support
class GeneralSupport extends SupportHandler {

    @Override
    public void handleRequest(String requestType) {
        if(requestType.equalsIgnoreCase("general")) {
            System.out.println("GeneralSupport: Handling general query");
        } else if(nextHandler != null) {
            nextHandler.handleRequest(requestType);
        } else  {
            System.out.println("GeneralSupport: No handler found");
        }
    }
}

// Concrete Handler for Billing Support
class BillingSupport extends SupportHandler {
    @Override
    public void handleRequest(String requestType) {
        if(requestType.equalsIgnoreCase("refund")) {
            System.out.println("BillingSupport: Handling refund request");
        } else if(nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }  else  {
            System.out.println("BillingSupport: No handler found");
        }
    }
}

// Concrete Handler for Technical Support
class TechnicalSupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("technical")) {
            System.out.println("TechnicalSupport: Handling technical issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        }  else  {
            System.out.println("TechnicalSupport: No handler found");
        }
    }
}

// Concrete Handler for Delivery Support
class DeliverySupport extends SupportHandler {
    public void handleRequest(String requestType) {
        if (requestType.equalsIgnoreCase("delivery")) {
            System.out.println("DeliverySupport: Handling delivery issue");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(requestType);
        } else {
            System.out.println("DeliverySupport: No handler found for request");
        }
    }
}

public class SupportServiceWithCOR {
    public static void main(String[] args) {
        SupportHandler general = new GeneralSupport();
        SupportHandler billing =  new BillingSupport();
        SupportHandler technical = new TechnicalSupport();
        SupportHandler delivery =  new DeliverySupport();

        // Setting up the chain: general -> billing -> technical -> delivery
        general.setNextHandler(billing);
        billing.setNextHandler(technical);
        technical.setNextHandler(delivery);

        // Testing the chain of responsibility with different request types
        general.handleRequest("refund");
        general.handleRequest("delivery");
        general.handleRequest("unknown");
    }
}
