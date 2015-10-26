<!DOCTYPE html>
<html>
<head>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<form>
    <input type="text" name="email"/>
    <input type="submit" value="Submit"/>
</form>
<script>
    $("form").submit(function () {
        var str;
        str = $("form").serialize();
        str = decodeURIComponent(str);
        alert(str);
        return true;
    });
</script>
</body>
</html>