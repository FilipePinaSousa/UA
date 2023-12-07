load("Guitar01.mat");
sound(x, fa);

Ta = 1/fa;
Espetro(x,Ta);
title("Espetro das notas musicais")
axis([-5e3 5e3 0 4e-3])