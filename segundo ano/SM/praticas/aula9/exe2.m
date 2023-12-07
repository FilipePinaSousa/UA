f = [14 64 5 10 7];
numbits = [2 1 4 3 4];
compmensg = 10000;
[NumBits,NumBPS] = GeraMensagem(f,compmensg,numbits);
fprintf("numbits: %d numbps: %.4f\n",NumBits,NumBPS);