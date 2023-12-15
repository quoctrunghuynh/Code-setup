//****************************** Game Đầu Tiên của TH ***********************/

//***************************** Tổng cục Canvas *****************************/
//Tạo các thẻ để vẽ vào frontend
var canvas = document.getElementById("myCanvas"); //Lấy thông tin từ thẻ canvas bên file html
var ctx = canvas.getContext("2d"); //Định dạng vẽ 2d

//***************************** Bóng và bệ đỡ *****************************/
//Vị trí giá trị trục x và y dùng cho mục
//đích cố đinh quả bóng xuất hiện giữa trung tâm đáy.

var x = canvas.width / 2;
var y = canvas.height - 30;
//Thêm giá trị dx và dy với múc đích sau mỗi khung hình đã vẽ
//các hình tròn sẽ khiến nó xuất hiện như là nó đang di chuyển
var dx = 5;
var dy = -5;

//Giá trị vỏ của quả bóng, thông số trùng với kích cỡ đc tô màu
const ballRadius = 20;

//Khởi tạo thông số paddle đỡ bóng
const paddleHeight = 20;
const paddleWidth = 100;

//Định vị paddle giữa trung tâm đáy
var paddleX = (canvas.width - paddleWidth) / 2;

//***************************** Chức năng phím *****************************/
//Giá trị khi chờ của phím mũi tên trái, phải ở dạng false để
//chờ lệnh khi dc dùng tới
var rightPressed = false;
var leftPressed = false;

//************************** Định dạng các khối gạch *********************var brickRowCount = 3;
var brickColumnCount = 11;
var brickRowCount = 3;
var brickWidth = 120;
var brickHeight = 35;
var brickPadding = 15;
var brickOffsetTop = 30;
var brickOffsetLeft = 30;

var bricks = [];
for (var i = 0; i < brickColumnCount; i++) {
  bricks[i] = [];
  for (var j = 0; j < brickRowCount; j++) {
    bricks[i][j] = { x: 0, y: 0, status: 1 };
  }
}

//***************************** Chức năng phím *****************************/
document.addEventListener("keydown", keyDownHandler, true);
document.addEventListener("keyup", keyUpHandler, true);

function keyDownHandler(e) {
  //Khi nhấn phím sẽ chuyển trạng thái của right/leftPressed
  if (e.key == "right" || e.key == "ArrowRight") {
    rightPressed = true;
  } else if (e.key == "Left" || e.key == "ArrowLeft") {
    leftPressed = true;
  }
}
function keyUpHandler(e) {
  //Tương tự khi thả phím
  if (e.key == "right" || e.key == "ArrowRight") {
    rightPressed = false;
  } else if (e.key == "Left" || e.key == "ArrowLeft") {
    leftPressed = false;
  }
}

//***************************** Chức năng phím *****************************/

function byebyebricks() {
  for (var i = 0; i < brickColumnCount; i++) {
    for (var j = 0; j < brickRowCount; j++) {
      var b = bricks[i][j];
      if (b.status == 1) {
        if (
          x > b.x &&
          x < b.x + brickWidth &&
          y > b.y &&
          y < b.y + brickHeight
        ) {
          dy = -dy;
          b.status = 0;
        }
      }
    }
  }
}

//*****************************Chức năng tạo hình******************************/
function drawBall() {
  // ctx.beginPath(); //Vẽ bóng
  // ctx.arc(x, y, ballRadius, 0, Math.PI * 2);
  // ctx.clip();
  let img = new Image();
  img.src = "duckie-removebg-preview.png";
  ctx.drawImage(img, x - 30, y - 30, 60, 60);
  // ctx.fillStyle = "blue";
  // ctx.fill();
  // ctx.closePath()
}

function drawPaddle() {
  //Vẽ paddle
  ctx.beginPath();
  ctx.rect(paddleX, canvas.height - paddleHeight, paddleWidth, paddleHeight);
  ctx.fillStyle = "Black";
  ctx.fill();
  ctx.closePath();
}

function drawBricks() {
  //Vẽ bricks
  for (let i = 0; i < brickColumnCount; i++) {
    //Tạo cột
    for (let j = 0; j < brickRowCount; j++) {
      //Tạo dòng
      if (bricks[i][j].status == 1) {
        var brickX = i * (brickWidth + brickPadding) + brickOffsetLeft; //Định dạng phần tử thuộc x trong mảng của bricks
        var brickY = j * (brickHeight + brickPadding) + brickOffsetTop; //Định dạng phần tử thuộc y trong mảng của bricks
        bricks[i][j].x = brickX; //Cho các giá trị trong mảng nhận giá trị đã định dạng
        bricks[i][j].y = brickY;
        let image = new Image();
        image.src = "brick.jpg";
        ctx.drawImage(image, brickX, brickY, brickWidth, brickHeight);
        // ctx.beginPath();
        // ctx.rect(brickX, brickY, brickWidth, brickHeight); //Chú thích: (Vị trí ở X, vị trí ở Y, độ rộng, độ cao)
        // ctx.fillStyle = "#0095DD";
        // ctx.fill();
        // ctx.closePath();
      }
    }
  }
}
//*********************(MAIN) Chức năng hoạt ảnh (MAIN)**********************/

function draw() {
  let cancelling = requestAnimationFrame(draw);
  //Chức năng di chuyển của bóng và paddle
  ctx.clearRect(0, 0, canvas.width, canvas.height); //Xóa hình ảnh cũ của bi
  drawBricks();
  drawBall();
  drawPaddle();
  byebyebricks();

  if (x + dx > canvas.width - ballRadius || x + dx < ballRadius) {
    //giới hạn bóng nảy từ trục tường Hoành
    dx = -dx;
  }
  if (y + dy < ballRadius) {
    //giới hạn bóng nảy từ trục tường Tung
    dy = -dy;
  } else if (y + dy > canvas.height - ballRadius) {
    if (x > paddleX && x < paddleX + paddleWidth + 8) {
      dy = -dy;
    } else {
      alert("You lose");
      document.location.reload();
      cancelAnimationFrame(cancelling); // Dừng hoạt ảnh
    }
  }

  //*********************Gọi chức năng phím**********************/

  if (rightPressed) {
    paddleX += 7;
    if (paddleX + paddleWidth > canvas.width) {
      paddleX = canvas.width - paddleWidth;
    }
    if (y <= canvas.height - paddleHeight) {
      dy = dy;
    }
  }
  if (leftPressed) {
    paddleX -= 7;
    if (paddleX < 0) {
      paddleX = 0;
    }
  }
  x += dx;
  y += dy;
}
draw();
