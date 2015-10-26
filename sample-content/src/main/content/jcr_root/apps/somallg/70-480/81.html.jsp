<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <style>
        table {
            border: 1px solid black;
            font-family: Arial;
        }
        

        tr:nth-child(odd) {
            background-color: red;
        }
        
        tr td:nth-of-type(even) {
            background-color: blue;
        }
    </style>
</head>
<body>
<table>
    <tr>
        <th>Fruit</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
    <tr>
        <td>Apples</td>
        <td>48</td>
        <td>$0.29</td>
    </tr>
    <tr>
        <td>Bananas</td>
        <td>72</td>
        <td>$0.19</td>
    </tr>
    <tr>
        <td>Watermelon</td>
        <td>14</td>
        <td>$3.99</td>
    </tr>
</table>
</body>
</html>