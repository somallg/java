<!DOCTYPE html>
<html>
	<head>
		<script type="text/javascript">
			function check1(currentTextBox) {
				if (currentTextBox.value === null || currentTextBox.value === '') {
					currentTextBox.style.background = '#fffacd';
				} else {
					currentTextBox.style.background = '#ffffff';
				}
			}
			
			function check2() {
				var obj = document.getElementsByTagName('input');
				for (var i = 0; i < (obj.length - 1); i++) {
					obj[i].style.background = '#fffacd';
				}
			}
		</script>
	</head>
	<body>
		<input type="text" id="text1" onfocus="check1(this)" onblur="check1(this)">
		<input type="text" id="text2" onfocus="check1(this)" onblur="check1(this)">
		<input type="button" value="next" onclick="check2()">
	</body>
</html>