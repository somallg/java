<!doctype html>
<html>
<head>
    <script>
        function readXMLFile() {
           if (window.XMLHttpRequest) {
               xmlhttp = new XMLHttpRequest();
           } else {
               xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
           }
            xmlhttp.open("GET", "message.xml", false);
            xmlhttp.send();
            xmlDoc = xmlhttp.responseXML;

            document.getElementById("to").innerHTML = xmlDoc.getElementsByTagName("to")[0].childNodes[0].nodeValue;
            document.getElementById("from").innerHTML = xmlDoc.getElementsByTagName("from")[0].childNodes[0].nodeValue;
            document.getElementById("message").innerHTML = xmlDoc.getElementsByTagName("message")[0].childNodes[0].nodeValue;
        }
    </script>
</head>
<body onload="readXMLFile()">
    <div id="to"></div>
    <div id="from"></div>
    <div id="message"></div>
</body>
</html>