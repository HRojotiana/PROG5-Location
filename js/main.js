const readline = require('readline');
const Rentable = require('./Rentable');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const question = (query) => {
  return new Promise(resolve => rl.question(query, resolve));
};

async function getItemInfo() {
    const itemName = await question('What would you like to rent? ');
    const durationInput = await question('How many days will be the rental? ');

    const duration = parseFloat(durationInput); 
    const item = new Rentable(itemName); 
    item.rent(duration);
    console.log(item.getAvailability());
    

    rl.close();
}

getItemInfo();
