<html>
<head>
<style>
.hover {
	border: solid #f00 3px;
}

.no_hover {
	border: solid #000 3px;
}
</style>
</head>
<body>
<div id="header" class="no_hover"><h1>Header</h1></div>
<button type="button" id="btn1">Click to Add</button>
<button type="button" id="btn2">Click to Remove</button>
<script src="../jquery-latest.js"></script>
<script>
$(document).ready(function() {
	$("#btn1").click(function() {
		$("#header").addClass("hover");
		$("#header").removeClass("no_hover");
	});

	$("#btn2").click(function() {
		$("#header").removeClass("hover");
		$("#header").addClass("no_hover");
	});
})
</script>
</body>
</html>