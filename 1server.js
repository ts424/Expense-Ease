const express = require('express');
const bodyParser = require('body-parser');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();
const port = process.env.PORT || 3000;

// Middleware
app.use(bodyParser.json());
app.use(cors());

// MongoDB connection
const mongoURI = 'mongodb+srv://singhtarun6363:password%40123@participants.zco5njd.mongodb.net/?retryWrites=true&w=majority&appName=participants';
mongoose.connect(mongoURI, { useUnifiedTopology: true, useNewUrlParser: true })
    .then(() => console.log('MongoDB connected successfully'))
    .catch(err => console.error('MongoDB connection error:', err));

const participantSchema = new mongoose.Schema({
    name: String,
    paid: { type: Number, default: 0 },
    consumed: { type: Number, default: 0 }
});

const Participant = mongoose.model('Participant', participantSchema);

// API route to handle form submission
app.post('/api/participants', async (req, res) => {
    try {
        const participants = req.body.participants.map(name => ({ name }));
        await Participant.insertMany(participants);
        res.status(200).send('Participants saved successfully!');
    } catch (error) {
        res.status(500).send('Error saving participants: ' + error.message);
    }
});

// API route to get participants
app.get('/api/participants', async (req, res) => {
    try {
        const participants = await Participant.find({}, 'name');
        res.status(200).json(participants);
    } catch (error) {
        console.error('Error fetching participants:', error); // Log any errors
        res.status(500).send('Error fetching participants: ' + error.message);
    }
});

// API route to update amounts
app.post('/api/updateAmount', async (req, res) => {
    const { amount, selectedPayer, selectedParticipants, dividedAmount } = req.body;

    try {
        // Update the payer
        await Participant.updateOne({ name: selectedPayer }, { $inc: { paid: amount } });

        // Update the consumers
        await Participant.updateMany(
            { name: { $in: selectedParticipants } },
            { $inc: { consumed: dividedAmount } }
        );

        res.status(200).send('Amounts updated successfully!');
    } catch (error) {
        console.error('Error updating amounts:', error); // Log any errors
        res.status(500).send('Error updating amounts: ' + error.message);
    }
});

app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
