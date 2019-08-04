import * as http from 'http';
import * as readline from 'readline';

const server = http.createServer((req,res) => {
    console.log(req.statusCode);
});

const stdinout = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let port;
const hostname = "localhost";

stdinout.question('Please specify the port: ', (p) => {
    port = p;
    server.listen(port,  );

});
