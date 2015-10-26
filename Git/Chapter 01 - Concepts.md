# Chapter 01 - Concepts
* Git is built on a few simple and very powerful ideas. Knowing them helps to understand more easily how git works

# 1 Repository
* The Repository or Object Database stores all objects which make up the history of the project. All objects in this database are identified through a secure 20 byte SHA-1 hash of the object content
* Git has four object types:
    * A **Blob object** stores file content
    * A **Tree object** stores the directory structure and contains **Blob objects** and other **Three objects** together with their file system names and modes
    * A **Commit object** represents a snapshot of the directory structure at the time of the commit and has a link to its predecessor **Commit object** which form an acyclic graph of the repository revisions forming the repository history
    * A **Tag object** is a symbolic named link to another repository object which contains the objects name and type

* **Trust**
* Git provides a built-in trust chain through secure SHA-1 hashes which allows it to verify if objects obtained from a (potentially untrusted) source are correct and have not been modified since they have been created

# 2 Index
* The *Git Index* is a binary file stored in the *.git/index* directory containing a sorted list of filenames, file modes and file metadata used to efficiently detect file modifications. It also contains the SHA-1 object names of blob objects

* It has the following important properties:
    * The index contains all information necessary to generate a single uniquely defined tree object. E.g. a commit operation generates this tree, stores it in the object database and associates it with the commit
    * The index enables fast comparison of the tree it defines with the current working directory. This is archieved by storing additional meta data about the involved files in the index data
    * The index can efficiently store information about merge conflicts between the trees involved in the merge so that for each pathname there is enough information about the involved trees to enable a three-way merge

# 3 Branches
* A branch in Git is a named reference to a commit
* There are two types of branches, namely "Local" and "Remote Tracking"

## 3.1 Local Branches
* Whenever a change to a (local) Repository is committed, a new commit object is created

## 3.2 Remote Tracking Branches
* Remote tracking branches are created automatically when cloning and fetching from a remote repositories
* A remote tracking branche in the local repository always corresponds to a (local) branch in the remote repository

# 4 Working Directory
* The working directoy is the directory used to modify files for the next commit
* By default it is located one level about the .git directory
* Making a new commit typically involves the following steps:
    * Check out the branch the new commit shall be based on. This changes the working directory so that it reflects the *HEAD* revision of the branch
    * Do modifications in the working directory
    * Tell git about these modifications (add modified files). This transfers the modified file content into the object database and prepares the three to be committed in the index
    * Commit the tree prepared in the index into the object database
    * The result is a new commit object and the *HEAD* of the current branch moves to the new commit

# 5 Recording Changes in the Repository
* Each file in the working directory can either be *tracked* or *untracked*:
    * **Tracked** files are those which were in the last snapshot or files which have not yet been newly staged into the *index*. They can be *unmodified*, *modified*, or *staged*
    * **Untracked** files are all other files (they were not in the last snapshot and have not been added to the *index*)
