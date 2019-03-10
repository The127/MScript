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
