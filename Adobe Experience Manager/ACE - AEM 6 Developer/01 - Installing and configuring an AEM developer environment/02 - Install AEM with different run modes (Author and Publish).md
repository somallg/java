# Author and Publish Installs
* The default install (an **author** instance on **localhost:4502**) can be changed by renaming the **jar** file before launching it for the fist time
* The nameing pattern is
```
cq-<instance-type>-p<port-number>.jar
```
* Example, renaming file and launching will result an author instance running on **localhost:4502**
```
cq-author-p4502.jar
```
* Similarly, renamind and lauching will result in a publish instance running on **localhost:4503**
```
cq-publish-p4503.jar
```
* You would install these two instances in
```
<aem-install>/
	author
	publish
```