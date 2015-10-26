<form>
	<label for='city'>City:</label>
	<select id='city'>
		<option>Please Choose</option>
		<option>Moscow</option>
		<option>London</option>
		<option>Paris</option>
	</select>
	<input type='button' id='submit' value='Submit'
	onclick="makeSelection(document.getElementById('city'), 'Please Select a City')"/>
</form>

<script>
function makeSelection(element, message) {
	console.log(element);
	if (element.value === 'Please Choose') {
		alert(message);
		element.focus();
		return false;
	} else {
		return true;
	}
}
</script>