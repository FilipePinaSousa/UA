function [NumBits,NumBPS] = GeraMensagem(f,CompMesg,nBits)
%UNTITLED Sumario desta function esta aqui
%   informaçao detalhada
N = length(f);
NumBits = 0;
Mesg = randsample(1:length(f),CompMesg,true,f/sum(f));
for n=1:N
    NumBits = NumBits + sum(Mesg == n)*nBits(n);
end
NumBPS = NumBits / CompMesg;
end