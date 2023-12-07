%nbit=2
Ta = 0.01;
t = (0 : Ta : 2-Ta)';
sig = sin(2*pi*t);      %sinal/funçao a tratar
nbit = 2;               %numero de bits
amp=2*max(abs(sig));    %amplitude 
Npal = 2^nbit;          
Delta = amp/Npal;       %delta = amp/2^nbits
partition = -1+2*Delta/2 : Delta : 1-Delta/2;
codebook = -1+Delta/2 : Delta : 1-Delta/2;
[index,quants] = quantiz(sig,partition,codebook);

figure(1);
plot(t,sig,t,quants);
legend("Original signal", "Quantized signal");
grid