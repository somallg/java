<style>
    input:disabled {
        background-color: #e0e0e0;
    }
</style>
<input name="ITSupport" type="checkbox" value="IT" id="IT" onclick="enable();"/>
<label for="IT">IT Support</label>

<input type="email" placeholder="IT@abc.com" id="eMail" name="eMail" disabled/>
<label for="eMail">Your eMail</label>
<script>
    function enable(e) {
        if (document.getElementById('IT').checked) {
            document.getElementById('eMail').disabled = false;
        } else {
            document.getElementById('eMail').disabled = true;
        }
    }
</script>