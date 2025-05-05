import java.rmi.*;
import java.rmi.server.*;

// class that implements the remote interface
public class AddServerImpl extends UnicastRemoteObject 
implements AddServerIntf {
    // constructor
    public AddServerImpl() throws RemoteException {
        super();
    }
    
    // implement method declared in the interface
    public double add(double d1, double d2) throws RemoteException {
        System.out.println("Adding " + d1 + " and " + d2);
        return d1 + d2;
    }
}