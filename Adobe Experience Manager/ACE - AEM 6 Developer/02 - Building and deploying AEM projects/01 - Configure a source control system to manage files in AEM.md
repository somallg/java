# How to use VLT Tool
* FileVault tool (VLT) is a tool developed by Adobe that maps the content of a CRX/CQ instance to your file system
* VLT has similar funtions as source control system client (SVN, GIT), providing
	* Check-in
	* Check-out
	* Management operations
	* Configuration options
	
## Getting Started with VLT
* Steps
	1. Install VLT, update environment variables, update global ignored subversion files
	2. Set up the CRX/CQ repository
	3. Check out CRX/CQ repository
	4. Synchronize with the repository
	5. Test whether the synchronization worked
	
## Installing the VLT Tool
1. Copy the FileVault archive file from cq-quickstart/opt/filevault. Copy either filevault.tgz or filevault.zip
2. Extract the archive
3. Add archive-dir/vault-cli-version/bin to environment PATH
4. Open command line and execute vlt --help

* Edit svn settings and add
```
[miscellany]
### Set global-ignores to a set of whitespace-delimited globs
### which Subversion will ignore in its 'status' output, and
### while importing or adding files and directories.
global-ignores = .vlt
```

## Configuration End of Line Character
* VLT automatically handles EOF according
	* lines of files checked out on Windows end with CRLF
	* lines of files checked out on Unix end with LF
	* lines of files commited to the repository end with a LF
	
* To guarantee VLT and SVN configuration match, set up svn:eol-style property to native
```
[auto-props]
*.css = svn:eol-style=native
*.cnd = svn:eol-style=native
*.java = svn:eol-style=native
*.js = svn:eol-style=native
*.json = svn:eol-style=native
*.xjson = svn:eol-style=native
*.jsp = svn:eol-style=native
*.txt = svn:eol-style=native
*.html = svn:eol-style=native
*.xml = svn:eol-style=native
*.properties = svn:eol-style=native
```

## Setting up CRX/CQ Repository
* Install CRX or CQ and start the instance

## Checking out the repository
* Check out the repository using the source control system
```
svn co http://svn.server.com/repos/myproject
```

## Synchronizing with the Repository
1. In the command line, navigate to **content/jcr_root**
2. Check out the repository by end the following command
```
vlt --credentials admin:admin co --force http://localhost:4502/crx
```	

## Testing Whether the Synchronization Worked
1. Edit some jsp file (e.g text.jsp)
2. See the modified files with: vlt st
3. See the changes with: vlt diff text.jsp
4. Commit the changes: vlt ci test.jsp
6. Reload a page containing a text.jsp

## Getting Help with the VLT Tool
* Use --help
```
vlt --help
```
* For help on a particular command, type help command followed by the name of the command
```
vlt --help export
```

## Common Tasks Performed in VLT

### Checking Out a SubTree
```
vlt co http://localhost:4502/crx/-/jcr:root/apps/geometrixx geo
```
* Doing this creates a new export root **geo** with a **META-INF** and **jcr-root** and puts all files below **/apps/geometrixx** in **geo/jcr_root**

### Performing a Filtered Checkout
* If you have an existing workspace filter and you want to use it for checkout, you can either create the **META-INF/vault** directory and place the filter there, or specify it on the command line
```
vlt -co --filter filter.xml http://localhost:4502/crx/-/jcr:root geo
```

* Example filter
```
<?xml version="1.0" encoding="UTF-8"?>
<workspaceFilter version="1.0">
    <filter root="/etc/designs/geometrixx" />
    <filter root="/apps/geometrixx"/>
</workspaceFilter>
```

## Using VLT
* Syntax
```
vlt [options] <command> [arg1 [arg2 [arg3] ..]]
```

### VLT Global Options
Option | Description
-------|------------
-Xjcrlog arg | Extended JcrLog option
-Xdavex arg  | Extended JCR remoting options
--credentials arg | default credentials to use
--config arg | JcrFs config to use
-v (--verbose) | verbose output
-q (--quiet) | print as little as possible
--log-level level | indicates log level
-h (--help) command | prints help

### VLT Commands

## Setting up FileVault sync
* vault sync service is used to synchronize repository content with a local file system and vice versa
* This is archived by installing an OSGi service that will listend for repository changes and will scan file system content periodically
* sync service only works with local file system and cannot be used for remote development

### Installing the Service Using VLT
* Command
```
vlt sync install
```

### Displaying Service Status
* Use *status* command
```
vlt sync status --uri http://localhost:4502/crx
```

### Adding a sync folder
* Use *register* command
```
vlt sync register
```

### Removing a sync folder
* Use *unregister* command 
