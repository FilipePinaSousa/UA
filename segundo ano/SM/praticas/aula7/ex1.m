load("Guitar03.mat");

%% ex 1

Espetro(x,1/fa);

%% ex 2

teta=2*pi*(5000/fa);

xr=x+ 0.6*cos(teta*(0:length(x)-1)'+0.1*pi);