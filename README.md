[![Build Status](https://travis-ci.com/The127/MScript.svg?branch=master)](https://travis-ci.com/The127/MScript)
[![codecov](https://codecov.io/gh/The127/MScript/branch/master/graph/badge.svg)](https://codecov.io/gh/The127/MScript)
[![codebeat badge](https://codebeat.co/badges/e032e201-9cb4-4c9d-91b9-07fbc0b0bab9)](https://codebeat.co/projects/github-com-the127-mscript-master)

MScript
=======

MScript is a language for writing scripts for ICs in [Stationeers](https://store.steampowered.com/app/544550/Stationeers/).
Stationeers uses an assembler based language (a variant of MIPS) to program ICs.
This can make writing scripts extremely tedious and hard to understand/document/reuse.
This project aims to fix this by introducing a higher level language that compiles to Stationeers Mips.


The language (MScript)
----------------------

MScript is inspired by other high level (namely python, rust and c).

The following example is a basic solar angle automation script.
```
def db as base;
def d0 as SolarSensor;

def $RotationDegrees = 100;
def $SolarDegrees = 180;

fn main() {
    var angle;
    loop {
        read SolarSensor.SolarAngle into angle;
        angle = calc(angle);
        write angle into base.Setting;
        yield;
    }
}

fn calc(angle) {
    var result;
    result = angle * $RotationDegrees / $SolarDegrees;
    return result;
}
```
Note that you still need to place your physical items accordingly.

Examples can be found under the [examples folder](https://github.com/The127/MScript/tree/master/examples).

A guide for the language can be found [here](https://docs.google.com/document/d/1M8d57R9WbtqjTNA2tzuSM31L_ZZOvkGa2NnwqqJ3Cwk/edit?usp=sharing).
