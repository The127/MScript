[![Build Status](https://travis-ci.com/The127/MScript.svg?branch=master)](https://travis-ci.com/The127/MScript)
[![codecov](https://codecov.io/gh/The127/MScript/branch/master/graph/badge.svg)](https://codecov.io/gh/The127/MScript)
[![codebeat badge](https://codebeat.co/badges/e032e201-9cb4-4c9d-91b9-07fbc0b0bab9)](https://codebeat.co/projects/github-com-the127-mscript-master)

MScript
=======

MScript is a language for writing scripts for ICs in [Stationeers](https://store.steampowered.com/app/544550/Stationeers/).
Stationeers uses an assembler based language (a variant of MIPS) to program ICs.
This can make writing scripts extremely tedious and hard to understand/document/reuse.
This project aims to fix this by introducing a higher level language that compiles to Stationeers Mips.

How to build
------------

To build the program use eclipse or follow the following instructions (Linux).

1. Clone project and cd into the folder
```BASH
git clone https://github.com/The127/MScript.git
cd MScript
```

2. Compile the Java code using ANT
```BASH
ant build
```
This should have created a *bin* folder with the compiled *.class* files.

3. Copy the ANTLR library into bthe bin folder, extract it and remove not needed files (ANTLR library is in the *lib* folder and may have another version number)
```BASH
cp lib/antlr-runtime-4.7.2.jar bin
cd bin
unzip antlr-runtime-4.7.2.jar
rm -rf META-INF
rm antlr-runtime-4.7.2.jar
```

4. Create the jar and copy it to the root folder
```BASH
jar cvfm MScript.jar ../MScript.mf *
cd ..
mv bin/MScript.jar .
```

Now you should have the MScript.jar in the projects root folder.

How to use
----------

```BASH
java -jar MScript.jar ./res/test.ms
```
or more generally
```BASH
java -jar MScript.jar <file>
```

The language (MScript)
----------------------

MScript is inspired by other high level (namely python, rust and c).

The following example is a basic solar angle automation script.
```
def db as base;
def d0 as SolarSensor;

def $RotationDegrees as 100;
def $SolarDegrees as 180;

fn main (){
	var winkel;
	loop {
		read SolarSensor.SolarAngle into winkel;
		winkel = calc(winkel, 1);
		write winkel into base.Setting;
		yield;
	}
}

fn calc(winkel, b) {
	var result;
	result = winkel * $RotationDegrees / $SolarDegrees;
	return result;
}
```

This will result in the following:
```
push ra
l r4 d0 SolarAngle
jal 25
push r4
push 1
jal 22
jal 12
jal 31
pop r4
s db Setting r4
yield
j 1
push ra
push r0
push 100.0
jal 38
push 180.0
jal 42
pop r4
pop r14
push r4
j r14
pop r1
pop r0
j ra
push r0
push r1
push r2
push r3
push r4
j ra
pop r12
pop r4
pop r3
pop r2
pop r1
pop r0
j 45
pop r13
pop r12
mul r12 r12 r13
j 45
pop r13
pop r12
div r12 r12 r13
push r12
j ra
```

Note that you still need to place your physical items accordingly.

Examples can be found under the [examples folder](https://github.com/The127/MScript/tree/master/examples).

A guide for the language can be found [here](https://docs.google.com/document/d/1M8d57R9WbtqjTNA2tzuSM31L_ZZOvkGa2NnwqqJ3Cwk/edit?usp=sharing).
