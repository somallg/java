<!DOCTYPE html>
<html>
<head>
    <script>
        function start() {
            var counter = 10;
            var fun = function() {
                counter = 20;
            }
            return counter;
        }
    </script>
</head>
<body>
    <button id="submit" onclick="alert(start());">Start</button>
</body>
</html>