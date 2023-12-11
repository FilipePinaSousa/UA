Filename="imagem_a_criar.raw";
originalFile='Parede_8bit.bmp';
[Image, ColorMap] = imread(originalFile); %lê imagem
Save8bitImage(Filename, Image);
[N, M, Im]= Load8bitImage(Filename);
Im = uint8(Im);    %terá a ver com a codificação em 8 bits
stream = EncodeImage_RLE(Im);
Save8bitStream('exercicio5.str',N,M,stream); 
filecriado='exercicio5.str';
[N, M, stream_6]=Load8bitStream(filecriado);
if length(stream)==length(stream_6)
    fprintf("\tAs streams são iguais\n")
else
    fprintf("\tAs streams são diferentes\n")
end