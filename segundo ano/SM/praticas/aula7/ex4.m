load Guitar03.mat

[x2,fa2] = audioread("vozportugues.wav");

x2 = x2(1:round(length(x2)*1/10));

%% a)
% sim

%% b)
ts = 34/340;
D = round(ts*fa2)*10;
a=0.9;
num=[1 zeros(1,D-1) a];
den=1;

[H,f] = respfreq(num,den,fa2);

figure(1)
plot(f,H)

y = filter(num,den,x2);

figure(2);
subplot(1,2,1);
spectrogram(x2,1024,512,1024,fa2,"yaxis");
subplot(1,2,2);
spectrogram(y,1024,512,1024,fa2,"yaxis");

% soundsc(y, fa)

%% c)
% bananas

%% d)
D = 8;
a = 0.9;
num=1;
den=[1 zeros(1,D-1) -a];

[H,f] = respfreq(num,den,fa2);

figure(1)
plot(f,H)

y = filter(num,den,x2);

figure(2);
subplot(1,2,1);
spectrogram(x2,1024,512,1024,fa2,"yaxis");
subplot(1,2,2);
spectrogram(y,1024,512,1024,fa2,"yaxis");

% soundsc(y, fa)

%% e)
ts = 1/100;
D = round(ts*fa);
a = 0.9;
num=1;
den=[1 zeros(1,D-1) -a];

[H,f] = respfreq(num,den,fa);

figure(1)
plot(f,H)

y = filter(num,den,x);

figure(2);
subplot(1,2,1);
spectrogram(x,1024,512,1024,fa,"yaxis");
subplot(1,2,2);
spectrogram(y,1024,512,1024,fa,"yaxis");

soundsc(y, fa)


