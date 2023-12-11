function stream = EncodeImage_RLE(Imagem)
    [N,M] = size(Imagem); 
    color = uint8(0);
    k = 1;
    stream(k,1) = Imagem(1,1);
    for n= 1:N
        for m= 1:M 
            if Imagem(n,m) == stream(k,1)
                color = color + 1;
            else
                k = k+1;
                stream(k,1) = color;
                k = k+1;
                stream(k,1) = Imagem(n,m);
                color = 1;
            end
        end
    end
    k = k+1;
    stream(k,1) = color;
end