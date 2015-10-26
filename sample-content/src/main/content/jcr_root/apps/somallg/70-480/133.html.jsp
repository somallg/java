<div id="display"></div>
<script>
	var myApp = {};
		(function() {
		this.loanAmount = 100;
		this.display = function(value) {
			document.getElementById('display').innerHTML += value;	
		};
		this.increaseLoanAmount = function() {
			this.loanAmount += 1000;
			return;
		};
		this.increaseLoanAmountAgain = function() {
			this.loanAmount += 1000;
			return;
		};
	}).apply(myApp);
	myApp.increaseLoanAmount();
	myApp.increaseLoanAmountAgain();
	
	myApp.display(myApp.loanAmount);
</script>