def removeAdjacentDuplicates(s):
   chars = []
   prev = None

   for c in s:
      if prev != c:
         chars.append(c)
         prev = c

   return ''.join(chars)



   ###### ou #####
   def removeAdjacentDuplicates(s):
    lst = []
    for i in s:
                lst.append(i)
    while True:
                prev_lst = lst[:]
                i = 1
                while i < len(lst):
                    if lst[i - 1] == lst[i]:
                        lst.pop(i)
                    i += 1
                if prev_lst == lst:
                    break
        
    s = ""
    s = s.join(lst)
    return s