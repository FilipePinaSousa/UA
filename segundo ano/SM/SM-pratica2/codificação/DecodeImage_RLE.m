function decompressed_image = DecodeImage_RLE(N, M, stream)
    decompressed_image=zeros(N, M);
    n=1; m=1;
    for i= 1:2:length(stream)  
        valor=stream(i);
        nVezes=stream(i+1);
        for N= 1:nVezes
            decompressed_image(n, m) = valor;
            if m == M %chega ao final da linha, por isso tem de mudar sendo a coluna seguinte o 1
                m = 1; 
                n = n+1;
            else
                m = m+1;
            end
        end
    end
end