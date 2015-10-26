# Test Data
* Generate a 1024-bit RSA private key
`$ openssl genrsa -out private_key.pem 1024`

* Generate public key
`$ openssl rsa -in private_key.pem -pubout -out public_key.pem`

* Convert private Key to PKCS#8 format (so Java can read it)
`$ openssl pkcs8 -topk8 -inform PEM -outform PEM -in private_key.pem -out private_key8.pem -nocrypt`