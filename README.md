# AllfilesBetter  
Windows 10 only.  
 
Collects contents of all files (only utf-8 coded text-files!) in the subdirectories of a directory.  
(Not in the directory itself!)   
Only files with an extension of "txt,bat,ssc,sc,scala,java,php,js,ahk,md,conf,ini" are considered.   
Outputfile is in the current dirctory, filename is generated from the input-pathname!  
Takes as input-directory: current directory or the first parameter.  

#### Latest changes:  
Version (>=)| Change
------------ | -------------
0.021 | globs "*.c", "*.cpp", "*.py"   too
0.019 | ignore empty lines in "allfilesBetterExclude.txt" 
0.018 | Exclude files \*1)
0.017 | globs "*.sql" too
0.016 | globs "*.txt" too
0.015 | Outputfile is written to the parent directory

\*1)  
Generate a file "allfilesBetterExclude.txt" in the **parent-directory** of the directory to scan,  
containig filenames to exclude (comma separated, no quotation-marks).   
Example:  
\Lib\,\_hidden\,updatertest,License.txt,fileunwanted.txt,filesecret.txt   
Excludes all pathes containing: \Lib\ or \_hidden\ or updatertest and all files named: fileunwanted.txt or filesecret.txt  
  
**Caution, the exclusion uses a simple text-containing compare of the path, so an entry "lib," would exclude every file containing "lib" in it's path or "lib" in it's name!**   
  
#### Known issues / bugs 
Issue / Bug | Type | fixed in version
------------ | ------------- | -------------
Ignores all files not in a subdirectory | bug | 0.015
  
  
#### Status: Usable.  

#### Requirements  
Java runtime = Java 8 and above.  

#### Files required in running directory
All source-files are UTF-8 (no BOM.  
  
* "allfilesBetter.exe" (Windows Startfile, portable, no installation).  
[Download allfilesBetter.exe from github](https://github.com/jvr-ks/allfilesbetter/raw/master/allfilesBetter.exe)   
Viruscheck see below.  

#### Start    
allfilesBetter.exe [directory to scan] [output-directory]
[directory to scan] is optional.  
[output-directory] is optional. 
  
#### Contextmenu integration:  
Make a backup of the registry!  
Take a look at "allfilesBetter.reg".   
Edit it to reflect location of "allfilesBetter.exe ".  
Use filemanager to doubleclick on "allfilesBetter.reg".  
 
#### File format:  
All files are UTF-8 (no BOM).  
  
#### Linux:  
* not supported  
(allfilesBetter-assembly-1.00.jar is not OS dependant).

#### Remarks:  
The jar-file has no versioning, i.e. is fixeed to "allfilesBetter-assembly-1.00.jar".   
  
#### Build from source:  
* To make an EXE the "exe4j" commercial Java jar to exe converter is required.    

##### License: MIT, -> MIT_License.txt  
Copyright (c) 2021 J. v.Roos.  

<a name="virusscan">


##### Viruscheck at Virustotal 
[Check here](https://www.virustotal.com/gui/url/67a597a303c2ee9987acc3cd009539e74442fc3eb44862465475f4bb4b4aabf2/detection/u-67a597a303c2ee9987acc3cd009539e74442fc3eb44862465475f4bb4b4aabf2-1649958014
)  
Use [CTRL] + Click to open in a new window! 
