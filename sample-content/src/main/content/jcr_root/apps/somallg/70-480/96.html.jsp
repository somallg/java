<script>
function showLoanAmounts() {
	var loanAmount = 400;
	function showSomeLoanAmount() {
		var loanAmount = 800;
		function showAnotherLoanAmount() {
			var loanAmount = 1000;
			alert(loanAmount);
		}
		showAnotherLoanAmount();
		alert(loanAmount);
	}
	showSomeLoanAmount();
	alert(loanAmount);
}
</script>