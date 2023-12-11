function Save8bitStream(filename, N, M, stream)
    fid = fopen(filename, 'wb'); 
    fwrite(fid, N, 'uint16'); %escreve o N em int16
    fwrite(fid, M, 'uint16'); 
    fwrite(fid, stream, 'uint8'); 
    fclose(fid); 
end