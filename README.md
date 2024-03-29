# AllfilesBetter  
Windows 10 only.  

#### Status: Usable.  

#### Latest changes:  

Version (>=)| Change
------------ | -------------
0.022 | File-extensions definable  

#### Known issues / bugs 
Issue / Bug | Type | fixed in version
------------ | ------------- | -------------
Ignores all files not in a subdirectory | bug | 0.015
  
#### Description
Collects contents of all files (only utf-8 coded text-files!) in all subdirectories of a directory,   
including the directory itself!  
Outputfile is in the current directory, filename is generated from the input-pathname!  
Takes as input-directory: the current directory or the first parameter,  
or use the Contextmenu integration.  
File-extensions may be defined in the file "allfilesBetterExtensions.txt".  

#### File-extensions
Generate a file "allfilesBetterExtensions.txt" in the **parent-directory** of the directory to scan,  
containig file-extensions to include (comma separated, no quotation-marks),  
default values are:  
txt,bat,ssc,sc,scala,java,php,css,js,ahk,md,conf,ini,sql,c,cpp,py

#### File/directory-exclusions
Generate a file "allfilesBetterExclude.txt" in the **parent-directory** of the directory to scan,  
containig filenames to exclude (comma separated, no quotation-marks).   
Example:  
\Lib\,\_hidden\,updatertest,License.txt,fileunwanted.txt,filesecret.txt   
Excludes all pathes containing: \Lib\ or \_hidden\ or updatertest and all files named: fileunwanted.txt or filesecret.txt  
  
**Caution, the exclusion uses a simple text-containing compare of the path,  
so an entry "lib," would exclude every file containing "lib" in it's path or "lib" in it's name!**   
  
#### Contextmenu integration:  
Make a backup of the registry!  
Take a look at "allfilesBetter.reg" (Windows 10 specific).   
Edit it to reflect location of "allfilesBetter.exe ".  
Use filemanager to doubleclick on "allfilesBetter.reg".  

#### Start  
If you made a contextmenu entry just use the filemanager and right-click onto the directory of interest.  
  
Otherwise copy "allfilesBetter.exe" to a folder listed in the window path,  
example: "c:\tools".  
Allfilesbetter must be called with the parameter:  
allfilesBetter.exe [directory to scan] 
(absolut directory expected!).  

On the commandline use:  
allfilesBetter.exe "%cd%\subdirectory of interest",  
inside a batchfile use:  
allfilesBetter.exe "%~dp0\subdirectory of interest", 
 
If "allfilesBetter.exe" is not in the windows path,  
call it with the complete pathname, example:
"c:\xyz\allfilesBetter.exe" "%cd%\subdirectory of interest"
  
[output-directory] is optional if omitted the current directory is used.   
  
The generate output-filename is made of the directory-name with the extension ".txt".  
The colon and all back-slashes are replace by an underscore-charater. 


#### Requirements  
Java runtime = Java 8 and above.  

#### Files required in running directory
All source-files are UTF-8 (no BOM.  
  
* "allfilesBetter.exe" (Windows Startfile, portable, no installation).  
[Download allfilesBetter.exe from github](https://github.com/jvr-ks/allfilesbetter/raw/master/allfilesBetter.exe)   
Viruscheck see below. 
 
#### File format:  
All files are UTF-8 (no BOM).  
  
#### Linux:  
* not supported  
(allfilesBetter-assembly-1.00.jar is not OS dependant).

#### Remarks:  
The jar-file has no versioning, i.e. is fixed to "allfilesBetter-assembly-1.00.jar".   
  
#### Build from source:  
* To make an EXE the "exe4j" commercial Java jar to exe converter is required.    

##### License: MIT, -> MIT_License.txt  
Copyright (c) 2021 J. v.Roos.  

<a name="virusscan">


##### Viruscheck at Virustotal 
[Check here](https://www.virustotal.com/gui/url/67a597a303c2ee9987acc3cd009539e74442fc3eb44862465475f4bb4b4aabf2/detection/u-67a597a303c2ee9987acc3cd009539e74442fc3eb44862465475f4bb4b4aabf2-1686910462
)  
Use [CTRL] + Click to open in a new window! 
