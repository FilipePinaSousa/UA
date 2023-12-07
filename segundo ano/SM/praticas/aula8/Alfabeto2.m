function [Simbolos, frequencia] = Alfabeto2(Texto)
    Simbolos = cell2mat(split(unique(Texto),""));
    for t= 1:length(Simbolos)
        frequencia(t) =  count(Texto, Simbolos(t))/length(Texto);
        fprintf("%c aparece %f%s das vezes \n ", Simbolos(t), frequencia(t), "%");
    end
end