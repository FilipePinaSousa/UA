
x =linspace(0,2*pi);
f=sin(x);
serie = exe4Taylor1(x,4);
plot(x,f,"r","SeriesIndex","b")
legend("sen","serie")