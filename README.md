# Design-Pattern-Adapter

## 1. Definition of the Adapter Design Pattern

The **Adapter Design Pattern** is a structural design pattern that allows two incompatible interfaces to work together.

It acts as a bridge between a client that expects a specific interface and a class that provides a different interface. Instead of modifying the existing classes, the adapter converts the client's requests into operations understood by the target object.

In this project, the adapter connects an HDMI-compatible source to a VGA-compatible device, allowing devices with different interfaces to communicate.

### Objectives

- Make incompatible interfaces work together.
- Reuse existing classes without modifying their source code.
- Separate the client from the implementation details of incompatible devices.
- Improve flexibility by allowing different devices to communicate through a common interface.

## 2. Class Diagram

The class diagram illustrates the relationships between the HDMI interface, the VGA interface, the devices, and the adapter.

The `HdmiVgaAdaptateur` class acts as an intermediary between an HDMI-compatible source and a VGA-compatible device. It implements the expected HDMI interface and delegates the necessary operations to the VGA component.

<img width="1182" height="765" alt="image" src="https://github.com/user-attachments/assets/42906e0e-aa43-42b3-afea-42bec5543e62" />

## 3. Ecran Class

The `Ecran` class represents a screen that receives and displays visual data.

It acts as a client of the HDMI interface, allowing it to communicate with compatible devices without depending on their concrete implementations.

### Main Responsibilities

- Receive visual data through the expected interface.
- Interact with an HDMI-compatible source.
- Display the received information according to the implementation.

The screen relies on the interface expected by the client, while the adapter makes it possible to connect devices that use a different interface.

<img width="1470" height="605" alt="Ecran Class" src="https://github.com/user-attachments/assets/709abd8f-1812-48ef-b891-60a7f545db55" />

## 4. Hdmi Interface

The `Hdmi` interface defines the contract for devices that receive data through an HDMI-compatible connection.

It provides a common method that HDMI-compatible implementations must implement.

### Main Method

- **`view(byte[] data)`**: Receives a byte array representing the data to be processed or displayed.

By using an interface, the application can work with different implementations through the same contract.

<img width="1622" height="560" alt="Hdmi Interface" src="https://github.com/user-attachments/assets/72ee726f-f6a8-498d-9bc9-70bf9ee650af" />

## 5. SuperVp Class

The `SuperVp` class represents a video projector that works with the HDMI interface, according to the project implementation.

It can receive data through the HDMI contract and process it for projection.

### Main Responsibilities

- Implement the `Hdmi` interface.
- Receive data through the `view(byte[] data)` method.
- Process or display the received information according to its implementation.

This class illustrates how a device can provide its own implementation of a shared interface.

<img width="1750" height="1205" alt="SuperVp Class" src="https://github.com/user-attachments/assets/f068d3cf-aa35-444f-bef1-ca83ec84ee14" />

## 6. Tv Class

The `Tv` class represents a television that implements the `Hdmi` interface.

It provides its own implementation of the `view(byte[] data)` method to receive and display the supplied data.

### Main Responsibilities

- Implement the `Hdmi` interface.
- Receive data through the `view()` method.
- Process the received data according to the television's behavior.

The `Tv` class demonstrates polymorphism because it can be used wherever an `Hdmi` reference is expected.

<img width="1685" height="977" alt="Tv Class" src="https://github.com/user-attachments/assets/72e5e817-e760-4f0e-b76c-4fa247efad4c" />

## 7. UniteCentral Class

The `unitecentral` class represents a central unit that produces or sends data to an output device.

It serves as the source of the information that must be transmitted through a compatible interface.

### Main Responsibilities

- Produce or provide the data to be transmitted.
- Interact with the output component through the appropriate interface.
- Supply data that can be processed by an HDMI-compatible device or passed through the adapter.

The central unit represents the source side of the communication process.

<img width="1795" height="1050" alt="UniteCentral Class" src="https://github.com/user-attachments/assets/ceabae24-6a59-4f09-9c43-125191743c5f" />

## 8. VGA Interface

The `Vga` interface represents the contract for devices that receive data through a VGA-compatible connection.

Its interface differs from the HDMI interface, which is why an adapter is needed to connect the two sides.

### Main Method

- **`print(byte[] data)`**: Receives data and processes it according to the VGA interface's expected behavior.

The difference between the `Hdmi` and `Vga` interfaces creates the incompatibility that the adapter resolves.

<img width="1692" height="612" alt="VGA Interface" src="https://github.com/user-attachments/assets/9a7caecf-f65f-4628-a592-72cd120777b6" />

## 9. Videoprojecteur Class

The `Videoprojecteur` class represents a video projector that uses the VGA interface.

It implements the `Vga` interface and provides its own behavior for processing the data it receives.

### Main Responsibilities

- Implement the `Vga` interface.
- Receive data through the `print(byte[] data)` method.
- Process the data according to the projector's implementation.

Because this device uses VGA rather than HDMI, it cannot necessarily be used directly by a client that expects the `Hdmi` interface.

<img width="1702" height="600" alt="Videoprojecteur Class" src="https://github.com/user-attachments/assets/03a97955-0047-469d-9807-7a4a86ed9cd7" />

## 10. HdmiVgaAdaptateur Class

The `HdmiVgaAdaptateur` class is the central component of the Adapter Design Pattern.

It bridges the incompatibility between the HDMI interface expected by the client and the VGA interface provided by the projector.

The adapter implements `Hdmi` and uses a `Vga` object internally. When the client invokes the HDMI method, the adapter translates that request into the corresponding VGA operation.

### Main Responsibilities and Methods

- **Implement `Hdmi`:** Makes the adapter compatible with clients expecting an HDMI device.
- **Maintain a reference to `Vga`:** Allows the adapter to communicate with the VGA-compatible device.
- **`view(byte[] data)`:** Receives the request through the HDMI interface and delegates the data to the VGA component using its corresponding method.

Conceptually, the conversion follows this flow:

`Hdmi.view(data)` → `Vga.print(data)`

The adapter enables the client to work with the VGA projector without modifying either the HDMI client or the projector's existing implementation.

<img width="1722" height="1530" alt="HdmiVgaAdaptateur Class" src="https://github.com/user-attachments/assets/5857fa38-0e8e-4027-a5e3-8336341ba3b3" />

## 11. Main Class

The `Main` class contains the program's entry point, the `main()` method.

It creates the objects required for the demonstration and shows how the adapter allows an HDMI-compatible client to communicate with a VGA-compatible device.

### Main Responsibilities

- Instantiate the required devices.
- Create the adapter around the VGA-compatible component.
- Pass the adapter to the client that expects an HDMI interface.
- Send data through the HDMI method.
- Observe how the adapter delegates the request to the VGA device.

The `Main` class demonstrates that the client can use the adapter without needing to know the details of the VGA implementation.

<img width="1687" height="1652" alt="Main Class" src="https://github.com/user-attachments/assets/f93a3791-7e31-4bef-8703-ccc5ee803ea5" />

## 12. Execution Result

The following screenshot shows the output produced by running the program.

It illustrates the communication between the client, the adapter, and the VGA-compatible device.

When the client sends data through the HDMI interface, the adapter forwards the request to the corresponding VGA method, allowing the incompatible components to work together.

<img width="1480" height="1115" alt="Execution Result" src="https://github.com/user-attachments/assets/10758b61-be4a-4469-ba30-6c67f6a59281" />

## 13. How It Works

The implementation follows these steps:

1. The client expects an object implementing the `Hdmi` interface.
2. The VGA-compatible projector implements the `Vga` interface instead.
3. The `HdmiVgaAdaptateur` receives the VGA object.
4. The adapter implements `Hdmi`, making it compatible with the client.
5. The client invokes `view(data)` on the adapter.
6. The adapter delegates the request to `print(data)` on the VGA component.

### Communication Flow

```text
Client
  |
  v
Hdmi Interface
  |
  v
HdmiVgaAdaptateur
  |
  v
Vga Interface
  |
  v
Videoprojecteur
```

The key idea is that the adapter translates the expected interface into the interface supported by the existing device.

## 14. Advantages of the Adapter Design Pattern

- **Compatibility:** Connects components with incompatible interfaces.
- **Reusability:** Reuses existing classes without changing their code.
- **Loose coupling:** Keeps the client independent of the concrete VGA implementation.
- **Maintainability:** Isolates interface conversion in a dedicated class.
- **Extensibility:** Makes it easier to integrate additional incompatible components through suitable adapters.

## 15. Conclusion

The Adapter Design Pattern provides a solution for integrating components that expose different interfaces.

In this project, `Hdmi` defines the interface expected by the client, `Vga` defines the interface supported by the projector, and `HdmiVgaAdaptateur` bridges the gap between them.

This pattern is useful when integrating legacy systems, third-party libraries, incompatible APIs, or hardware components without modifying their original implementations.

## Technologies and Concepts

- **Language:** Java
- **Design Pattern:** Adapter (Structural)
- **Java Concepts:** Interfaces, composition, polymorphism, method overriding, and delegation
