<canvas id="clickCanvas" width="300" height="300">
Your browser does not support HTML5 Canvas
</canvas>
<script>
var canvas;
var context;
window.onload = function initialize() {
	canvas = document.getElementById("clickCanvas");
	context = canvas.getContext("2d");
	drawBox();
	canvas.onclick = clickReporter;
}

function clickReporter(e) {
	alert('clicked');
}

function drawBox() {
	context.fillStyle = 'black';
	context.strokeRect(20, 20, canvas.width - 20, canvas.height - 20);
}
</script>
