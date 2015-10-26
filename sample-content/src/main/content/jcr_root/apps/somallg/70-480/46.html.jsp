<!DOCTYPE html>
<html>
<head>
    <style>
        /* unvisited link */
        a:link {
            color: #FF0000;
        }
        
        /* visited link */
        a:visited {
            color: #00FF00;
        }
        
        /* mouse over link */
        a:hover {
            color: #FF00FF;
        }
        
        /* selected link */
        a:active {
            color: #0000FF;
        }
    </style>
</head>
<body>
<p><b><a href="http://www.google.com" target="_blank">This is a link</a></b></p>
<p><b>Note:</b> a:hover MUST come after a:link and a:visited in the CSS definition in order to be effective.</p>
<p><b>Note:</b> a:active MUST come after a:hover in the CSS definition in order to be effective.</p>
</body>
</html>