# Let's Taco 'Bout It
This is a console-based restaurant management system built in Java!

Custom Taco Ordering System Overview:

TACO-licious is a point-of-sale console application designed to automate the taco ordering process for a custom taco shop. Customers can build tacos or burritos with fully customizable shells, toppings, and sides, then check out and receive a digital receipt.

This project demonstrates advanced Java Object-Oriented Programming (OOP) principles such as encapsulation, abstraction, inheritance, and polymorphism.


## Design Thought Process

Before writing code, I identified the main objects in the system based on the problem description: tacos, toppings, drinks, and orders. I also noted that the system needed a way to interact with users, manage pricing, and generate receipts.

Key ideas: Each taco is an object that holds its own configuration (shell, toppings, extras, etc.).

An order contains multiple tacos or other menu items.

Separate classes manage the menu logic, order flow, and console interaction.

File I/O is used to generate receipt files for each completed order.


## Planned Class Structure
| Category         | Class                                  | Responsibility                                |
| ---------------- | -------------------------------------- | --------------------------------------------- |
| Core Models      | `Taco`, `Topping`, `Order`, `MenuItem` | Represent food items and how they’re composed |
| Menu Logic       | `Menu`, `PricingHelper`                | Handle price lookups and category management  |
| User Interaction | `ConsoleHelper`, `UserInterface`       | Manage prompts and user input                 |
| Persistence      | `ReceiptFileManager`                   | Save completed order receipts                 |
| Utility          | `App` or `Main`                        | Entry point to start the application          |


## Features (to implement)

Create and customize tacos (shell, meat, cheese, toppings, sauces, extras).

Add drinks or chips & salsa to orders.

Display full order summary and total cost.

Save receipt file with unique date-time filename.

Handle input validation and cancel/exit options gracefully.

## How to Run

Clone the repository from GitHub.

Open the project in IntelliJ.

Run Main.java to start the application.

# Taco Class Framework/Outline
<img width="2194" height="1566" alt="Screen Shot 2025-11-11 at 17 54 05 PM" src="https://github.com/user-attachments/assets/6f248827-9d70-455f-88b8-d1e0c5b64e0e" />

## Taco Class Pricing Coding Plan
<img width="2210" height="998" alt="Screen Shot 2025-11-11 at 18 34 01 PM" src="https://github.com/user-attachments/assets/e7acd481-8d60-4f0f-bc38-95d36e4eba50" />

## Orders Class Outline/Framework
<img width="2030" height="1490" alt="Screen Shot 2025-11-11 at 20 03 06 PM" src="https://github.com/user-attachments/assets/65d425f5-db97-49e6-b028-1909664a945c" />


