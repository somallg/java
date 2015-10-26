<script>
function Person(name, age) {
	this.name = name;
	this.age = age;
};

Person.prototype = (function() {
	function toString() {
		return this.name + " is " + this.age;
	};
	
	return {
		constructor: Person,
		toString: function() {
			return toString.call(this);
		}
	};
})();
</script>