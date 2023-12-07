function Image = Load8bitImage(Filename)
    fid = fopen(Filename,'rb');
    N = fread(fid,1,'uint16');
    M = fread(fid,1,'uint16');
    Image = fread(fid,[N,M],'uint8');
    fclose(fid);
end