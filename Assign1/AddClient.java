import java.rmi.*;

public class AddClient {
    public static void main(String args[]) { 
        try {
            // Check if correct number of arguments are provided
            if (args.length < 3) {
                System.out.println("Usage: java AddClient <server_host> <number1> <number2>");
                System.exit(1);
            }
            
            // Get reference to the remote object
            String addServerURL = "rmi://" + args[0] + "/AddServer"; 
            AddServerIntf addServerIntf = (AddServerIntf) Naming.lookup(addServerURL);
            
            System.out.println("The first number is: " + args[1]); 
            double d1 = Double.parseDouble(args[1]);
            
            System.out.println("The second number is: " + args[2]);
            double d2 = Double.parseDouble(args[2]);
            
            // Invoke remote method to add numbers
            System.out.println("The sum is: " + addServerIntf.add(d1, d2));
        } 
        catch (Exception e) {
            System.out.println("Exception: "+ e);
            e.printStackTrace();
        }
    }
}




































/*
Steps to run:
save all files in one single folder
1. =>cd foldername
2. =>javac --release 8 *.java
3. =>java AddServer
it will show "server is ready.."
now open other cmd
1. =>cd foldername
2. =>java AddClient localhost 4 7
it should show output as 11
*/

/*
Realted Theory-Remote Method Invocation (RMI) is a Java API that allows an object running in one Java Virtual Machine (JVM) to invoke methods on an object running in another JVM. It provides a powerful and flexible approach for building distributed applications, as it enables seamless communication between remote objects in different systems over a network. Java RMI abstracts the underlying network communication details, allowing developers to invoke remote methods as though they were local. This facilitates client-server-based applications where clients can interact with server-side objects by simply calling methods.

To improve the responsiveness and efficiency of a server handling multiple client requests, multithreading can be integrated into the RMI server. A multi-threaded RMI server is capable of serving multiple clients simultaneously by assigning each client request to a separate thread. This ensures that the server does not become a bottleneck when multiple clients interact with it concurrently. The Java RMI framework inherently supports multithreaded behavior, as each remote method invocation is handled in a separate thread by default. However, additional multithreading mechanisms may be implemented explicitly in the server code to manage resources better or perform background tasks.

In this context, the client/server communication begins with the creation of a remote interface that defines the methods the server will provide to clients. The server then implements this interface and registers the remote object with the RMI registry using a unique name. Clients can look up this name in the registry to obtain a reference to the remote object and invoke its methods remotely. With multithreading in place, the server can accept and handle multiple such invocations concurrently, making the system scalable and efficient.

Steps
To implement a multi-threaded client/server communication system using Java RMI, the following steps are followed. First, define a remote interface that extends java.rmi.Remote and declares all methods that clients will call remotely. Each method in this interface must throw a RemoteException. Next, create a class that implements this remote interface and extends UnicastRemoteObject. This class contains the actual logic of the methods and may explicitly use threads if needed to process long-running operations asynchronously.

After implementing the server logic, create a server application that creates an instance of the implementation class and binds it to the RMI registry using Naming.rebind() or similar methods. The RMI registry must be started before this step, which can be done using the rmiregistry command. On the client side, a client application is developed that looks up the remote object from the RMI registry using the same name used by the server and then calls the remote methods. Each remote call is executed in its own thread on the server, which can also spawn additional threads internally to manage the workload better.

Throughout this process, ensure that necessary security policies and network configurations are properly set to allow RMI communication. This includes granting appropriate permissions in the policy file and ensuring all required classes are available to both client and server during runtime.

Conclusion
Implementing multi-threaded client/server communication using Java RMI offers a robust solution for building distributed applications. It simplifies remote interactions by abstracting complex networking details and allows clients to call methods on remote servers as if they were local. By introducing multithreading on the server side, the system can handle multiple client requests simultaneously, thus improving throughput, responsiveness, and scalability. This model is widely applicable in real-world scenarios such as online services, distributed databases, and remote monitoring systems where concurrent access and processing are essential. Overall, Java RMI with multithreading provides a clean, modular, and efficient approach to remote communication in network-based applications.


*/