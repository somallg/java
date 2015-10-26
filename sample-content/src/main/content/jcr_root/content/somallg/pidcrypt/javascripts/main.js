function formatString(str)
{
  var tmp='';
  for(var i=0;i<str.length;i+=80)
    tmp += '   ' + str.substr(i,80) +'\n';
  return tmp;
}

function showData(tree) {
  var data = '';
  var val = '';
  if(tree.value)
   val = tree.value;
  data += tree.type + ':' +  val.substr(0,48) + '...\n';
  if(tree.sub)
    for(var i=0;i<tree.sub.length;i++)
      data += showData(tree.sub[i]);
  return data;
}

function certParser(cert){
  var lines = cert.split('\n');
  var read = false;
  var b64 = false;
  var end = false;
  var flag = '';
  var retObj = {};
  retObj.info = '';
  retObj.salt = '';
  retObj.iv;
  retObj.b64 = '';
  retObj.aes = false;
  retObj.mode = '';
  retObj.bits = 0;
  for(var i=0; i< lines.length; i++){
    flag = lines[i].substr(0,9);
    if(i==1 && flag != 'Proc-Type' && flag.indexOf('M') == 0)//unencrypted cert?
      b64 = true;
    switch(flag){
      case '-----BEGI':
        read = true;
        break;
      case 'Proc-Type':
        if(read)
          retObj.info = lines[i];
        break;
      case 'DEK-Info:':
        if(read){
          var tmp = lines[i].split(',');
          var dek = tmp[0].split(': ');
          var aes = dek[1].split('-');
          retObj.aes = (aes[0] == 'AES')?true:false;
          retObj.mode = aes[2];
          retObj.bits = parseInt(aes[1]);
          retObj.salt = tmp[1].substr(0,16);
          retObj.iv = tmp[1];
        }
        break;
      case '':
        if(read)
          b64 = true;
        break;
      case '-----END ':
        if(read){
          b64 = false;
          read = false;
        }
      break;
      default:
        if(read && b64)
          retObj.b64 += pidCryptUtil.stripLineFeeds(lines[i]);
    }
  }
  return retObj;
}

function compute(mode){

 // var hexStr = 'A3C9D10BDDC14811BC92E2D29282F62F1E449E2DD9B9CE3CA74D637ADAD49778BFEA4ACEE58C146E73E579876422871F625C8B0D2202131003C5A6C14F03493DB785B66A450A3418B2DC332A4A35AF7C89549B9902B2813CF79749198610F651ED33BE4C8B5753695F6D3461414C85C9237E67BB69A8A057A4841445A56955FA55ED27895A27FEB8A31453C6DE0B44259214AF1E23AA8011D68D2B115EE0D912B8E9C8F49D6A46685E778AC867BDD0361A52A7CE2F98702689D11E3BFB3746AB1F36F35033DA5FC38CA8F50178F6D2B37C39EEDABEF10FC0FD33E8FCED5A1D2677067B375DA83C9A8344391889FEE7B1BFC1282125563B3EDE479D4AD78CCF1F';

 // alert(hex2b64(hexStr) + '\n' + pidCryptUtil.encodeBase64(pidCryptUtil.convertFromHex(hexStr)));

  var theForm = window.document.theForm;
  var input = theForm.input.value;
  var crypted = theForm.crypted.value;
  var public_key = theForm.public_key.value;
  //var private_key = theForm.private_key.value;
  var params = {};
  var result = '';
  var color = '';
  document.getElementById('ENCRYPT').innerHTML = '';
  document.getElementById('DECRYPT').innerHTML =  '';
  document.getElementById('DEBUG').innerHTML = '';
  //read cert
  switch(mode){
    case 'encrypt':
      params = certParser(public_key);
      if(params.b64){
        var key = pidCryptUtil.decodeBase64(params.b64);
        //new RSA instance
        var rsa = new pidCrypt.RSA();
        //RSA encryption
        //ASN1 parsing
        var asn = pidCrypt.ASN1.decode(pidCryptUtil.toByteArray(key));
        var tree = asn.toHexTree();
        //setting the public key for encryption
        rsa.setPublicKeyFromASN(tree);
        var t = new Date();  // timer
        crypted = rsa.encrypt(input);
        console.log(crypted);
        var result = '<H3>Time for encryption:</H3>';
        result += '<FONT COLOR="009900"><pre>'+((new Date()) - t)/1000+' s</pre></font>';
        //result += '<H3>Text encrypted with public key as hex coded string</H3>';
        //result += '<FONT COLOR="009900"><PRE>' + pidCryptUtil.formatHex(crypted,63) + '</PRE></FONT>';
        result += '<h3>RSA encrypted text:</h3>';
        result += '<FONT COLOR="009900"><PRE>'+pidCryptUtil.fragment(pidCryptUtil.encodeBase64(pidCryptUtil.convertFromHex(crypted)),64) +'</PRE>';
        document.getElementById('ENCRYPT').innerHTML = result + '</FONT>';
        console.log(result);
        theForm.crypted.value = pidCryptUtil.fragment(pidCryptUtil.encodeBase64(pidCryptUtil.convertFromHex(crypted)),64);
        //theForm.input.value = '';
       } else alert('Could not find public key.');
     break;
   case 'decrypt':
     params = certParser(private_key);
     if(params.b64){
        key = pidCryptUtil.decodeBase64(params.b64);
        var rsa = new pidCrypt.RSA();
        //RSA decryption
        //ASN1 parsing
        asn = pidCrypt.ASN1.decode(pidCryptUtil.toByteArray(key));
        tree = asn.toHexTree();
        //alert(showData(tree));
        //setting the private key for encryption
        rsa.setPrivateKeyFromASN(tree);
        t = new Date();  // timer
        crypted = pidCryptUtil.decodeBase64(pidCryptUtil.stripLineFeeds(crypted));
        var decrypted = rsa.decrypt(pidCryptUtil.convertToHex(crypted));
        var result = '<h3>Time for decryption:</h3>'
        result += '<FONT COLOR="009900"><pre>'+((new Date()) - t)/1000+' s</pre></font>';
        result += '<H3>Text decrypted with private key</H3>';
        result += '<FONT COLOR="009900"><PRE>' + decrypted + '</PRE></FONT>';
        document.getElementById('DECRYPT').innerHTML = result;
        theForm.crypted.value = '';
        theForm.input.value = decrypted;
      }  else alert('Could not find private key.');
    break;
  }
}

var private_key_1024 = '-----BEGIN RSA PRIVATE KEY-----\n\
MIICXQIBAAKBgQDVd/gb2ORdLI7nTRHJR8C5EHs4RkRBcQuQdHkZ6eq0xnV2f0hk\n\
WC8h0mYH/bmelb5ribwulMwzFkuktXoufqzoft6Q6jLQRnkNJGRP6yA4bXqXfKYj\n\
1yeMusIPyIb3CTJT/gfZ40oli6szwu4DoFs66IZpJLv4qxU9hqu6NtJ+8QIDAQAB\n\
AoGADbnXFENP+8W/spO8Dws0EzJCGg46mVKhgbpbhxUJaHJSXzoz92/MKAqVUPI5\n\
mz7ZraR/mycqMia+2mpo3tB6YaKiOpjf9J6j+VGGO5sfRY/5VNGVEQ+JLiV0pUmM\n\
doq8n2ZhKdSd5hZ4ulb4MFygzV4bmH29aIMvogMqx2Gkp3kCQQDx0UvBoNByr5hO\n\
Rl0WmDiDMdWa9IkKD+EkUItR1XjpsfEQcwXet/3QlAqYf+FE/LBcnA79NdBGxoyJ\n\
XS+O/p4rAkEA4f0JMSnIgjl7Tm3TpNmbHb7tsAHggWIrPstCuHCbNclmROfMvcDE\n\
r560i1rbOtuvq5F/3BQs+QOnOIz1jLslUwJAbyEGNZfX87yqu94uTYHrBq/SQIH8\n\
sHkXuH6jaBo4lP1HkY2qtu3LYR2HuQmb1v5hdk3pvYgLjVsVntMKVibBPQJBAKd2\n\
Dj20LLTzS4BOuirKZbuhJBjtCyRVTp51mLd8Gke9Ol+NNZbXJejNvhQV+6ad7ItC\n\
gnDfMoRERMIPElZ6x6kCQQCP45DVojZduLRuhJtzBkQXJ4pCsGC8mrHXF3M+hJV+\n\
+LAYJbXrQa4mre59wR0skgb6CwGg1siMrDzJgu3lmBB0\n\
-----END RSA PRIVATE KEY-----';
var public_key_1024  = '-----BEGIN PUBLIC KEY-----\n\
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVd/gb2ORdLI7nTRHJR8C5EHs4\n\
RkRBcQuQdHkZ6eq0xnV2f0hkWC8h0mYH/bmelb5ribwulMwzFkuktXoufqzoft6Q\n\
6jLQRnkNJGRP6yA4bXqXfKYj1yeMusIPyIb3CTJT/gfZ40oli6szwu4DoFs66IZp\n\
JLv4qxU9hqu6NtJ+8QIDAQAB\n\
-----END PUBLIC KEY-----';

/*
var private_key_2048 = '-----BEGIN RSA PRIVATE KEY-----\n\
MIIEowIBAAKCAQEAo8nRC93BSBG8kuLSkoL2Lx5Eni3Zuc48p01jetrUl3i/6krO\n\
5YwUbnPleYdkIocfYlyLDSICExADxabBTwNJPbeFtmpFCjQYstwzKko1r3yJVJuZ\n\
ArKBPPeXSRmGEPZR7TO+TItXU2lfbTRhQUyFySN+Z7tpqKBXpIQURaVpVfpV7SeJ\n\
Wif+uKMUU8beC0QlkhSvHiOqgBHWjSsRXuDZErjpyPSdakZoXneKyGe90DYaUqfO\n\
L5hwJonRHjv7N0arHzbzUDPaX8OMqPUBePbSs3w57tq+8Q/A/TPo/O1aHSZ3Bns3\n\
Xag8moNEORiJ/uexv8EoISVWOz7eR51K14zPHwIDAQABAoIBAH6kADftmZHQ7P6h\n\
1PElw5ZBEAtCJnPNLAasBrwqUXBhE/rjJsBEJFQW1pq1/c3YroKOTZG09ueoXVJJ\n\
EnS2dL38la2q04EFMQeyzPjo8kOixkieGpwES3tJcTc7PfcFjekbNgvXPYkoE3nL\n\
o1srANK51/X66cJRYBK7cTU8pYqszQuaWlZYKzwrzxd4jhdIiRkb+zAG2+PXgPPM\n\
ajI8zX45LyGAhFcgxt2JXtqizvBHaxcR6CL5egZe2NDJamq1RAXOiGV3BGOqNckb\n\
WkPYmF+yM54c1r5dJmmhpaPyIF2caGqnqHrxdqa3DUCDNivO6GrphApaBCXC9ZHH\n\
7PZiS9kCgYEA14JDGE6XJ1h9+MobcOQ6M4raVcYM2tR0YfmDPgXfRVRNc34ibVaF\n\
7EoB3aRwELz174fln4K4c9Yq6BZetH1ZoTIHm8UO+9ZvOjTVzg5xQDk/xC6GKL/A\n\
QvuOEADiR+lkN/Vus8eKeYfp0ieQz83OYVVVJdrJmE1FT81/nr8Wqb0CgYEAwo/b\n\
FzOyQeKaPzlDh3bRHlyAD19nd4Ee5hVmMKUMgtHKcBmgXu5i/1l5TobPwyrKiiGC\n\
8LpvvDcGh5bvktbOBVbDjSzyiCn8KZOGP+nrM8BCUEtPAo/ibkaOi+C/m5kDGUb+\n\
ZzDsy4YUWxlnZrKBZjstCn6/nhAMztxrly2/1AsCgYAkvMv7RMp3ppoy4yEyaXWS\n\
e8UkghKG61i7qvE4jX+2LdzWJ1ZvFSTXVvZidjm0YMH8B0qZmosfFA9UaRvT4Np6\n\
pDCv2TPosnFbls4rxkKAFEJOiy/LmoSH5qIdEEmCwMKY13n7o7Rzazvs21nQUuEv\n\
roBJZ7aeA+4g4IM06JZQcQKBgQCEAr2iIYZ6o7kK2tzR5jF/iz2ssIvwjuCbNrvO\n\
l75EaPoVU533q4HqRhhDyr7faoJgdNp2Ydl8eE1q5GOLW0oQX01x1aR99RbOUvWN\n\
GjdnNrUH7AEg+OWm8yK3D/iSJ6Dtnrjw5UZV1ZSsNzFsggPAjLhD3bpAEh3Oocoy\n\
mm0E/wKBgGByZ91ABS7XUrqrjAbnrlJ/UBm2bTAOC6lSB1KzzI7VRwe44SpJRYc+\n\
bYaE0IxFFyf0dHPqw03MDX3lgtN+RwvUnveitSWVlKtzqiCFABA6MnRticlRBUJi\n\
tDiYGnVU6Enfiv3tcdiD2RM3eO8IErkxeUxVP4ALqcYlxdeN6NlH\n\
-----END RSA PRIVATE KEY-----';
var public_key_2048  = '-----BEGIN PUBLIC KEY-----\n\
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo8nRC93BSBG8kuLSkoL2\n\
Lx5Eni3Zuc48p01jetrUl3i/6krO5YwUbnPleYdkIocfYlyLDSICExADxabBTwNJ\n\
PbeFtmpFCjQYstwzKko1r3yJVJuZArKBPPeXSRmGEPZR7TO+TItXU2lfbTRhQUyF\n\
ySN+Z7tpqKBXpIQURaVpVfpV7SeJWif+uKMUU8beC0QlkhSvHiOqgBHWjSsRXuDZ\n\
ErjpyPSdakZoXneKyGe90DYaUqfOL5hwJonRHjv7N0arHzbzUDPaX8OMqPUBePbS\n\
s3w57tq+8Q/A/TPo/O1aHSZ3Bns3Xag8moNEORiJ/uexv8EoISVWOz7eR51K14zP\n\
HwIDAQAB\n\
-----END PUBLIC KEY-----';
*/


function callDecryptServlet() {
	$.ajax({
    	type: "POST",
    	url: "/somallg/rsa",
    	contentType: "application/json",
		data: JSON.stringify({response: $('#crypted').val()}),
    	success: function(data) {
    		$("#plain_text").val(data.response + " \nTime for decryption in miliseconds " + data.time);
    	}
    });	
}