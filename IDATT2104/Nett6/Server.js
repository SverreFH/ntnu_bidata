const wsServer = net.createServer((connection) => {
    console.log('Client connected');

    connection.on('data', (data) => {
        console.log('Data received from client: ', data.toString());
    });

    connection.on('end', () => {
        console.log('Client disconnected');
    });
});
wsServer.on('error', (error) => {
    console.error('Error: ', error);
});
wsServer.listen(3001, () => {
    console.log('WebSocket server listening on port 3001');
});