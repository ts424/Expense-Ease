
# Expense_Ease
Expense_Ease is a web application designed to simplify expense tracking and settlement among participants in a shared activity or event. This project allows users to enter expenses, select payers and participants, and automatically calculates the amounts owed and paid. It helps to ensure fair distribution of expenses and provides an easy way to settle balances among participants.

## Features
Add Participants: Add the names of participants involved in the expense sharing.
Enter Expenses: Input the amount and select the payer and the participants sharing the expense.
Automatic Calculations: Automatically divides the expense among selected participants and updates the amounts paid and consumed.
Fetch Participants: Retrieves participant data from a MongoDB database.
Balance Settlement: Calculates the net amount each participant owes or should receive based on their expenses and payments.
User-Friendly Interface: Provides an intuitive and responsive user interface for managing expenses.

## Technologies and Tech Stack
Frontend
HTML5: Provides the structure of the web pages.
CSS3: Styles the application for a better user experience.
JavaScript: Implements the client-side logic and interactions.
Fetch API: Fetches data from the backend and updates the frontend dynamically.
Backend
Node.js: Executes JavaScript code on the server.
Express.js: Serves as the web application framework for building the API.
Mongoose: Manages data and performs CRUD operations on MongoDB.
MongoDB: Stores participant data and expense records.
Middleware
Body-Parser: Parses incoming request bodies in a middleware before handlers.
CORS: Enables Cross-Origin Resource Sharing, allowing the frontend to communicate with the backend.
Installation and Setup
Prerequisites
Node.js and npm installed
MongoDB database (local or cloud)
Steps
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/Expense_Ease.git
cd Expense_Ease
Install Dependencies:

bash
Copy code
npm install
Set Up Environment Variables:

Create a .env file in the root directory and add your MongoDB connection string:

env
Copy code
MONGO_URI=your-mongo-connection-string
Run the Server:

bash
Copy code
node server.js
The server will start on http://localhost:3000.

Open the Application:

Open amount.html in your browser to start using the application.

Usage
Add Participants:

Navigate to the participant entry page and input the names of all participants.
Enter Expenses:

Go to the expense entry page.
Enter the amount, select the payer, and choose the participants sharing the expense.
Click the "Add" button to save the expense and distribute it among the participants.
Calculate and Settle Balances:

Click on the "Calculate" button to navigate to the settlement page.
The application will fetch all payments from the database, calculate the amounts owed and paid, and display the settlements required to balance the expenses.
API Endpoints
POST /api/participants: Adds participants to the database.
GET /api/participants: Fetches the list of participants.
POST /api/updateAmount: Updates the amounts paid and consumed by participants.
License
This project is licensed under the MIT License. See the LICENSE file for details.

Contributing
Contributions are welcome! Please open an issue or submit a pull request for any changes or improvements.

