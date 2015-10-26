<script>
    function zoomIn() {
        //var myGraphic = document.getElementById("myGraphic");
        //myGraphic.setAttribute("currentScale", "1.5");

        var myCircle = document.getElementById("myCircle");
        myCircle.setAttribute("currentScale", "1.5");
    }
</script>
<svg height="150" width="150" id="myGraphic">
    <circle cx="25" r="20" cy="20" fill="orange" id="myCircle"/>
</svg>
<button id="zoom" onclick="zoomIn();">Zoom In</button>

