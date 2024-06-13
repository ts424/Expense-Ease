
# Expense_Ease
Expense_Ease is a web application designed to simplify expense tracking and settlement among participants in a shared activity or event. This project allows users to enter expenses, select payers and participants, and automatically calculates the amounts owed and paid. It helps to ensure fair distribution of expenses and provides an easy way to settle balances among participants.

## Features
**Add Participants:** Add the names of participants involved in the expense sharing. <br>
**Enter Expenses:** Input the amount and select the payer and the participants sharing the expense. <br>
**Automatic Calculations:** Automatically divides the expense among selected participants and updates the amounts paid and consumed.<br>
**Fetch Participants:** Retrieves participant data from a MongoDB database.<br>
**Balance Settlement:** Calculates the net amount each participant owes or should receive based on their expenses and payments.<br>
**User-Friendly Interface:** Provides an intuitive and responsive user interface for managing expenses.<br>

## Technologies and Tech Stack
### Frontend
**HTML5:** Provides the structure of the web pages.<br>
**CSS3:** Styles the application for a better user experience.<br>
**JavaScript:** Implements the client-side logic and interactions.<br>
**Fetch API:** Fetches data from the backend and updates the frontend dynamically.<br>

### Backend
**Node.js:** Executes JavaScript code on the server.<br>
**Express.js:** Serves as the web application framework for building the API.<br>
**Mongoose:** Manages data and performs CRUD operations on MongoDB.<br>
**MongoDB:** Stores participant data and expense records.<br>

## Installation and Setup
### Prerequisites
Node.js and npm installed <br>
MongoDB database (local or cloud)

---

### Steps
**Clone the Repository:**
_git clone https://github.com/ts424/Expense-Ease.git
cd Expense_Ease_

**Install Dependencies:**
_npm install_

**Set Up Environment Variables:**
Create a .env file in the root directory and add your MongoDB connection string:

_MONGO_URI=your-mongo-connection-string_

**Run the Server:**
_node server.js_
The server will start on http://localhost:3000.

**Open the Application:**
Open index.html in your browser to start using the application.

## Usage
### Add Participants:
Open index.html and enter the number of partipants and click submit.<br>
On the next page input the names of all the participants. Click Submit.

### Enter Expenses:
You'll be directed to the expenses page where you have to enter the expenses one by one. <br>
Enter the amount, select the payer, and choose the participants sharing the expense.<br>
Click the "Add" button to save the expense and distribute it among the participants.

### Calculate and Settle Balances:
Click on the "Calculate" button to navigate to the settlement page after adding all the payments.<br>
The application will fetch all payments from the database, calculate the amounts owed and paid, and display the settlements required to balance the expenses.

## API Endpoints
**POST /api/participants:** Adds participants to the database. <br>
**GET /api/paherticipants:** Fetches the list of participants.<br>
**POST /api/updateAmount:** Updates the amounts paid and consumed by participants.<br>
**GET /api/settlement:** To calculate the amount owned and paid and help settle expenses.<br>

## Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.

