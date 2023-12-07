Ta = 0.01;
t = (0 : Ta : 2-Ta)';
sig = sin(2*pi*t);

%nbit=2
nbit = 2;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition2 = (-1+2*Delta/2 : Delta : 1-Delta/2 );
codebook2 = (-1+Delta/2 : Delta : 1-Delta/2);
[index2,quants2] = quantiz(sig,partition2,codebook2);

%nbits=3
nbit = 3;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition3 = (-1+2*Delta/2 : Delta : 1-Delta/2);
codebook3 = (-1+Delta/2 : Delta : 1-Delta/2);
[index3,quants3] = quantiz(sig,partition3,codebook3);

%nbits=4
nbit = 4;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition4 = (-1+2*Delta/2 : Delta : 1-Delta/2);
codebook4 = (-1+Delta/2 : Delta : 1-Delta/2);
[index4,quants4] = quantiz(sig,partition4,codebook4);

%com nbits=2
figure(1);
[X,fx] = Espetro(sig,Ta);
legend("Sinal original");
hold on;
[x,fx] = Espetro(quants2,Ta);
legend("Sinal quantizado");

%com nbits=3
figure(2);
[X,fx] = Espetro(sig,Ta);
legend("Sinal original");
hold on;
[x,fx] = Espetro(quants3,Ta);
legend("Sinal quantizado");

%com nbits=4
figure(3);
[X,fx] = Espetro(sig,Ta);
legend("Sinal original");
hold on;
[x,fx] = Espetro(quants4,Ta);
legend("Sinal quantizado");



