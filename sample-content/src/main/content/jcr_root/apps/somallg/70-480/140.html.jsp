<script>
	function add(v1, v2) {
		return v1 + v2 + this.v3 + this.v4;
	}
	
	function addValues() {
		var o = { v3: 10, v4: 13 };
		var res = add.call(o, 15, 3);
		
		return res;
	}
</script>