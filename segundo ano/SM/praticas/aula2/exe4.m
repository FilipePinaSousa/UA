Ta = 0.001;
N = 3;
A = [1,1,1];
f = [10,20,30];

mdc1 = gcd(f(1),f(2));
f1 = gcd(mdc1,f(3));
T = 1/f1;

t = 0:Ta:4*T;

psi = rand(1,3)*2*pi-pi;

soma = 0;
for i = 1:N
    soma = soma + A(i)*sin(2*pi*f(i)*t+psi(i));
end

plot(t,soma);

p = CalculaPotencia(soma,Ta,T);
