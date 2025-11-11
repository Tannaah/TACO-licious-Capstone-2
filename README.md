# TACO-licious 
Custom Taco Ordering System Overview

TACO-licious is a point-of-sale console application designed to automate the taco ordering process for a custom taco shop. Customers can build tacos or burritos with fully customizable shells, toppings, and sides, then check out and receive a digital receipt.

This project demonstrates advanced Java Object-Oriented Programming (OOP) principles such as encapsulation, abstraction, inheritance, and polymorphism.

## Design Thought Process

Before writing code, I identified the main objects in the system based on the problem description: tacos, toppings, drinks, and orders. I also noted that the system needed a way to interact with users, manage pricing, and generate receipts.

Key ideas: Each taco is an object that holds its own configuration (shell, toppings, extras, etc.).

An order contains multiple tacos or other menu items.

Separate classes manage the menu logic, order flow, and console interaction.

File I/O is used to generate receipt files for each completed order.
