function [N, M, stream_6]=Load8bitStream(filename)
fid = fopen(filename,'rb');
N = fread(fid,1,'uint16');
M = fread(fid,1,'uint16');
stream_6 = fread(fid,'uint8');
fclose(fid);
end