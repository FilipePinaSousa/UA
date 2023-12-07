Ta = 0.01;

%% a)
f=1;
T=1/f;
Np = 100;
N=round(Np*T/Ta);
t=(0:N-1)*Ta;

x = sin(2*pi*t);

[X,f]=Espetro(x,Ta);

%% b)
f = 1;
T = 1/f;
Np = 50;
N = round(Np * T / Ta);
t = (0:N-1) * Ta;

y = sin(10*pi*t) + cos(12*pi*t) + cos(14*pi*t - pi/4);

[X, f] = Espetro(y, Ta);

%% c)
f = 10;
T = 1/f;
Np = 100;
N = round(Np * T / Ta);
t = (0:N-1) * Ta;
z = 10 + 14*cos(20 * pi * t + pi/3) + 8 * cos(40 * pi *t + pi/2);
[X,f] = Espetro(z,Ta);
%% d)
% Define time parameters

T = 1;      % Period of the square wave (1 second)
Np = 5;     % Number of periods to record
N = round(Np * T / Ta);  % Number of samples

% Generate the square wave
t = (0:N-1) * Ta;
z = square(2 * pi * t);  % Create a square wave

% Plot the signal
figure(1)
plot(t, z);
xlabel('Time (s)');
ylabel('Amplitude');
title('Square Wave z(t)');


figure(2)
[X,f] = Espetro(z,Ta);
%% e)
% Define time parameters

T = 1;      % Period of the triangular wave (1 second)
Np = 5;     % Number of periods to record
N = round(Np * T / Ta);  % Number of samples

% Generate the triangular wave
t = (0:N-1) * Ta;
q = sawtooth(2 * pi * t, 0.5);  % Create a triangular wave

% Scale to the range [-1, 1]
q = q * 2 - 1;

% Plot the signal
figure(1)
plot(t, q);
xlabel('Time (s)');
ylabel('Amplitude');
title('Triangular Wave q(t)');

figure(2)
[X,f] = Espetro(z,Ta);
