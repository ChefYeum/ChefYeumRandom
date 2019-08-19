import * as http from 'http';
import express from 'express';
import morgan from 'morgan';

const hostname = 'localhost';
const port = 5959;

const app = express();

app.use(morgan('dev'));
app.use(express.static(__dirname+'/public'));

app.use((req, res, _) => {
    console.log(req.headers);
    res.statusCode = 200;
    res.setHeader('Content-Type', 'text/html')
    res.end('wah');
});

const server = http.createServer(app);

server.listen(port, hostname, () => {
    console.log(`Server running at http://${hostname}:${port}`);
    console.log(`dirname: ${__dirname}`);
})
