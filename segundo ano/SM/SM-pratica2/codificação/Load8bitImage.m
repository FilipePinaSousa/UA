function [N, M, Image] = Load8bitImage(Filename)
%LOAD8BITIMAGE Summary of this function goes here
%   Detailed explanation goes here
fid = fopen(Filename,'rb');
N = uint16(fread(fid,1,'uint16'));
M = uint16(fread(fid,1,'uint16'));
Image = uint8(fread(fid,[N,M],'uint8'));
fclose(fid);
end

