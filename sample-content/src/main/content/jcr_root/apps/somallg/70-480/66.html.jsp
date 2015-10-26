<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script>
        function Car() {}
        Car.prototype.fourDoor = function() {
            alert("foor doors");
        }
        
        function Sedan() {
            Car.call(this);
        }
        
        Sedan.prototype = new Car();
        Sedan.prototype.constructor = Sedan;
        Sedan.prototype.fourDoor = function() {
            alert("sedan");
        }
    </script>
</head>
<body></body>
</html>