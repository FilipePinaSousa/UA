%dois graficos
w = linspace(0,2*pi,200)
fw = sin(4*w).*exp(1i * w);
gw = sin(8*w).*exp(1i * w);


plot(w,fw,"g--");
hold on
plot(w,gw,"r--");