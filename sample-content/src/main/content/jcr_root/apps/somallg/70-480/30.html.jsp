<!doctype html>
<html>
<head>
    <script>
        function Customer(firstName, lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = "";
        }
        
        Customer.prototype.parseAddress = function(data) {
            this.address = data.address;
        }
        
        Customer.prototype.loadAddress = function() {

        }
    </script>
</head>
<body>
</body>
</html>