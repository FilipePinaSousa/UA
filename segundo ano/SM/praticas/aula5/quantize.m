%nbit=2
Ta = 0.01;
t = (0 : Ta : 2-Ta)';
sig = sin(2*pi*t);
nbit = 2;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition = [-1+2*Delta/2 : Delta : 1-Delta/2];
codebook = [-1+Delta/2 : Delta : 1-Delta/2];
[index,quants] = quantiz(sig,partition,codebook);

figure(1);
plot(t,sig,t,quants);
legend("Original signal", "Quantized signal");
grid

%nbit=3
Ta = 0.01;
t = (0 : Ta : 2-Ta)';
sig = sin(2*pi*t);
nbit = 3;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition = -1+2*Delta/2 : Delta : 1-Delta/2;
codebook = -1+Delta/2 : Delta : 1-Delta/2;
[index,quants] = quantiz(sig,partition,codebook);

figure(2);
plot(t,sig,t,quants);
legend("Original signal", "Quantized signal");
grid

%nbit=4
Ta = 0.01;
t = (0 : Ta : 2-Ta)';
sig = sin(2*pi*t);
nbit = 4;
amp=2*max(abs(sig));
Npal = 2^nbit;
Delta = amp/Npal;
partition = -1+2*Delta/2 : Delta : 1-Delta/2;
codebook = -1+Delta/2 : Delta : 1-Delta/2;
[index,quants] = quantiz(sig,partition,codebook);

figure(3);
plot(t,sig,t,quants);
legend("Original signal", "Quantized signal");
grid

