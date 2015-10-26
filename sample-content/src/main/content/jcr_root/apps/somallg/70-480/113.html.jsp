<script>
var Customer = function() {
	var name = "Contoso";
	return {
		getName: function() {
			return name;
		},
		setName: function(newName) {
			name = newName;
		}
	};
}();


alert(Customer.name);
</script>
