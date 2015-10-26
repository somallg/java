<!DOCTYPE html>
<html>
<head>
    <title>jQuery</title>
</head>
<style>
    #change_me {
        position: absolute;
        top: 100px;
        left: 400px;
        font: 24px arial;
    }
    
    #move_up #move_down #color #disappear {
        padding: 5px;
    }
</style>
<script src="../jquery-latest.js"></script>
<body>
    <button id="move_up">Move Up</button>
    <button id="move_down">Move Down</button>
    <button id="color">Change Color</button>
    <button id="disappear">Disappear/Re-appear</button>

    <div id="change_me">Do Stuff!</div>
    <script>
        $(document).ready(function() {
            $("#move_up").click(function() {
                $("#change_me").animate({top: 3}, 200);
            }); // end move up
            $("#move_down").click(function() {
                $("#change_me").animate({top: 400}, 2000);
            }); // end move down
            $("#color").click(function() {
                $("#change_me").css("color", "purple");
            }); // end color
            $("#disappear").click(function() {
                $("#change_me").toggle("slow");
            });// end disappear
        });// end doc ready
    </script>
</body>
</html>