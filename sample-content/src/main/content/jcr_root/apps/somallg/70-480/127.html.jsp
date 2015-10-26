<!DOCTYPE html>
<html>
	<head>
		<script src="jquery-latest.js"></script>
	</head>
	<body>
		<p>Type OK to validate form.</p>
		<form action="javascript:alert('success!');">
			<div>
				<input type="text"/>
				<input type="submit"/>
			</div>
		</form>
		<script>
			$("form").submit(function() {
				if ($("input:first").val().match("OK")) {
					return true;
				}
				
				return false;
			});
		</script>
	</body>
</html>