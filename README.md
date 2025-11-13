# 🌮 Let's Taco 'Bout It! 🌮
### (Taco Restaurant Management System Application)
-------------------------
This is a object-oriented console-based restaurant management system built in Java! This program allows users to build taco orders, add sides and drinks, and receive receipt files.

This system demonstrates strong Object-Oriented Programing design using:
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction

Every part of the order process — tacos, drinks, toppings, sides, and signature items. All are represented in its own class, making the system easy to read and maintain.

-------------------------
## ⭐️ Design and Thought Process

Before writing code, I identified the main components based on the Capstone Project Description. Such as the Classes, Packages and the organization. I also noted that the system needed a way to interact with users, manage pricing, and generate receipts.

Pre-code Ideas:

An order contains multiple tacos or other menu items.

Separate classes manage the Menu(s), provide order, and console interaction.

File I/O is used to generate receipt files for each completed order.

-------------------------
## ⭐️ Features

- Its Purpose: Create and manage customer orders.
- Add fully customized Tacos:
  - Choose taco size
  - Choose shell type
  - Add meats, cheeses, veggies, sauces
  - Add extra premium toppings
  - Option to deep-fry
- Add drinks (small/medium/large)
- Add chips & salsa (choose salsa type)
- Signature Tacos (Bonus Feature)
  - Street Taco
  - Super Burrito
  - Customizable (add/remove toppings)
- Input validation for all choices
- Auto-generated receipts saved as timestamped `.txt` files
- Organized folder structure using Object-Oriented Programing best practices
  
-------------------------
## ⭐️ Project Structure

<img width="788" height="1278" alt="Screen Shot 2025-11-13 at 18 19 42 PM" src="https://github.com/user-attachments/assets/154bd3c5-9a3b-492c-ba5c-af3c7a59ba9d" />

-------------------------
## ⭐️ Receipts Folder
When an order is checked out:

A folder named receipts/ is automatically created (if it doesn't exist)

Each receipt contains:

- Customer name

- Full taco details

- Drinks & sides

- Total price

- Completion status

-------------------------

# Taco Class Outline/Framework
<img width="2194" height="1566" alt="Screen Shot 2025-11-11 at 17 54 05 PM" src="https://github.com/user-attachments/assets/6f248827-9d70-455f-88b8-d1e0c5b64e0e" />

## Taco Class Pricing Coding Plan
<img width="2210" height="998" alt="Screen Shot 2025-11-11 at 18 34 01 PM" src="https://github.com/user-attachments/assets/e7acd481-8d60-4f0f-bc38-95d36e4eba50" />

## Order Class Outline/Framework
<img width="2030" height="1490" alt="Screen Shot 2025-11-11 at 20 03 06 PM" src="https://github.com/user-attachments/assets/65d425f5-db97-49e6-b028-1909664a945c" />

## ConsoleHelper Outline/Framework
<img width="2202" height="1426" alt="Screen Shot 2025-11-12 at 09 39 46 AM" src="https://github.com/user-attachments/assets/5741fe67-ea43-4557-96d9-8773b67e4041" />

## UserInterface Class Outline/Framework
<img width="2250" height="1206" alt="Screen Shot 2025-11-12 at 10 46 13 AM" src="https://github.com/user-attachments/assets/9dbd7457-66cc-4d80-aa19-f6068a45eb01" />

-------------------------

## How to Run
Clone the repository from GitHub.
Open the project in IntelliJ.
Run Main.java to start the application.

-------------------------
