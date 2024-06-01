document.addEventListener("DOMContentLoaded", () => {
    const canvas = document.getElementById('tetrisCanvas');
    const context = canvas.getContext('2d');
    const scale = 30;

    function drawBoard(board) {
        context.clearRect(0, 0, canvas.width, canvas.height);
        for (let y = 0; y < board.length; y++) {
            for (let x = 0; x < board[y].length; x++) {
                if (board[y][x] !== 0) {
                    context.fillStyle = 'blue';
                    context.fillRect(x * scale, y * scale, scale, scale);
                    context.strokeRect(x * scale, y * scale, scale, scale);
                }
            }
        }
    }

    function updateBoard() {
        fetch('/tetris/board')
            .then(response => response.json())
            .then(data => {
                drawBoard(data);
            });
    }

    setInterval(updateBoard, 1000);
});
