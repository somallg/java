<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <style>
    	#container > ul {
    		border: 1px solid black;
    	}
    </style>
</head>
<body>
	<div id="container">
		<ul>
			<li>First List Item
				<ul>
					<li>Child List Item</li>
				</ul>
			</li>
			<li>Second List Item</li>
			<li>Third List Item</li>
			<li>Fourth List Item</li>
		</ul>
		<p>Lorem ipsum dolor sit amet, cu pro probo ludus sententiae</p>
		<p>Has aeque tation ancillae ea</p>
	</div>
	<script>
/* 		$("div").each(function() {
			$("ul").each(function(index, domEle) {
				$(domEle).css("border", "1px solid black");
			});
		}); */
		
		//$("div#container > ul").css("border", "1px solid black");
		
		//$("ul:first-of-type").css("border", "1px solid black");
	</script>
</body>
</html>