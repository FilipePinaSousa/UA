% Alinea a)
Ta = 0.01;

t = 0:Ta:1;
x = 2 * sin(4 * pi * t);
figure(1) % Added figure command to create a new figure
plot(t, x)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("x(t)") % Added a legend label
grid on % Use grid on to enable the grid

%%
% Alinea b)
t = 0:Ta:1;
y = sin(10*pi*t + pi/2);
figure(2)
plot(t, y)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("y(t)")
grid on

%%
% Alinea c)
t = 0:Ta:1;
p = sin(20 * pi * t + 70 * pi/180) + sin(20 * pi * t + 200 * pi/180);
figure(3)
plot(t, p)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("p(t)")
grid on


%%
% Alinea d)
t = 0:Ta:10;
z = sin(6 * pi * t) + sin(8 * pi * t);
figure(4)
plot(t, z)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("z(t)")
grid on






%%
% Alinea e)
t = 0:Ta:5;
w = sin(6 * pi * t) + sin(8 * pi * t + 0.1);
figure(5)
plot(t, w)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("w(t)")
grid on

%%
% Alinea f)
t = 0:Ta:5;
q = sin(6 * pi * t) + sin(7 * pi * t) + sin(8 * pi * t);
figure(6)
plot(t, q)
xlabel("tempo(x)")
ylabel("amplitude(a)")
legend("q(t)")
grid on


