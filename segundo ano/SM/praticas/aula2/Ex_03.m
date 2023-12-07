%a)
Ta = 0.01; % Sample period

% Calculation of frequency and period
frequencia = 4; % Adjust the frequency as needed
T = 1 / frequencia;

% Create a time vector with integer increment
t = 0:Ta:T;

% Signal x(t)
x = 2 * sin(2 * pi * t);

% Calculate the power
potencia_a = Potencia(x, Ta, T);
%%
%ALINEA b)
Ta = 0.01;

frequencia = (10*pi)/(2*pi) + (pi/2)/(2*pi);
T = 1/frequencia;

t = 0:Ta:4*T;

y = sin(10*pi*t + pi/2);

potencia_b = Potencia(x,Ta,T);
%%
%ALINEA c)
p = sin(20*pi*t + (70*pi)/180) + sin(20*pi*t + (200*pi)/180);

plot(t,p,'b');
legend("p(t)");
grid;
%%
%ALINEA d)
z = sin(6*pi*t) + sin(8*pi*t);

plot(t,z,'r');
legend("z(t)");
grid;

%%
%ALINEA e)
w = sin(6*pi*t) + sin(8*pi*t + 0.1);

plot(t,w,'r');
legend("w(t)");
grid;

%%
%ALINEA f)
q = sin(6*pi*t) + sin(7*pi*t) + sin(8*pi*t);

plot(t,q,'r');
legend("w(t)");
grid;






