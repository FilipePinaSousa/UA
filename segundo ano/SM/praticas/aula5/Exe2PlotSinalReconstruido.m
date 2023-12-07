% a)
Ta = 0.2;
T = 1 / Ta;

t = 0:Ta:5;  % Define the time vector
x = sin(2 * pi * t);  % Generate the signal x(t)

% Call the ReconstroiSinal function to reconstruct the signal
[y,t] = ReconstroiSinal(x, Ta);

% Plot the reconstructed signal
figure(1);
plot(t,y);
xlabel('Time (s)');
ylabel('Amplitude');
title('Reconstructed Signal');
grid on;

%%
% b)
Ta = 0.04;
T = 1 / Ta;

t = 0:Ta:5;  % Define the time vector
y = sin(10 * pi * t ) + cos(12 * pi * t) + cos(14 * pi * t  - pi/4);  % Generate the signal y(t)

% Call the ReconstroiSinal function to reconstruct the signal
[y,t]= ReconstroiSinal(y, Ta);

% Plot the reconstructed signal
figure(2);
plot(t, y);
xlabel('Time (s)');
ylabel('Amplitude');
title('Reconstructed Signal');
grid on;
