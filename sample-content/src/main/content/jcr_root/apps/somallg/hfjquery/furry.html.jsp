<!DOCTYPE html>
<html>
<head>
    <title>Furry Campain</title>
    <style>
        #clickMe {
            background: #D8B36E;
            padding: 20px;
            text-aline: center;
            width: 205px;
            display: block;
            border: 2px solid #000;
        }
        
        #picframe {
            background: #D8B36E;
            padding: 20px;
            width: 205px;
            display: none;
            border: 2px solid #000;
        }
    </style>
</head>
<body>
<div id="showfriend">
    <div id="clickMe">Show</div>
    <div id="picframe">
        <img src="images/friend.jpeg">
    </div>
    <script src="../jquery-latest.js"></script>
    <script>
        $(document).ready(function() {
            $("#clickMe").click(function() {
                $("img").fadeIn(1000);
                $("#picframe").slideToggle('slow');
            });
        });
    </script>
</div>
</body>
</html>