import * as http from 'http';

let port = 4444;
let hostname = "localhost";

const server = http.createServer((req,_) => {
    console.log(req.headers);
});

server.listen(port, hostname, () =>{
    console.log(`Server running at http://${hostname}:${port}/`)
})
