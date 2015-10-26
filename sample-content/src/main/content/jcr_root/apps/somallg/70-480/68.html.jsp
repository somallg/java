<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<input id="btnSubmit" type="button" value="Submit" onclick="disable(this)"/>
<input id="btnCancel" type="button" value="Submit" onclick="disable(this)"/>
<script>
    function disable(ctrl) {
        ctrl.disabled = true;
    }
</script>
</body>
</html>