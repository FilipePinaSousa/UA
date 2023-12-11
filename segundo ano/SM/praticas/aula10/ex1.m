[Image, ColorMap] = imread("Parede_8bit.bmp");

Save8bitImage("out.txt", Image);

[N, M, Im] = Load8bitImage("out.txt");