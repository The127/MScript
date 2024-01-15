def db as base;
def d0 as GasSensor;
def d1 as WallCooler;
def d2 as WallHeater;

def $midTemp as 23;
def $lowTemp as 20;
def $highTemp as 26;

fn main (){
    var getTemp;
    var cooling;
    var heating;
    loop {
        read GasSensor.Temperature into getTemp;
        read WallCooler.On into cooling;
        read WallHeater.On into heating;
        getTemp = round(getTemp);
    }
}