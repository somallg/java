<script src="jquery-latest.js"></script>
<table id="fruitTable">
	<tr>
		<th>Fruit</th>
		<th>Inventory</th>
	</tr>
</table>

<script>
var jsonFruit = {"apples": "12", "bananas": "18", "watermelon": "3"};

$.each(jsonFruit, function(key, val){
	// reverse order
// 	$("#fruitTable").after("<tr><td>" + key + "</td><td>" + val + "</td></tr>");

	// order
	$("<tr><td>" + key + "</td><td>" + val + "</td></tr>").appendTo("#fruitTable");
});

</script>