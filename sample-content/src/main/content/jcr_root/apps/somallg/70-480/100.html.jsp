<!DOCTYPE html>
<html>
	<head>
		<style>
			#top {
				width: 100%;
				height: 200px;
				background-color: violet;
			}
			
			#content {
				display: flex;
				flex-direction: row;
				width: 100%;
			}
			
			#content #left {
				width: 200px;
				height: 300px;
				background-color: lightblue;
			}

			#content #right {
				width: 200px;
				height: 300px;
				background-color: green;
			}
			
			#content #main {
				flex: 1;
			}
			
			#bottom {
				width: 100%;
				height: 200px;
				background-color: brown;
			}
		</style>
	</head>
	<body>
		<div id="top"></div>
		<div id="content">
			<div id="left"></div>
			<div id="main"></div>
			<div id="right"></div>
		</div>
		<div id="bottom"></div>
	</body>
</html>