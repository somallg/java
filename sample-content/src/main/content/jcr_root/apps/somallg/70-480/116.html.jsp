<!DOCTYPE html>
<head>
	<style>
		#span1 {
			position: relative;		
			color: red;
		}
		#span2 {
			position: absolute;	
			top:200px;
			left: -100px;
			height: 130px;
			width: 130px;
			color: green;
		}
	</style>
	<body>
		<p>Start of main contents.
			<span id="span1">Start of span1 contents.	
			<span id="span2">Start of span2 contents.</span>
			End of span1 content.</span>
			End of main contents.
		</p>
	</body>
</head>