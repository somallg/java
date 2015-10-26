<script src="jquery-latest.js"></script>
<script>
var currencyRate;
function getExchangeRate() {
	$.ajax({
		cache: false,
		type: 'GET',
		url: "currencyConverter.json",
		data: { 'currencyType': getCurrencyType() },
		dataType: 'json',
		success: function(result) {
			console.log(result);
			currencyRate = result;	
		}
	});
}

function getCurrencyType() {
	return "USD";
}
</script>