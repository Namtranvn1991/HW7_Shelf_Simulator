# Storage Simulator

## Overview
This project is a simple storage system that simulate how items are placed into shelves.

Each shelf has limited space and items can only be stored if they fit in the shelf size.  
The purpose of this project is to represent a real world storage problem and manage items.

---

## Usage Instructions

1. Put all Java files in same directory
2. Compile the program:
   javac *.java
3. Run the program:
   java Main

Right now, you need to create shelves and items manually inside Main class.

Example:

Simulator simulator = new Simulator();

Shelf shelf1 = new Shelf("S1", new Volume(10, 100, 50), 5);
simulator.addShelf(shelf1);

Item item1 = new Item("I1", new Volume(5, 20, 30));
simulator.addItem(item1);

simulator.displayAllShelves();
simulator.displayAllItems();

---

## Tech Stack

- Java
- Object Oriented Programming

---

### 1. Core Classes

#### Simulator
Main controller that manages operations such as:
- Adding shelves
- Adding/removing items
- Searching items

#### Storage
Global storage manager that keeps:
- All shelves
- Available shelves (PriorityQueue)
- All items

#### StorageUnit (Abstract Class)
Base class for storage entities:
- ID
- Volume
- Full/Not full status

#### Shelf
Represents a storage shelf:
- Stores items
- Tracks remaining width
- Implements priority logic

#### Item
Represents an object stored in shelves:
- Has ID
- Has volume
- Tracks which shelf it belongs to

#### Volume
Represents 3D dimensions:
- height
- width
- depth

Also provides:
- volume calculation
- bottom area calculation


## Future Improvements
- 2D/3D packing optimization
- Visualization (CAD-like UI)
- CSV import for batch items
- Smart placement algorithms (bin packing)

## Developers

- Keisuke Kudo
- Tran
