<!doctype html>
<html>
<head>
    <script>
        function validateSSN(userinput) {
            var ssnPattern = /^[0-9]{3}\-?[0-9]{2}\-?[0-9]{4}$/
           
            return ssnPattern.test(userinput);
        }
        
        function validateEmail(userinput) {
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
            
            return emailPattern.test(userinput);
        }
    </script>
</head>
<body>
</body>
</html>