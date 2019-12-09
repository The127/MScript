def db as base;

fn main (){
var x;
loop {
x=calc(5);
write x into base.Setting;
yield;
}
}


fn calc(b) {
if(b<=5){b=b+1;}
return b;
}