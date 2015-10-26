Integer 1: <input type="text" id="int1"/><br/>
Integer 2: <input type="text" id="int2"/><br/>
<input type="button" name="add" value="Add" onclick="add();"/>
<input type="button" name="deived" value="Divide" onclick="divide();"/>

<script src="jquery-latest.js"></script>
<script type="text/javascript">
    onerror = unhandled;
    function unhandled (msg, url, line) {
        alert(msg);
        alert('There has been an unhandled exception');
    }
    
    function add() {
        alert($("#int1").val() + $("#int2").val());
    }
    
    function divide() {
        if (isNaN($("#int1").val()) || isNaN($("#int2").val())) {
            throw('One or more values are non-numeric');
        }
        alert($("#int1").val() / $("#int2").val());
    }
</script>