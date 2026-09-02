# CS-320 Software Test Automation and QA

Java-based unit testing and quality assurance project built for CS-320 at Southern New Hampshire University.

## Overview

This project demonstrates software testing principles applied to a contact management system. The goal was to design a service that enforces data integrity, and then prove it works through rigorous JUnit 5 test coverage. Every field constraint, null check, boundary condition, and duplicate rule is verified by automated tests rather than manual inspection.

## Project Structure

| File | Description |
|------|-------------|
| `Contact.java` | Defines the Contact object with enforced field constraints (non-null, max lengths, immutable ID) |
| `ContactService.java` | Manages a collection of contacts with add, delete, and update operations |
| `ContactTest.java` | Unit tests for the Contact class covering valid inputs, null values, and length boundaries |
| `ContactServiceTest.java` | Unit tests for ContactService covering add, delete, update, and duplicate ID handling |
| `CS 320 Mod 7.pdf` | Summary and reflections report from Project Two |

## How It Works

The Contact class stores five fields: a unique contact ID, first name, last name, phone number, and address. Each field has strict rules. The ID is immutable and capped at 10 characters, names cap at 10 characters, phone must be exactly 10 digits, and address caps at 30 characters. Null values are never allowed.

ContactService acts as an in-memory store. It can add a new contact (rejecting duplicate IDs), delete a contact by ID, and update individual fields on an existing contact.

## Testing Approach

Tests were written in JUnit 5 and run in Eclipse with coverage reporting enabled. The test strategy covered:

- **Happy path** - valid inputs that should succeed
- **Null inputs** - every required field tested with null to confirm exceptions are thrown
- **Boundary conditions** - strings at exactly the max length, one character over, and well under
- **Duplicate IDs** - attempting to add a contact with an already-existing ID
- **Invalid updates** - targeting a non-existent contact ID

Coverage reports were used to confirm no testable branches were skipped.

## Reflection

**How do I ensure my code is functional and secure?**
The most reliable method I found was writing tests that go beyond happy paths, targeting edge cases and invalid inputs deliberately. In this course that meant null values, strings exceeding max length, and duplicate IDs. Running coverage reports in Eclipse helped confirm I was actually exercising the code I thought I was.

**How do I interpret user needs and incorporate them into a program?**
User needs have to be translated into concrete, testable requirements before any code gets written. In this project, the requirements told me exactly what constraints each field needed, including max lengths, non-null rules, and immutable fields. The tests confirmed those constraints held.

**How do I approach designing software?**
I build small and layer outward. I built the data object first, made sure it handled its own validation, then built the service on top of it, writing tests alongside each piece rather than saving them for the end. Testing is part of the design process, not a final step.
