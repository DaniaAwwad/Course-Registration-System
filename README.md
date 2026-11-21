# Student Course Registration System

A Java console-based application developed for the Software Engineering Tools course (Part 4: Implementation and Version Control).

## Features
- View available courses with credit hours, available seats, and prerequisites.
- Register for courses with validation (duplicate check, prerequisite check, seat availability, and 18-credit-hour limit).
- Drop registered courses and view student schedule.
- Administrative course management and course search functionality.

## Project Structure
- `models/`: Core entities (`Student`, `Course`, `Administrator`).
- `services/`: Business logic (`RegistrationService`, `CourseSearchService`).
- `main/`: Application entry point and CLI menu (`Main`).

## How to Run
```bash
javac -encoding UTF-8 models/*.java services/*.java main/*.java
java main.Main