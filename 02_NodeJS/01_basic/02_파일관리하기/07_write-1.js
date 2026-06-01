fs = require('fs');

const data = fs.readFileSync('./04_example.txt', 'utf8');
fs.writeFileSync('./text-1.txt', data);
