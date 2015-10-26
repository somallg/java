<ul id="languages">
	<li>HTML</li>
	<li>JavaScript</li>
	<li>ASP</li>
	<li>ASP.NET</li>
</ul>

<script>
var languages = [];

var items = document.getElementsByTagName("li");

for (var i = 0, l = items.length; i < l; i++) {
	languages.push(items[i].innerHTML);
}

languages.sort();

for (var i = 0, l = items.length; i < l; i++) {
	items[i].innerHTML = languages[i];
}

</script>