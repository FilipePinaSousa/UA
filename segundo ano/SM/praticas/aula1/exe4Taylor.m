% funçao de Taylor
function s = exe4Taylor(N, x)

s = 0;
for n = 1:N
    n_sym = n;  % Atribua o valor de n à variável simbólica
    s = s + (x^n_sym / factorial(n_sym)) * sin(n_sym * pi / 2);
end
