%exercicio 3 plot do grafico de uma funcao em 3D


x=linspace(-2,2);
y=linspace(-2,2);
[xx,yy]=meshgrid(x,y);
f=exp(-xx.^2-yy.^2);
surf(xx,yy,f)
shading interp