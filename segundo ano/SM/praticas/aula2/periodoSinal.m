function T = periodoSinal(N, f)
    % Número de harmônicos
    n = 1:N;

    % Cálculo dos períodos individuais dos componentes
    T_individual = 1 ./ f;

    % Cálculo do período do sinal composto (mínimo múltiplo comum)
    T = lcm(T_individual);

    % Exibição dos períodos individuais
    disp('Períodos individuais:');
    disp(T_individual);

    % Exibição do período do sinal composto
    disp('Período do sinal composto:');
    disp(T);
end



N = 3             % Número de harmônicos
A = [1, 0.5, 0.25]; % Coeficientes de amplitude
f = [2, 3, 4];      % Frequências
phi = [0, pi/4, pi/2]; % Deslocamentos de fase

T = periodoSinal(N, A, f, phi);
