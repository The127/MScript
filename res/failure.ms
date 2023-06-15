def db as Base;
def d0 as GasSensor;
def d1 as OutputHeat;
def d2 as OutputCool;

def $MinTemp as 293.15;
def $MaxTemp as 303.15;

def $On as 1;
def $Off as 0;

fn check_heat(temp, min_temp) {
    if (temp < min_temp) {
        return 1;
    } else {
        return 0;
    }
}

fn check_cool(temp, max_temp) {
    if (temp > max_temp) {
        return 1;
    } else {
        return 0;
    }
}

/*
    Behavior:
    If the temperature is below $MinTemp, turn on the heat.
    If the temperature is above $MaxTemp, turn on the cool.
*/
fn main() {
    var temp;

    var setting;

    loop {
        read GasSensor.Temperature into temp;
        write temp into Base.Setting;

        setting = check_heat(temp, $MinTemp);
        write setting into OutputHeat.Setting;

        setting = check_cool(temp, $MaxTemp);
        write setting into OutputCool.Setting;

        yield;
    }
}