import java.rmi.registry.*;

public class AddServer {
    public static void main(String args[]) {
        try {
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            
            // Create RMI registry on port 1099 (default)
            Registry registry = LocateRegistry.createRegistry(1099);
            System.out.println("RMI Registry created on port 1099");
            
            // Create remote object
            AddServerImpl addServerImpl = new AddServerImpl();
            
            // Bind the remote object
            registry.rebind("AddServer", addServerImpl);
            System.out.println("AddServer bound in registry");
            
            System.out.println("Server is ready...");
        }
        catch (Exception e) {
            System.out.println("Exception: "+ e);
            e.printStackTrace();
        }
    }
}