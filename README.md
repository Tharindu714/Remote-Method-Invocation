# Remote Method Invocation (RMI) Project 🚀

![RMI Banner](https://miro.medium.com/v2/resize:fit:1008/1*JTxXJA0G6wnumVVl11UVHQ.png)

## Table of Contents 📑

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup and Installation](#setup-and-installation)
- [How to Run the Project](#how-to-run-the-project)
- [Usage](#usage)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

---

## Overview 🔍

The **Remote Method Invocation (RMI) Project** is designed to demonstrate and implement the Java RMI framework for distributed application development. This project serves as a practical example of how remote objects can be used to create network-enabled applications where methods of remote Java objects can be invoked from another Java virtual machine (JVM).

Key components include:

- A server application that registers remote objects in the RMI registry.
- A client application that locates the remote objects and invokes methods on them.
- A clear design to help developers understand core RMI concepts.

---

## Features ✨

- **Distributed Processing:** Easily invoke methods on objects located on different JVMs.
- **Dynamic Lookup:** The client dynamically locates and communicates with remote objects.
- **Robust Error Handling:** Designed to gracefully handle network issues and remote exceptions.
- **Extendibility:** A modular structure that allows adding more remote services with minimal changes.
- **Educational:** Provides a clear example of core RMI operations to aid learning and experimentation.

---

## Architecture 🏗️

The project leverages Java’s built-in RMI API and follows this high-level architecture:

1. **Remote Interface:** Defines the methods that can be invoked remotely.
2. **Remote Object Implementation:** Implements the remote interface and extends `UnicastRemoteObject` to export the object.
3. **RMI Registry:** A separate process that maps names to remote objects, allowing clients to lookup objects.
4. **Client Application:** Retrieves the remote object from the RMI registry and invokes remote methods.

Simplified diagram of the architecture:
```bash
+----------------+
+-------------------+
+----------------+
      | | | | | | | Client
             +<------->+ RMI Registry
              +<------->+ Server
                    | | | Lookup
                       | | Bind
                         | (Remote Object)|
 +----------------+
+-------------------+
+----------------+
```

---

## Project Structure 🗂️

An overview of the main directories and files:
```bash
Remote-Method-Invocation/
    │ ├── src/
      │ ├── RMIClient/
        │ │ └── RMIClient.java
                # Client application to invoke remote methods
        │ ├── RMIClient/
          │ │ ├── RMIServer.java
                  # Server-side code to register remote objects
               │ │ └── RemoteServiceImpl.java
                # Implementation of the remote interface
                 │ └── common/
                 │ └── RemoteService.java
                # Remote interface shared between client and server
        │ ├── lib/ # Any required libraries or dependencies
          ├── docs/ # Additional documentation and design diagrams
          ├── README.md # This file
          └── LICENSE # License information (if applicable)
```

---

## Prerequisites ✅

Before setting up the project, ensure you have the following installed:

- **Java Development Kit (JDK):** Version 8 or later (set `JAVA_HOME` accordingly)
- **IDE/Text Editor:** Any modern IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor with Java support.
- **Git:** For cloning the repository.
- **Network Access:** Basic understanding of networking (if testing across different machines).

---

## Setup and Installation 🛠️

Follow these steps to set up and run the project locally:

1. **Clone the Repository**

   Open a terminal and run:
   
```bash
   git clone https://github.com/Tharindu714/Remote-Method-Invocation.git
   cd Remote-Method-Invocation
```
2. **Compile the Code**
   
Navigate to the root of the project and compile all Java files. For example, using the command line:
```bash
javac -d bin src/common/RemoteService.java src/server/RemoteServiceImpl.java src/server/RMIServer.java src/client/RMIClient.java
```
>**Note**: Make sure to create the output directory (bin) if it doesn't exist.

3.**Start the RMI Registry**

The RMI Registry must be running before starting the server. Open a terminal, navigate to the bin folder, and run:
```bash
cd bin
rmiregistry 1099 &
```
>**Note**: Port 1099 is the default. If you choose a different port, update the configuration in your server code accordingly.

4. **Run the Server**

With the registry running, start the server to bind the remote object:
```bash
java -cp bin server.RMIServer
Run the Client
```
5. **Open a new terminal window, navigate to the bin directory, and run:**
```bash
java -cp bin client.RMIClient
```
The client will look up the remote object from the registry and invoke its methods.

## How to Run the Project ▶️
**Server Execution:**

- The server starts by binding the remote service to the RMI registry. Log outputs will confirm that the service is registered.

**Client Execution:**

- The client fetches the remote service from the registry and performs remote invocations. The results of these operations will be displayed in the console.

>If you encounter any connection or lookup issues, verify the host and port settings in both the server and client code.

## Usage 💻
Once the project is running, you can:

**Extend Remote Services:**
- Add new methods to RemoteService.java and implement them in RemoteServiceImpl.java.

**Test Fault Tolerance:**
- Simulate network issues or shut down the server to observe how the client handles exceptions.

**Explore Distributed Computing Concepts:**
- Utilize this project as a learning tool to understand inter-process communication, remote objects, and network transparency via Java RMI.

## Testing 🧪
The project includes basic runtime testing through the client. For comprehensive testing:
- Implement unit tests for your remote methods.
- Use frameworks like JUnit for automation.
- Simulate client failures or network interruptions to validate robust exception handling.

## Contributing 🤝
- Contributions are welcome! To contribute:
- Fork the repository.
- Create a feature branch:
```bash
git checkout -b feature/my-new-feature
```
**Commit your changes and push your branch.**

Open a pull request with a detailed explanation of your changes.
<br>
For significant changes, consider opening an issue first to discuss your proposed modifications.

## License 📄
This project is licensed under the MIT License - see the [LICENSE](https://github.com/Tharindu714/Remote-Method-Invocation/blob/main/LICENSE) file for details.

## Acknowledgements 🙏
Thank you to all contributors who have provided insightful feedback and improvements.
<br>
Inspired by various online resources and open-source projects that demonstrate the power of Java RMI.
<br>
Special mention to the Java Documentation for comprehensive guidance on RMI.
