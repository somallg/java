<div ondrop="myApp.drop(this, event)" ondragenter="return false" ondragover="return false">
	<p>Fruit</p>
</div>
<p>
<img src="apple.jpg" id="apple" alt="Apple" ondragstart="myApp.drag(this, event)" draggable="true">
<img src="orange.jpg" id="orange" alt="Orange" ondragstart="myApp.drag(this, event)" draggable="true">
<img src="strawberry.jpg" id="strawberry" alt="Strawberry" ondragstart="myApp.drag(this, event)" draggable="true">
<img src="banana.jpg" id="banana" alt="Banana" ondragstart="myApp.drag(this, event)" draggable="true">
</p>
<script>
var myApp = {};
(function() {
	this.drag = function(target, e) {
		e.dataTransfer.setData('text', target.id);
	};
	this.drop = function(target, e) {
		var id = e.dataTransfer.getData('text');
		target.appendChild(document.getElementById(id));
		e.preventDefault();
	}
}).apply(myApp);
</script>