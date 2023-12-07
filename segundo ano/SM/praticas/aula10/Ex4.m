Filename = "imagem_a_criar.raw";
[Image, ColorMap] = imread("Parede_8bit.bmp"); 
Save8bitImage(Filename, Image);
image = Load8bitImage(Filename);
Imagem = uint8(image);    
stream = EncodeImage_RLE(Imagem);