<!DOCTYPE html>
<html>
<body>
<canvas id="mycanvas" width="300" height="300"></canvas>
<script type="text/javascript">
    var canvas = document.getElementById("mycanvas");
    var context = canvas.getContext("2d");
    context.fillStyle = "rgb(255, 0, 0)";
    context.fillRect(50, 50, 100, 100);
</script>
</body>
</html>