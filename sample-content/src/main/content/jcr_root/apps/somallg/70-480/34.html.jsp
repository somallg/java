<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="jquery-2.1.3.js"></script>
    <script>
        $(document).ready(function () {
            $('table td:nth-child(2) input').focus(
                    function () {
                        $(this).parent().next().css("background-color", "#00FF00");
                    });
            $('table td:nth-child(2) input').blur(
                    function () {
                        $(this).parent().next().css("background-color", "#FFFFFF");
                    });
        });
    </script>
</head>
<body>
<table>
    <tr>
        <td>Item</td>
        <td>Input</td>
        <td>Current</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>
            <input type="text"/>
        </td>
        <td></td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>
            <input type="text"/>
        </td>
        <td></td>
    </tr>
</table>
</body>
</html>
