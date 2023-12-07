originalFile='Parede_8bit.bmp';
[Image, ColorMap] = imread(originalFile);
stream = EncodeImage_RLE(Image);
[N,M] = size(Image);
decompressed_image=DecodeImage_RLE(N, M, stream);

decompressed_image=uint8(decompressed_image);
figure(3)
colormap(ColorMap);
image(decompressed_image)