<label for="loanTypes">Loan Types</label>
<select name="loanTypes" id="loanTypes" multiple="multiple">
	<option>Secured</option>
	<option selected="selected">Unsecured</option>
	<option>Demand</option>
	<option selected="selected">Subsidized</option>
</select>
<script src="jquery-latest.js"></script>
<script>
var selectedValue = '';
$("#loanTypes option:selected").each(function() {
	selectedValue += $(this).text() + ",";		
});
</script>