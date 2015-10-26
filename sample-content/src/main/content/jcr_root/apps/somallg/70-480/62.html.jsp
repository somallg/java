<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
</head>
<body>
<input id="Country" type="text"/>
<input type="button" value="submit" onclick="validate()"/>
<div id="valid"></div>
<script>
    function validate() {
        var arr = new Array();
        arr["US"] = true;
        arr["CA"] = true;
        arr["UK"] = false;
        
        var ctry = document.getElementById("Country").value;
        
        if (!arr[ctry]) {
            var txt = "Country is not valid";
            txt += "Valid values are ";
            
            for (var i in arr)
                if (arr[i]) txt += i + " ";
                document.getElementById("valid").innerHTML = txt;
        }
    }
</script>
</body>
</html>