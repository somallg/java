<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <script src="jquery-2.1.3.js"></script>
</head>
<body>
<a href="http://www.microsoft.com">
    <img src="ticket.gif"/>
</a>
<script>
    $(document).ready(function() {
        $('a img').each(function() {
            $(this).parent().attr('target', '_blank');
        });
    });
</script>
</body>
</html>