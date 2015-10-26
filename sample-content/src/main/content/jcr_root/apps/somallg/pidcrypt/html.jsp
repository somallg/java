<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <title>RSA Demo</title>
</head>

<body>
<h1>RSA Demo</h1>
<form name="theForm">
    Text:
    <br>
    <input name="input" type="text" value="sample@mail.com" maxlength="87" size="67">
    <br>
    <p>
       <input value="Encrypt" type="BUTTON" onclick="compute('encrypt');">
    </p>
    <p>
        Encrypted text:
        <br>
        <textarea id="crypted" name="crypted" rows="4" cols="65"></textarea>
        <br>
        <br>
    </p>
    <p>
        RSA Public Key:
        <br>
        <textarea id="public_key" name="public_key" rows="6" cols="65">-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIxArQvR/0ehyGbbcoD+A6E0Ev
C0zPLl80CZpnlYqkB7g36w+y2Z1Z8FRB7vVq62gNgA3pxyQbA2n/gkY+9ymmle3o
3DvyaaXYRPUPynLdDMFz+jUuZY4LrFN3ryXfH85z4UfcQ2caA22Uvfj6EGkJxABt
LVMq6Io6rnthGI7DDwIDAQAB
-----END PUBLIC KEY-----</textarea>
        <br>
        <br>
    </p>
<!--     <p>
        RSA Private Key:
        <br>
        <textarea id="private_key" name="private_key" rows="15" cols="65"></textarea>
    </p> -->
</form>
<hr>
<a id="results"></a>
<p></p>
<h2>Results:</h2>
<div id="ENCRYPT"></div>
<br>
<div id="DECRYPT"></div>
<br>
<div id="DEBUG"></div>
<br>
<hr>
<p>
	<input value="Decrypt" type="BUTTON" onclick="callDecryptServlet();">
</p>
<p>
        Plain text:
        <br>
        <textarea id="plain_text" name="plain_text" rows="5" cols="65"></textarea>
</p>
<script src="javascripts/pidcrypt.js"></script>
<script src="javascripts/pidcrypt_util.js"></script>
<script src="javascripts/asn1.js"></script>
<script src="javascripts/jsbn.js"></script>
<script src="javascripts/rng.js"></script>
<script src="javascripts/prng4.js"></script>
<script src="javascripts/rsa.js"></script>
<script src="javascripts/jquery-2.1.3.js"></script>
<script src="javascripts/main.js"></script>
</body>
</html>