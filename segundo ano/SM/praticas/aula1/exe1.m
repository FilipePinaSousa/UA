x  = linspace(-2*pi,0,200);
fx = sin(x).*exp(x);
 
axis([-8 0 -0.5 0.8])
xlabel("x")
ylabel("y")
plot(x,fx,"--r")
grid