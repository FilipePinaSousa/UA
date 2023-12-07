function Simbolos = Alfabeto1(Texto)
    Simbolos = cell2mat(split(unique(Texto),""));
end