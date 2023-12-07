function Save8bitImage(Filename,Image)
    fid = fopen(Filename,'wb');
    [n,m] = size(Image);
    N = uint16(n);
    M = uint16(m);
    fwrite(fid,N,'uint16');
    fwrite(fid,M,'uint16');
    fwrite(fid,Image,'uint8');
    fclose(fid);
end