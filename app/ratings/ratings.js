// BookNova - ratings service (Node.js)
// A tiny HTTP service that returns a book's rating as JSON.

const http = require('http');

const PORT = process.env.PORT || 9080;

const RATINGS = { id: 1, ratings: { Reviewer1: 5, Reviewer2: 4 } };

const server = http.createServer((req, res) => {
  res.setHeader('Content-Type', 'application/json');

  if (req.url === '/health') {
    res.writeHead(200);
    return res.end(JSON.stringify({ status: 'ok' }));
  }

  if (req.url.startsWith('/ratings')) {
    res.writeHead(200);
    return res.end(JSON.stringify(RATINGS));
  }

  res.writeHead(404);
  res.end(JSON.stringify({ error: 'not found' }));
});

server.listen(PORT, () => console.log(`ratings service listening on ${PORT}`));
