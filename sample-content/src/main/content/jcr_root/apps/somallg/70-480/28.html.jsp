<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <title></title>
    <script>
        document.addEventListener("DOMContentLoaded", function() {
            var elButton = document.getElementById("myButton");
            var elDiv = document.getElementById("myDiv");
            elButton.addEventListener("click", function() {
                alert(this.type);
            }, false);
        }, false);
    </script>
</head>
<body>
    <div id="myDiv">Test</div>
    <input type="button" id="myButton" value="Click Me"/>
</body>
</html>