<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Click me!</title>
    <style>
        body, button { margin: 10px; }
        div { padding: 10px }
    </style>
    <script>
        window.onload = function() {
            var count = 0;
            var message = "You clicked ";
            var div = document.getElementById("message");
            
            var button = document.getElementById("clickme");
            button.onclick = function() {
                count++;
                div.innerHTML = message + count + " times!";
            }
        };
        
        (function(food) {
            if (food === "cookies") {
                alert("More please");
            } else if (food === "cake") {
                alert("Yum yum");
            }
        })("cake");
    </script>
</head>
<body>
    <button id="clickme">Click me!</button>
    <div id="message"></div>
</body>
</html> 