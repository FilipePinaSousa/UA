function [H, f] = respfreq(num, den, fa)
    % Calcula a resposta em frequência do sistema
    % Inputs:
    %   - num: Coeficientes do polinômio do numerador
    %   - den: Coeficientes do polinômio do denominador
    %   - fa: Frequência de amostragem
   
    N = 1024;
    H= freqz(num, den, N, fa, 'whole');
    H = abs(fftshift(H));
    f = (-N/2:N/2-1)*(fa/N);

    figure;
    plot(f, H);
    title('Resposta em Frequência');
    xlabel('Frequência (Hz)');
    ylabel('|H(f)|');
end
